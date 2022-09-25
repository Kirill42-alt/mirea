#include <stdio.h>
#include <math.h>

int main(void) {
    double x, y, z, p, result;

    printf("Введите основание a "); scanf("%lf",&x);
    printf("Введите сторону b "); scanf("%lf",&y);
    printf("Введите сторону c "); scanf("%lf",&z);

    if ((x + y >= z) && (y + z >= x) && (x + z >= y)) {
        p = (("%lf", x) + ("%lf", y) + ("%lf", z)) / 2;
        result = ("%i", (2 * sqrt(p * (p - x) * (p - y) * (p - z)) / x));
        printf("Ответ: %lf", result);
    } else {
        printf("Ответ: Такой треугольник не может существовать!");
    }

}