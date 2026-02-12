#include <stdio.h>

int main(){

    int numero, fatorial;
    char op;

    do{
        fatorial = 1;
        printf("\n\nVocê deseja saber o fatorial de qual número? ");
        scanf("%d", &numero);

        if(numero == 0 || numero == 1){
            fatorial = 1;
        }   else{
                for(int x=numero; x>=1; x--){
                    fatorial = fatorial * (x);
                }
            }
    
        printf("\n%d! = %d\n", numero, fatorial);

        setbuf(stdin, NULL);
        printf("\nDeseja continuar (S ou N)? ");
        scanf("%c", &op);

    }while(op != 'N' && op != 'n');

    return 0;
}