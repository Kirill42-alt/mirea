import java.util.Scanner;

// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        // Создаем объект Scanner для чтения ввода с консоли
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите текст:");
        
        // Читаем строку, введенную пользователем
        String input = scanner.nextLine();
        
        // Разделяем строку на слова, используя пробел как разделитель
        String[] words = input.split("\\s+");
        
        // Выводим количество слов
        System.out.println("Количество слов: " + words.length);
        
        // Закрываем Scanner
        scanner.close();
    }
}
