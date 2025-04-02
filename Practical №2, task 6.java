class Circle {
    private double radius;
    
    // Конструктор
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // Геттер для радиуса
    public double getRadius() {
        return radius;
    }
    
    // Сеттер для радиуса
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    // Метод для расчёта площади круга
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    // Метод для расчёта длины окружности
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
    
    // Метод для сравнения двух окружностей по радиусу
    public boolean isEqual(Circle other) {
        return this.radius == other.radius;
    }
    
    @Override
    public String toString() {
        return "Окружность с радиусом: " + radius + ", площадь: " + getArea() + ", длина окружности: " + getCircumference();
    }
}

// Класс для тестирования Circle
// Объявление публичного класса
public class CircleTest {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        // Создание окружностей
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(7.0);
        Circle circle3 = new Circle(5.0);
        
        // Вывод информации об окружностях
        System.out.println(circle1);
        System.out.println(circle2);
        
        // Сравнение окружностей
        System.out.println("Первая и вторая окружность равны? " + circle1.isEqual(circle2));
        System.out.println("Первая и третья окружность равны? " + circle1.isEqual(circle3));
    }
}
