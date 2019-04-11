#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{

    pid_t pid=fork();
    int status1;

    if(pid<0)
    {
        perror("Error");
        exit(-1);
    }
    else
    {
        if(pid==0)
        {
           printf("hijo (%d, hijo de %d)\n", getpid(),getppid()) ;
           int i=0;
           while(i<10)
           {
               i++;
           }
           printf("i: %d\n",i);
        }
        else
        {
            waitpid(pid, &status1,0);
            printf("status = %d\n", status1);
        }
    }
    return 0;
}