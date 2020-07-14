//
// Created by matias on 13-07-20.
//

#include <stdlib.h>
#include <stdio.h>
#include <time.h>

void main()
{

    srand(time(NULL));
    int muertoshoy= rand()%(11);
    char hola[100];
    snprintf(hola,100,"%d",muertoshoy);
    printf("hola %d == %s\n",muertoshoy,hola);
}