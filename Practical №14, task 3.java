import java.util.regex.*;
import java.util.Scanner;

// Объявление публичного класса
public class PriceExtractor {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ввод текста
        System.out.println("Введите текст со списками цен:");
        String input = scanner.nextLine();
        
        // Регулярное выражение для поиска цен в USD, RUR, EU
        String regex = "\\b\\d{1,}\\.\\d{2} (USD|RUB|EU)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        
        // Поиск и вывод всех совпадений
        System.out.println("Найденные цены:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        
        scanner.close();
    }
}
