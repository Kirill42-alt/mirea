import java.util.Scanner;
import java.util.regex.Pattern;

// Объявление публичного класса
public class StringManipulator {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ввод строки от пользователя
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        
        // Ввод регулярного выражения для разделения
        System.out.print("Введите регулярное выражение для разделения: ");
        String regex = scanner.nextLine();
        
        // Разделение строки по регулярному выражению
        String[] elements = input.split(regex);
        
        // Вывод разбитых элементов
        System.out.println("Результат разбиения строки:");
        for (String element : elements) {
            System.out.println(element);
        }
        
        scanner.close();
    }
}
