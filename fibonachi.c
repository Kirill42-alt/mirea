#include <stdio.h>
#include <locale.h>

int result(int a) {
    if (a <= 2) {
        return 1;
        return result(a - 1) + result(a - 2);
    }
}

int main(void) {
    
    setlocale(LC_ALL, "Russian");
    
    printf("%s", "Вывод чисел Фибоначчи. Задайте число: \n");
    
    int a, i;
    scanf_s("%d", &a);
    for (i = 1; i <= a; i++)
        printf("%d ", result(i));
}
