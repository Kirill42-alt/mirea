#include <stdio.h>
#include <stdlib.h>

int main(void) {

    int a, x, b;

    a = ("%d\n", 0 + rand()%100); b = 0;
    printf("Число загадано. Угадайте его!\n\n");

    do {
        scanf("%d> ", &x);

        if (x > a) {printf("Введенное Вами число больше загаданного.\n");b++;
        } else if (x < a) {printf("Введенное Вами число меньше загаданного.\n");b++;
        } else {printf("Вы угадали!\n");printf("%s%d", "Количество попыток: ", b);break;}

    } while(1);
}