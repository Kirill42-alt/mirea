import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Абстрактный класс Shape
abstract class Shape {
    protected Color color;
    protected int x, y;

    public Shape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics g);
}

// Класс для круга
class Circle extends Shape {
    private int radius;

    public Circle(Color color, int x, int y, int radius) {
        super(color, x, y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, radius * 2, radius * 2);
    }
}

// Класс для прямоугольника
class Rectangle extends Shape {
    private int width, height;

    public Rectangle(Color color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}

// Класс для панели рисования
class DrawingPanel extends JPanel {
    private Shape[] shapes;
    private Random random = new Random();

    public DrawingPanel() {
        shapes = new Shape[20];
// Цикл для прохода по элементам массива
        for (int i = 0; i < shapes.length; i++) {
            int x = random.nextInt(400);
            int y = random.nextInt(400);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            if (random.nextBoolean()) {
                shapes[i] = new Circle(color, x, y, random.nextInt(50) + 20);
            } else {
                shapes[i] = new Rectangle(color, x, y, random.nextInt(80) + 20, random.nextInt(60) + 20);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}

// Основной класс с окном
// Объявление публичного класса
public class ShapeDrawing {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(new DrawingPanel());
        frame.setVisible(true);
    }
}
