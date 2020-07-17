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
    mutex_file *A;// asis e pasa un struct a una funcion, se pasa como void
    A=(mutex_file *)arg;//luego haces un cast al tipo de struct que es
    srand(time(NULL));//esto genera una semilla seudo aleatorea con la hora, para el random
    int i = 0;
    while (i < ESCRITURAS)//en este caso use un numero limitado de escrituras pero podria hacerse eterno con un while 1
    {
        pthread_mutex_lock(&A->mutex_file);//lock al mutex del archivo correspondiente al struct
        int p = pthread_self();// obtenemos el numero del hilo
        int muertoshoy= rand()%(A->valor_random);// mediante el random sacamos la cantidad de muertos de hoy
        char hola[100];// creamos un arreglo  para guardar el numero cuando lo pasemos a string
        snprintf(hola,100,"%d",muertoshoy);// esto pasa un entero a un string ( en realidad lo copia XD )

        char muertos[100];
        stpcpy(muertos,A->texto);//aqui obtenemos  la frase que acompaña al numero a  escribir
        strcat(muertos,hola);// concatenamos lo string sumamos el valor del segundo argumento a primero

        printf("hola %d escribe\n", p);
        strcat(muertos,"\n");// le agregamos un salto d elinea al final
        fputs(muertos,A->file);//escribimos en archivo
        pthread_mutex_unlock(&A->mutex_file);// desbloqueamos el mutex
        sleep(1);
        i++;

    }
}


int contarfilas(struct mutex *t)//esta funcion cuenta las final de un archivo que este en un struct mutex
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

void leer(struct mutex *sfile1,struct mutex *sfile2,struct mutex *files_destino)// aqui requerimos los 3 struct  para poder trabajar con los 3 archivos
{

//-----------desde aqui leemos los infectados
    pthread_mutex_lock(&sfile1->mutex_file);
    char caracteres[100];
    int infectados_total = 0;
    int largo = contarfilas(sfile1);
    rewind(sfile1->file);//esto es para hacer que el puntero del lecto este en la primera linea
    printf("largo %d\n", largo);
    int i = 1;
    while (i < largo) {
        fgets(caracteres, 100, sfile1->file);//leemos linea a linea
        printf("%s", caracteres);
        char delimitador[] = " ";//caracter que usamos para dividir el string en tokens

        char *token = strtok(caracteres, delimitador);
        if (token != NULL) {
            //sacamos el primer token no nos interesa
            token = strtok(NULL, delimitador);//sacamos el segundo token que si nos interesa es el numero de infectados
            if (token != NULL) {
                int a;
                a = atoi(token);
                infectados_total += a;
            }
        }
        i++;
    }
    pthread_mutex_unlock(&sfile1->mutex_file);
    printf("hola1 \n");
    //-----------desde aqui leemos los muertos

    pthread_mutex_lock(&sfile2->mutex_file);
    char caracteres2[100];
    int muertos_total = 0;
    largo = contarfilas(sfile2);
    rewind(sfile2->file);
    printf("largo %d \n", largo);
    i = 1;
    while (i < largo) {
        fgets(caracteres2, 100, sfile2->file);
        printf("%s \n", caracteres2);
        char delimitador[] = " ";
        char *token = strtok(caracteres2, delimitador);
        if (token != NULL) {
            //sacamos el primer token no nos interesa
            token = strtok(NULL, delimitador);//sacamos el segundo token que si nos interesa es el numero de infectados
            if (token != NULL) {
                int a = 0;
                a = atoi(token);
                printf("%d \n", a);
                muertos_total += a;
            }
        }
        i++;

    }
    pthread_mutex_unlock(&sfile2->mutex_file);
    //--------------aqui los escribimos en el archivo general
    //faltaria agregar los mutex del archivo 3

    char n_muertos[100];
    char n_infectados[100];
    snprintf(n_muertos, 100, "%d", muertos_total);
    snprintf(n_infectados, 100, "%d", infectados_total);
    fputs("muertos ", files_destino->file);

    fputs(n_muertos, files_destino->file);
    fputs(" infectados: ", files_destino->file);
    fputs(n_infectados, files_destino->file);
    fputs("\n", files_destino->file);
}

int  main()
{
    struct mutex mutex_file1,mutex_file2,mutex_file3;//declaramos los struct
    pthread_mutex_init(&mutex_file1.mutex_file,NULL);//inisializamos los mutex
    pthread_mutex_init(&mutex_file2.mutex_file,NULL);
    pthread_mutex_init(&mutex_file3.mutex_file,NULL);

    char *file1="file1.txt";// los nombres con los que trabaja este archivo
    char *file2="file2.txt";
    char *file3="file3.txt";
    char *texto1="infectados ";//el texto a aagregar cuando escribimos
    char *texto2="muertos ";
    mutex_file1.texto=texto1;//le asignamos los string al struct
    mutex_file2.texto=texto2;
    mutex_file3.texto=" ";

    mutex_file1.valor_random=101;// le damos los valores maximos al random para cada archivo
    mutex_file2.valor_random=11;
    mutex_file3.valor_random=0;

    mutex_file1.file=fopen(file1,"w+");//abrimos los archivos de manera tal que sobre escriban los archivos existentes
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
        mutex_file1.file=fopen(file1,"r");//esta opcion es solo lectura 
        mutex_file2.file=fopen(file2,"r");
        mutex_file3.file=fopen(file3,"a");//  esta opcion abre el archivo para agregar cosas en al ultima linea
        leer(&mutex_file1, &mutex_file2, &mutex_file3);
        fclose(mutex_file1.file);
        fclose(mutex_file2.file);
        fclose(mutex_file3.file);
    }
    return 0;

}


