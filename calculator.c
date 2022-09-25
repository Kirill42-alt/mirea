#include <stdio.h>
#include <conio.h>
#include <math.h>

int main (void) {

    double a, b;
    char x = '+'; char y = '-'; char v = '*'; char z = '/'; char t = '^'; char result;
    
    //scanf("%lf%c%lf", &a, &result, &b);
    
    do {
        
        scanf("%lf%c%lf", &a, &result, &b);
    
    if (result == x) {
        printf("%lf + %lf = %lf\n", a, b, a + b);
        //a = ("%lf + %lf", a + b);
    } else if (result == y) {
        printf("%lf - %lf = %lf\n", a, b, a - b);
        //a = ("%lf - %lf", a - b);
    } else if (result == v) {
        printf("%lf * %lf = %lf\n", a, b, a * b);
        //a = ("%lf * %lf", a * b);
    } else if (result == z) {
        printf("%lf / %lf = %lf\n", a, b, a / b);
        //a = ("%lf / %lf", a / b);
    } else if (result == t) {
        printf("%lf ^ %lf = %lf\n", a, b, pow(a, b));
        a = ("%lf ^ %lf", pow(a, b));
    } else {
        /*if (result == v) {
            printf("%lf - %lf = %lf\n", a, b, a - b);
            a = ("%lf - %lf", a - b);
        } else {
            printf("%lf + %lf = %lf\n", a, b, a + b);
            a = ("%lf + %lf", a + b);
        }*/
    }
    
    // = ("%lf",a);
    //printf("%lf",a);
    //scanf("%c%lf",&result, &b);
    }
    
    while (1);
}