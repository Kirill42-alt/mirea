#include <stdio.h>

int main(void){
    
  printf("%s", "Программа выводит четные числа из набора данных в массиве. \n");
    
  int a[7] = { 20, 4, -31, 3, -6, 7 };

  for (int i=0; i[a]; i++) {
      int result = ("%d, ", i[a]);
      if (result % 2 == 0) {
          printf("%d ", result);
      }
  }
}
