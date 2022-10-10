#include <stdio.h>
#include <math.h>
#include <locale.h>

int main(void) {
    
    setlocale(LC_ALL, "Russian");
    
    printf("%s", "Программа ищет высоту треугольника по заданным параметрам.\n");
    
    double x, y, z, p, result;

    printf("Введите основание a "); scanf_s("%lf",&x);
    printf("Введите сторону b "); scanf_s("%lf",&y);
    printf("Введите сторону c "); scanf_s("%lf",&z);

    if ((x + y >= z) && (y + z >= x) && (x + z >= y)) {
        p = (("%lf", x) + ("%lf", y) + ("%lf", z)) / 2;
        result = ("%i", (2 * sqrt(p * (p - x) * (p - y) * (p - z)) / x));
        printf("Ответ: %lf", result);
    } else {
        printf("Ответ: Такой треугольник не может существовать!");
    }

}
