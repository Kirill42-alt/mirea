import java.util.Arrays;
import java.util.Random;

// Класс, описывающий точку на плоскости
class Point {
    private double x;
    private double y;

    // Конструктор
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Геттеры
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// Класс, описывающий окружность
class Circle {
    private Point center;
    private double radius;

    // Конструктор
    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    // Геттеры
    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    // Метод для вычисления площади окружности
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Метод для вычисления длины окружности
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Окружность с центром в " + center + " и радиусом " + radius;
    }
}

// Класс для управления окружностями
class Tester {
    private Circle[] circles;
    private int count;

    // Конструктор
    public Tester(int size) {
        circles = new Circle[size];
        count = 0;
    }

    // Метод для добавления окружности
    public void addCircle(Circle circle) {
        if (count < circles.length) {
            circles[count] = circle;
            count++;
        } else {
            System.out.println("Массив окружностей заполнен!");
        }
    }

    // Метод для нахождения самой маленькой окружности
    public Circle getSmallestCircle() {
        if (count == 0) return null;
        return Arrays.stream(circles, 0, count)
                     .min((c1, c2) -> Double.compare(c1.getRadius(), c2.getRadius()))
                     .orElse(null);
    }

    // Метод для нахождения самой большой окружности
    public Circle getLargestCircle() {
        if (count == 0) return null;
        return Arrays.stream(circles, 0, count)
                     .max((c1, c2) -> Double.compare(c1.getRadius(), c2.getRadius()))
                     .orElse(null);
    }

    // Метод сортировки окружностей по возрастанию радиуса
    public void sortCircles() {
        Arrays.sort(circles, 0, count, (c1, c2) -> Double.compare(c1.getRadius(), c2.getRadius()));
    }

    // Метод для вывода всех окружностей
    public void displayCircles() {
// Цикл для прохода по элементам массива
        for (int i = 0; i < count; i++) {
            System.out.println(circles[i]);
        }
    }
}

// Класс для тестирования
// Объявление публичного класса
public class CircleTest {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Random random = new Random();
        Tester tester = new Tester(5);

        // Добавление случайных окружностей
// Цикл для прохода по элементам массива
        for (int i = 0; i < 5; i++) {
            double x = random.nextDouble() * 100;
            double y = random.nextDouble() * 100;
            double radius = random.nextDouble() * 50 + 1; // Радиус от 1 до 51
            tester.addCircle(new Circle(new Point(x, y), radius));
        }

        // Вывод всех окружностей
        System.out.println("Все окружности:");
        tester.displayCircles();

        // Поиск самой маленькой и самой большой окружности
        System.out.println("\nСамая маленькая окружность: " + tester.getSmallestCircle());
        System.out.println("Самая большая окружность: " + tester.getLargestCircle());

        // Сортировка окружностей
        tester.sortCircles();
        System.out.println("\nОкружности после сортировки по радиусу:");
        tester.displayCircles();
    }
}
