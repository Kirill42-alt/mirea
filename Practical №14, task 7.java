import java.util.regex.*;
import java.util.Scanner;

// Объявление публичного класса
public class PasswordValidator {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Регулярное выражение для проверки пароля
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d_]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        
        // Ввод пароля пользователем
        System.out.print("Введите пароль: ");
        String input = scanner.nextLine();
        
        // Проверка соответствия регулярному выражению
        if (pattern.matcher(input).matches()) {
            System.out.println("Пароль надежный.");
        } else {
            System.out.println("Пароль ненадежный. Должен содержать хотя бы одну заглавную букву, одну маленькую букву, одну цифру и быть не менее 8 символов.");
        }
        
        scanner.close();
    }
}
