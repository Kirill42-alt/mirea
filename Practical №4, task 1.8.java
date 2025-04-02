// Абстрактный класс Shape
public abstract class Shape {
    protected String color;
    protected boolean filled;

    // Конструкторы
    public Shape() {
        this.color = "red";
        this.filled = true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // Геттеры и сеттеры
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // Абстрактные методы
    public abstract double getArea();

    public abstract double getPerimeter();

    // Переопределенный метод toString
    @Override
    public String toString() {
        return String.format("Shape[color=%s, filled=%s]", color, filled);
    }
}

// Класс Circle наследуется от Shape
// Объявление публичного класса
public class Circle extends Shape {
    private double radius;

    // Конструкторы
    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    // Геттер и сеттер
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Реализация абстрактных методов
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle[Shape[color=%s, filled=%s], radius=%.2f]", color, filled, radius);
    }
}

// Класс Rectangle наследуется от Shape
// Объявление публичного класса
public class Rectangle extends Shape {
    protected double width;
    protected double length;

    // Конструкторы
    public Rectangle() {
        this.width = 1.0;
        this.length = 1.0;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    // Геттеры и сеттеры
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    // Реализация абстрактных методов
    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return String.format("Rectangle[Shape[color=%s, filled=%s], width=%.2f, length=%.2f]", color, filled, width, length);
    }
}

// Класс Square наследуется от Rectangle
// Объявление публичного класса
public class Square extends Rectangle {

    // Конструкторы
    public Square() {
        super(1.0, 1.0);
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    // Геттер и сеттер
    public double getSide() {
        return width;
    }

    public void setSide(double side) {
        this.width = side;
        this.length = side;
    }

    @Override
    public void setWidth(double side) {
        setSide(side);
    }

    @Override
    public void setLength(double side) {
        setSide(side);
    }

    @Override
    public String toString() {
        return String.format("Square[Shape[color=%s, filled=%s], side=%.2f]", color, filled, width);
    }
}

// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Shape circle = new Circle(5.0, "Blue", true);
        Shape rectangle = new Rectangle(4.0, 6.0, "Green", false);
        Shape square = new Square(4.0, "Yellow", true);

        System.out.println(circle);
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());

        System.out.println();

        System.out.println(rectangle);
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());

        System.out.println();

        System.out.println(square);
        System.out.println("Area: " + square.getArea());
        System.out.println("Perimeter: " + square.getPerimeter());
    }
}
