//
// Created by onibushi on 25-05-20.
// al ejecutar el rograma se tiene que ingresar el numero de lectores,
// luego el numero de escritores
//
#include <unistd.h>
#include <stdlib.h>
#include "pthread.h"
#include "stdio.h"

int numeroLectores=0, numeroEscritores=0, escritoresEsperando=0, lectoresEsperando=0, lecturas=1, escrituras=1;
pthread_mutex_t mutex_monitor;
pthread_cond_t condicionLectores, condicionEscritores;


void pre_leer()
{
    pthread_mutex_lock(&mutex_monitor);
    while(numeroEscritores > 0)
    {
        int p=pthread_self();
        lectoresEsperando++;
        sleep(1);
        printf("lectores esperando %d id hilo actual%d\n",lectoresEsperando,p);
        sleep(1);
        pthread_cond_wait(&condicionLectores,&mutex_monitor);
        lectoresEsperando--;
        sleep(1);
        printf("lectores esperando %d id hilo actual %d\n",lectoresEsperando,p);
        sleep(1);
    }
    numeroLectores++;
    pthread_cond_signal(&condicionLectores);
    pthread_mutex_unlock(&mutex_monitor);

}

void post_leer()
{
    pthread_mutex_lock(&mutex_monitor);
    numeroLectores--;
    if(numeroLectores == 0)
    {
        pthread_cond_signal(&condicionEscritores);
    }
    pthread_mutex_unlock(&mutex_monitor);

}

void pre_escribir()
{
    pthread_mutex_lock(&mutex_monitor);
    while ((numeroEscritores > 0) || (numeroLectores > 0))
    {
        int p=pthread_self();
        escritoresEsperando++;
        sleep(1);
        printf("escritores esperando %d id hilo actual%d\n",escritoresEsperando,p);
        sleep(1);
        pthread_cond_wait(&condicionEscritores,&mutex_monitor);
        escritoresEsperando--;
        sleep(1);
        printf("escritores esperando %d id hilo actual%d\n",escritoresEsperando,p);
        sleep(1);
    }
    numeroEscritores++;
    pthread_mutex_unlock(&mutex_monitor);
}

void post_escribir()
{
    pthread_mutex_lock(&mutex_monitor);
    numeroEscritores--;
    if(lectoresEsperando > 0)
    {
        pthread_cond_signal(&condicionLectores);
    }
    else{
        pthread_cond_signal(&condicionEscritores);
    }
    pthread_mutex_unlock(&mutex_monitor);
}

void escribir()
{
    int p=pthread_self();
    printf("hilo %d escribe una linea \n",p);
    sleep(1);
}

void *funcionEscribir(void *p)
{
    int i;
    for (i=0; i<escrituras ; i++)
    {
        pre_escribir();
        escribir();
        post_escribir();
    }
}
void leer()
{
    int p=pthread_self();
    printf("hilo %d lee una linea \n",p);
    sleep(1);
}

void *funcionLeer(void *p)
{
    int i;
    for (i=0; i<lecturas ; i++)
    {
        pre_leer();
        leer();
        post_leer();
    }
}


int main(int argc, char *argv[])
{

    if (argc!=3)
    {
        printf("error en  numero  elementos ingresados \n");
    }
    else{
        printf(" ");
        char *charl=argv[1];
        char *chares=argv[2];

        int N_lectores =  atoi(charl);
        int N_escritores = atoi( chares);
        pthread_t pid_lectores[N_lectores], pid_escritores[N_escritores];
        int i;
        int lectores = N_lectores, escritores = N_escritores;

        printf("lectores: %d, escritores: %d \n",lectores,escritores);

        pthread_mutex_init(&mutex_monitor, NULL);
        pthread_cond_init(&condicionEscritores, NULL);
        pthread_cond_init(&condicionLectores, NULL);

        for (i = 0; i < escritores; i++) {
            pthread_create(&pid_escritores[i], NULL, funcionEscribir, NULL);
        }

        for (i = 0; i < lectores; i++) {
            pthread_create(&pid_lectores[i], NULL, funcionLeer, NULL);
        }

        for (i = 0; i < escritores; i++) {
            pthread_join(pid_escritores[i], NULL);
        }

        for (i = 0; i < lectores; i++) {
            pthread_join(pid_lectores[i], NULL);
        }

    }
}

