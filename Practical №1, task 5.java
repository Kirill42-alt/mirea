// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        // Если аргументы командной строки есть, выводим их
        if (args.length > 0) {
            System.out.println("Аргументы командной строки:");

            // Цикл для вывода каждого аргумента
// Цикл для прохода по элементам массива
            for (int i = 0; i < args.length; i++) {
                System.out.println("Аргумент " + (i + 1) + ": " + args[i]);
            }
        } else {
            System.out.println("Аргументы командной строки не переданы.");
        }
    }
}
