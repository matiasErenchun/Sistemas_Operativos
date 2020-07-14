#include <stdio.h>
#include <pthread.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int escrituras=5;


typedef struct mutex
{
    pthread_mutex_t mutex_file;
    char archivo[100];

}mutex_file;


void *escribir(void *arg)
{
    mutex_file *A;
    A=(mutex_file *)arg;
    FILE *file;
    file=fopen(A->archivo,"w");
    if((file == NULL))
    {
        printf("Error en apertura del fichero \n");
    }
    else{
        srand(time(NULL));
        int i = 0;
        while (i < escrituras)
        {
            pthread_mutex_lock(&A->mutex_file);
            int p = pthread_self();
            int muertoshoy= rand()%(11);
            char hola[100];
            snprintf(hola,100,"%d",muertoshoy);

            char muertos[]="muertos ";
            strcat(muertos,hola);

            printf("hola %d escribe\n", p);
            fputs(muertos,file);
            fputs("\n",file);
            pthread_mutex_unlock(&A->mutex_file);
            sleep(1);
            i++;
        }
        fclose(file);
    }
}

void *leer( void *arg)
{
    struct mutex *A;
    A=(struct mutex *)arg;
    int i =0;
    while (i<escrituras)
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
    strcpy(mutex_file1.archivo,file1);
    strcpy(mutex_file2.archivo,file2);

    printf("archivo 1 %s\n",mutex_file1.archivo);
    printf("archivo 2 %s\n",mutex_file2.archivo);



    pthread_t pid_lectores[2];
    pthread_t pid_escritores[2];


    for (int i = 0; i < 2; i++)
    {
        pthread_create(&pid_lectores[i], NULL, leer, (void *)&mutex_file1);
    }

    for (int i = 0; i < 2; i++)
    {
        pthread_create(&pid_escritores[i], NULL, escribir, (void *)&mutex_file2);
    }

    for (int i = 0; i < 2; i++)
    {
        pthread_join(pid_lectores[i], NULL);
    }

    for (int i = 0; i < 2; i++)
    {
        pthread_join(pid_escritores[i], NULL);
    }


}