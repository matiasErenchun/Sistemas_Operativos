#include <stdio.h>
#include <pthread.h>
#include <unistd.h>
#include <stdlib.h>


int dia=1;
int medicosEsperando1=0, labEsperando1=0, sevicioEsperando1=0;
pthread_mutex_t mutex_medico, mutex_laboratorio;
pthread_cond_t condicionservicio1, condicionmedicos1, condicionEscritor1;


void preEscribir(pthread_mutex_t *mutex,pthread_cond_t *condicion,int Esperando, int servicioEsperando)
{
	pthread_mutex_lock(&mutex);
    while(Esperando > 0 || servicioEsperando >0 )
    {
        int p=pthread_self();
        Esperando++;
        
        printf("medicos esperando esperando %d id hilo actual%d\n",Esperando,p);
        sleep(1);
        pthread_cond_wait(&condicion,&mutex);
        Esperando--;
        printf("medicos esperando %d id hilo actual %d\n",Esperando,p);
        sleep(1);
    }
    numeroLectores++;
    pthread_cond_signal(&condicionmedicos);
    pthread_mutex_unlock(&mutex);
}

void escribir( char *archivo[])
{
	int p=pthread_self();
	printf("inserte codigo de escritura\n");
	printf("hilo %d escribe una linea \n",p);
}

void posEscribir(pthread_mutex_t *mutex,int servicioEsperando)
{
	pthread_mutex_lock(&mutex);
    if(servicioEsperando > 0)
    {
        pthread_cond_signal(&condicionEscritores);
    }
    pthread_mutex_unlock(&mutex_monitor);
}

void medico(pthread_mutex_t *mutex_medico, pthread_cond_t *condicionmedicos1, char *archivo[])
{
  while(dia>0)
  {
  	preEscribir();
  	escribir( char *archivo[]);
  	posEscribit();

  }

}

void laboratorio(pthread_mutex_t *mutex)
{

}

void sistema_salud_regional()
{

	pthread_t pid_medicos[2], pid_laboratorios[2];
	for (i = 0; i < 2; i++) 
	{
        pthread_create(&pid_medicos[i], NULL, medico, NULL);
    }

    for (i = 0; i < lectores; i++) 
    {
        pthread_create(&pid_laboratorios[i], NULL, laboratorio, NULL);
    }

    for (i = 0; i < escritores; i++) 
    {
        pthread_join(pid_medicos[i], NULL);
    }

    for (i = 0; i < lectores; i++) 
    {
       	pthread_join(pid_laboratorios[i], NULL);
   	}
}


int main(int argc, char *argv[]) {
  printf("Hello World\n");
  return 0;
}