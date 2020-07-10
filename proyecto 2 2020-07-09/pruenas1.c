#include <pthread.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

typedef struct smedico
{
  pthread_mutex_t mutex_medico;
  int medicosEsperando;
  int servicioEsperando;
  pthread_cond_t condicionservicio ;
  pthread_cond_t condicionmedicos;
  int continuar;

}smedico;

void preescribir(struct smedico)
{
	pthread_mutex_lock(&mutex_medico);
    while ((smedico->medicosEsperando > 0) || (smedico->servicioEsperando > 0))
    {
        int p=pthread_self();
        smedico->medicosEsperando++;
       
        printf("escritores esperando %d id hilo actual%d\n",escritoresEsperando,p);
        sleep(1);
        pthread_cond_wait(&smedico->condicionmedicos,&smedico->mutex_medico);
        smedico->medicosEsperando--;
        printf("escritores esperando %d id hilo actual%d\n",escritoresEsperando,p);
        sleep(1);
    }
    smedico->medicosEsperando++;
    pthread_mutex_unlock(&smedico->mutex_medico);
}

void escribir()
{
  int p=pthread_self();
  printf("%d escribo algo \n",p);
}

void postescribir(struct smedico)
{
	pthread_mutex_lock(&smedico->mutex_medico);
	smedico->medicosEsperando--;
    if(smedico->servicioEsperando > 0)
    {
        pthread_cond_signal(&smedico->condicionservicio);
    }
    else{
        pthread_cond_signal(&smedico->condicionmedicos);
    }
    pthread_mutex_unlock(&smedico->mutex_medico);
}

void *medico(void *arg)
{
  struct smedico *A;
  A=(struct smedico *)arg;

  while((smedico->continuar) > 0)
  {
  	preescribir(A);
  	escribir();
  	postescribir();
  }
}

void main()
{
	smedico m1;
	

  
}