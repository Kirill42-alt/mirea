import java.util.Scanner;

// Объявление публичного класса
public class MaxElementCount {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int maxElement = 0;
        int count = 0;
        
        while (true) {
            int num = scanner.nextInt();
            if (num == 0) break;
            
            if (num > maxElement) {
                maxElement = num;
                count = 1;
            } else if (num == maxElement) {
                count++;
            }
        }
        
        System.out.println("Максимальный элемент: " + maxElement);
        System.out.println("Количество элементов, равных максимуму: " + count);
        
        scanner.close();
    }
}
