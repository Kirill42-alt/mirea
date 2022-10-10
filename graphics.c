#include <stdio.h>
#include <math.h>
#include <locale.h>

int main(void) {

    setlocale(LC_ALL, "Russian");

    printf("%s", "Программа выводит сообщение о том, попадает ли указанные вами координаты в заштрихованную область определенной фигуры или нет. \n");

    double x, y;

    printf("Координата x "); scanf_s("%lf", &x);
    printf("Координата y "); scanf_s("%lf", &y);

    printf("%lf\n", x);
    printf("%lf", y);

    if ((y >= -x + 1) && (pow(y, 2) + pow(y, 2)) < 1) {
        printf("\n\n%s", "Точка попадает в область.");
    }
    else {
        printf("\n\n%s", "Точка не попадает в область.");
    }
}
