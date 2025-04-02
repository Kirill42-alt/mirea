import java.util.regex.*;
import java.util.Scanner;

// Объявление публичного класса
public class EmailValidator {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Регулярное выражение для проверки e-mail согласно RFC 2822
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        
        // Ввод e-mail пользователем
        System.out.print("Введите e-mail: ");
        String input = scanner.nextLine();
        
        // Проверка соответствия регулярному выражению
        if (pattern.matcher(input).matches()) {
            System.out.println("E-mail корректен.");
        } else {
            System.out.println("E-mail некорректен.");
        }
        
        scanner.close();
    }
}
