#include <stdio.h>
#include <math.h>
#include <locale.h>

int main(void) {
    
    setlocale(LC_ALL, "Russian");

    printf("%s", "Решение математического выражения.\n");
    
    int t = 2;
    int y = 3;
    int z = cos(t + y);
    double x;
    
    x = 4 * pow(y, 3) - z/t;
    
    printf("Ответ: %lf", x);
    
}