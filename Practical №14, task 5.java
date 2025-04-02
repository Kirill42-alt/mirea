import java.util.regex.*;
import java.util.Scanner;

// Объявление публичного класса
public class DateValidator {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Регулярное выражение для формата dd/mm/yyyy (с учетом високосных лет)
        String regex = "^(?:(?:31/(?:01|03|05|07|08|10|12))|" +
                      "(?:30/(?:01|03|04|05|06|07|08|09|10|11|12))|" +
                      "(?:29/02/(?:(?:19|[2-9][0-9])[0-9]{2}))|" +
                      "(?:0[1-9]|1\d|2[0-8])/(?:0[1-9]|1[0-2])/(?:19|[2-9][0-9])[0-9]{2})$";
        
        Pattern pattern = Pattern.compile(regex);
        
        // Ввод даты пользователем
        System.out.print("Введите дату в формате dd/mm/yyyy: ");
        String input = scanner.nextLine();
        
        // Проверка соответствия регулярному выражению
        if (pattern.matcher(input).matches()) {
            System.out.println("Дата корректна.");
        } else {
            System.out.println("Дата некорректна.");
        }
        
        scanner.close();
    }
}
