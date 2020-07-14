#include <pthread.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>



int j=0;

struct hola
{
  pthread_mutex_t mutex_medico;
  int p;
};

void  *contar(void *arg)
{
  struct hola *A;
   A=(struct hola *)arg;
   pthread_mutex_lock(&A->mutex_medico);
   int i=0,p=A->p;
   while(i<10)
   {
     j+=p;
     printf("j= %d \n",j);
     i++;
   }
   A->p=-10;
  pthread_mutex_unlock(&A->mutex_medico);
}

int  main ()
{
  struct hola hola1;
  hola1.p=10;
  pthread_mutex_init(&hola1.mutex_medico,NULL);
  pthread_t pid_lectores[2];
  int a=-10;
   for (int i = 0; i < 2; i++) 
   {
      pthread_create(&pid_lectores[i], NULL, contar, (void *)&hola1);

      
   }

   for (int i = 0; i < 2; i++) 
   {
     pthread_join(pid_lectores[i], NULL);
    }
  int o =1;

  return o;
}




