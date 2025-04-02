// Практическая №1, 7 задание

// Объявление публичного класса
public class Main {
    public static int factorial(int n) { // Метод для вычисления факториала
        int result = 1; // Начальное значение для произведения
// Цикл для прохода по элементам массива
        for (int i = 1; i <= n; i++) {
            result *= i; // Умножаем на текущее значение i
        }
        return result; // Возвращаем результат
    }

// Главный метод программы — точка входа
    public static void main(String[] args) {
        int number = 5; // Число, для которого будем вычислять факториал
        System.out.println("Факториал числа " + number + " = " + factorial(number)); // Выводим результат
    }
}
