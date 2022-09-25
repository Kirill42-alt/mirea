#include <stdio.h>
#include <math.h>

int main(void) {

    double x, y;

    printf("Координата x "); scanf("%lf",&x);
    printf("Координата y "); scanf("%lf",&y);

    printf("%lf\n", x);
    printf("%lf", y);

    if ((y >= -x + 1) && (pow(y, 2) + pow(y, 2)) < 1) {
        printf("\n\nТочка попадает в область");
    } else {
        printf("\n\nТочка не попадает в область");
    }

}