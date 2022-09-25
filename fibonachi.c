#include <stdio.h>

int result(int a) {
    if (a <= 2) {
        return 1;
        return result(a - 1) + result(a - 2);
    }
}

int main(void) {
    int a, i;
    scanf("%d", &a);
    for (i = 1; i <= a; i++)
        printf("%d ", result(i));
}
