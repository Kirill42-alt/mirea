// Объявление публичного класса
public class MinMax<T extends Comparable<T>> {
    private T[] array;

    // Конструктор принимает массив
    public MinMax(T[] array) {
        this.array = array;
    }

    // Метод для нахождения минимального элемента
    public T min() {
        if (array == null || array.length == 0) {
            return null;
        }

        T min = array[0];
        for (T item : array) {
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        return min;
    }

    // Метод для нахождения максимального элемента
    public T max() {
        if (array == null || array.length == 0) {
            return null;
        }

        T max = array[0];
        for (T item : array) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    // Вывод массива
    public void printArray() {
        System.out.print("Массив: ");
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

// Объявление публичного класса
public class Calculator {

    // Сложение
    public static <T extends Number, V extends Number> double sum(T a, V b) {
        return a.doubleValue() + b.doubleValue();
    }

    // Вычитание
    public static <T extends Number, V extends Number> double subtraction(T a, V b) {
        return a.doubleValue() - b.doubleValue();
    }

    // Умножение
    public static <T extends Number, V extends Number> double multiply(T a, V b) {
        return a.doubleValue() * b.doubleValue();
    }

    // Деление
    public static <T extends Number, V extends Number> double divide(T a, V b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Деление на ноль запрещено!");
        }
        return a.doubleValue() / b.doubleValue();
    }
}

// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        // Пример использования MinMax с Integer
        Integer[] intArray = {4, 2, 7, 1, 9, 3};
        MinMax<Integer> intMinMax = new MinMax<>(intArray);
        intMinMax.printArray();
        System.out.println("Минимум: " + intMinMax.min());
        System.out.println("Максимум: " + intMinMax.max());

        // Пример использования MinMax с Double
        Double[] doubleArray = {3.5, 1.2, 9.8, 4.4};
        MinMax<Double> doubleMinMax = new MinMax<>(doubleArray);
        doubleMinMax.printArray();
        System.out.println("Минимум: " + doubleMinMax.min());
        System.out.println("Максимум: " + doubleMinMax.max());

        // Пример использования Calculator
        System.out.println("\nКалькулятор:");
// Вывод суммы на экран
        System.out.println("Сумма: " + Calculator.sum(5, 10.5));
        System.out.println("Разность: " + Calculator.subtraction(10, 3.5));
        System.out.println("Произведение: " + Calculator.multiply(4, 2.5));
        System.out.println("Деление: " + Calculator.divide(10, 2.0));
    }
}
