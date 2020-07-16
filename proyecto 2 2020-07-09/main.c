#include <stdio.h>
#include <pthread.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int ESCRITURAS=5;
int NUM_MEDICOS=2;
int NUM_LABS =2;


typedef struct mutex
{
    pthread_mutex_t mutex_file;
    FILE *file;
    char *texto;
    int valor_random;

}mutex_file;


void *escribir(void *arg)
{
    mutex_file *A;
    A=(mutex_file *)arg;
    srand(time(NULL));
    int i = 0;
    while (i < ESCRITURAS)
    {
        pthread_mutex_lock(&A->mutex_file);
        int p = pthread_self();
        int muertoshoy= rand()%(A->valor_random);
        char hola[100];
        snprintf(hola,100,"%d",muertoshoy);

        char muertos[100];
        stpcpy(muertos,A->texto);
        strcat(muertos,hola);

        printf("hola %d escribe\n", p);
        fputs(muertos,A->file);
        fputs("\n",A->file);
        pthread_mutex_unlock(&A->mutex_file);
        sleep(1);
        i++;

    }
}

void *leer( void *arg)
{
    struct mutex *A;
    A=(struct mutex *)arg;
    int i =0;
    while (i<ESCRITURAS)
    {
        pthread_mutex_lock(&A->mutex_file);
        int p=pthread_self();
        printf("hola %d lee\n",p);
        pthread_mutex_unlock(&A->mutex_file);
        sleep(1);
        i++;
    }

}




void main()
{
    struct mutex mutex_file1,mutex_file2;
    pthread_mutex_init(&mutex_file1.mutex_file,NULL);
    pthread_mutex_init(&mutex_file2.mutex_file,NULL);
    char *file1="file1.txt";
    char *file2="file2.txt";
    char *texto1="infectados ";
    char *texto2="muertos ";
    mutex_file1.texto=texto1;
    mutex_file2.texto=texto2;
    mutex_file1.valor_random=100;
    mutex_file2.valor_random=10;
    mutex_file1.file=fopen(file1,"w+");
    mutex_file2.file=fopen(file2,"w+");
    if((mutex_file1.file == NULL || mutex_file2.file== NULL))
    {
        printf("Error en apertura del fichero \n");
    } else{
        pthread_t pid_labs[NUM_LABS];
        pthread_t pid_medicos[NUM_MEDICOS];


        for (int i = 0; i < NUM_LABS; i++)
        {
            pthread_create(&pid_labs[i], NULL, escribir, (void *)&mutex_file1);
        }

        for (int i = 0; i < NUM_MEDICOS; i++)
        {
            pthread_create(&pid_medicos[i], NULL, escribir, (void *)&mutex_file2);
        }

        for (int i = 0; i < NUM_LABS; i++)
        {
            pthread_join(pid_labs[i], NULL);
        }

        for (int i = 0; i < NUM_MEDICOS; i++)
        {
            pthread_join(pid_medicos[i], NULL);
        }
        fclose(mutex_file1.file);
        fclose(mutex_file2.file);
    }








}