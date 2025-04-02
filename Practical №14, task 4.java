import java.util.regex.*;
import java.util.Scanner;

// Объявление публичного класса
public class DigitWithoutPlusChecker {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ввод текста
        System.out.println("Введите текст:");
        String input = scanner.nextLine();
        
        // Регулярное выражение для поиска цифры без знака '+' после неё
        String regex = "\\b\\d+(?!\\s*\\+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        
        boolean found = false;
        while (matcher.find()) {
            System.out.println("Найдена цифра без '+': " + matcher.group());
            found = true;
        }
        
        if (!found) {
            System.out.println("Все цифры сопровождаются знаком '+'.");
        }
        
        scanner.close();
    }
}
