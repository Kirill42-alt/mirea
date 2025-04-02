import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Абстрактный класс Фигура
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

// Класс Круг
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

// Класс Прямоугольник
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

// Панель для рисования фигур
class ShapePanel extends JPanel {
    private final Shape[] shapes;
    private final Random random = new Random();

    public ShapePanel() {
        shapes = new Shape[20];
// Цикл для прохода по элементам массива
        for (int i = 0; i < shapes.length; i++) {
            int x = random.nextInt(400);
            int y = random.nextInt(400);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            if (random.nextBoolean()) {
                shapes[i] = new Circle(color, x, y, random.nextInt(50) + 20);
            } else {
                shapes[i] = new Rectangle(color, x, y, random.nextInt(80) + 20, random.nextInt(80) + 20);
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

// Окно приложения
// Объявление публичного класса
public class ShapeDrawer extends JFrame {
    public ShapeDrawer() {
        setTitle("Random Shapes");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new ShapePanel());
    }

// Главный метод программы — точка входа
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShapeDrawer().setVisible(true));
    }
}
