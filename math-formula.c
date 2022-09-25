#include <stdio.h>
#include <math.h>

int main(void) {
    double x, b, z, y;

    x = 4.2;
    b = -1.5;

    if (x > b) {z = b + cos(x);} else {z = sqrt(b - x * x);}
    if (z > x) {y = log(z * b);} else if (z < x) {y = (z - x) / (b + x) + sqrt(2 * b * x * z);} else {y = sin(x) - sin(z) / cos(z);}

    printf("x: %lf\n", x);
    printf("b: %lf\n", b);
    printf("z: %lf\n", z);
    printf("y: %lf\n", y);
    
}
