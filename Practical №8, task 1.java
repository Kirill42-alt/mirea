import java.util.Scanner;

// Объявление публичного класса
public class TriangularSequenceOneLoop {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите n: ");
        int n = scanner.nextInt();
        scanner.close();
        
// Цикл для прохода по элементам массива
        for (int i = 1, count = 0; count < n; count += i, i++) {
            for (int j = 0; j < i && count + j < n; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
