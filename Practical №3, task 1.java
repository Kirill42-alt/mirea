import java.util.Arrays; // Для сортировки массива
import java.util.Random; // Для использования класса Random

// Объявление публичного класса
public class Main {

// Главный метод программы — точка входа
    public static void main(String[] args) {
        int size = 10; // Размер массива
        double[] array = new double[size]; // Создаем массив вещественных чисел

        // Генерация случайных чисел с использованием Math.random()
// Цикл для прохода по элементам массива
        for (int i = 0; i < size; i++) {
            array[i] = Math.random() * 100; // Случайное число от 0 до 100
        }

        // Выводим массив после генерации с Math.random()
        System.out.println("Массив после генерации с Math.random():");
        printArray(array);

        // Генерация случайных чисел с использованием Random
        Random rand = new Random();
// Цикл для прохода по элементам массива
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextDouble() * 100; // Случайное число от 0 до 100
        }

        // Выводим массив после генерации с Random
        System.out.println("\nМассив после генерации с Random:");
        printArray(array);

        // Сортируем массив
        Arrays.sort(array);

        // Выводим отсортированный массив
        System.out.println("\nОтсортированный массив:");
        printArray(array);
    }

    // Метод для вывода массива на экран
    public static void printArray(double[] array) {
        for (double num : array) {
            System.out.printf("%.2f ", num); // Форматируем вывод до 2 знаков после запятой
        }
        System.out.println(); // Переход на новую строку после вывода массива
    }
}
