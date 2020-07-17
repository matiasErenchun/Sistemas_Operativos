#include <stdio.h>
#include <pthread.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>


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
        strcat(muertos,"\n");
        fputs(muertos,A->file);
        pthread_mutex_unlock(&A->mutex_file);
        sleep(1);
        i++;

    }
}


int contarfilas(struct mutex *t)
{
    char algo[100];
    int i=0;
    while(!feof(t->file))
    {
        fgets(algo,100,t->file);
        i++;
    }
    return i;
}

void leer(struct mutex *sfile1,struct mutex *sfile2,struct mutex *files_destino)
{

//-----------desde aqui leemos los infectados
    pthread_mutex_lock(&sfile1->mutex_file);
    char caracteres[100];
    int infectados_total=0;
    int largo=contarfilas(sfile1);
    rewind(sfile1->file);
    printf("largo %d\n", largo);
    int i=1;
    while (i<largo)
    {
        fgets(caracteres,100,sfile1->file);
        printf("%s",caracteres);
        char delimitador[] = " ";//caracter que usamos para dividir el string en tokens

        char *token = strtok(caracteres, delimitador);
        if(token != NULL){
            //sacamos el primer token no nos interesa
            token = strtok(NULL, delimitador);//sacamos el segundo token que si nos interesa es el numero de infectados
            if(token!=NULL)
            {
                int a;
                a=atoi(token);
                infectados_total+=a;
            }
        }
        i++;
    }
    pthread_mutex_unlock(&sfile1->mutex_file);
    printf("hola1 \n");
    //-----------desde aqui leemos los muertos

    pthread_mutex_lock(&sfile2->mutex_file);
    char caracteres2[100];
    int muertos_total=0;
    largo=contarfilas(sfile2);
    rewind(sfile2->file);
    printf("largo %d \n", largo);
    i=1;
    while (i<largo)
    {
        fgets(caracteres2,100,sfile2->file);
        printf("%s \n",caracteres2);
        char delimitador[] = " ";
        char *token = strtok(caracteres2, delimitador);
        if(token != NULL)
        {
            //sacamos el primer token no nos interesa
            token = strtok(NULL, delimitador);//sacamos el segundo token que si nos interesa es el numero de infectados
            if(token!=NULL)
            {
                int a=0;
                a=atoi(token);
                printf("%d \n",a);
                muertos_total+=a;
            }
        }
        i++;

    }
    pthread_mutex_unlock(&sfile2->mutex_file);
    //--------------aqui los escribimos en el archivo general
    char n_muertos[100];
    char n_infectados[100];
    snprintf(n_muertos,100,"%d",muertos_total);
    snprintf(n_infectados,100,"%d",infectados_total);
    fputs("muertos ",files_destino->file);

    fputs(n_muertos,files_destino->file);
    fputs(" infectados: ",files_destino->file);
    fputs(n_infectados,files_destino->file);
    fputs("\n",files_destino->file);
}

