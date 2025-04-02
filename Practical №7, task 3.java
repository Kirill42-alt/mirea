// Интерфейс Movable
interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}

// Класс MovablePoint
class MovablePoint implements Movable {
    private int x, y;
    private int xSpeed, ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        y -= ySpeed;
    }

    @Override
    public void moveDown() {
        y += ySpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }

    @Override
    public void moveRight() {
        x += xSpeed;
    }

    @Override
    public String toString() {
        return "Point at (" + x + ", " + y + "), Speed: (" + xSpeed + ", " + ySpeed + ")";
    }

    public boolean hasSameSpeed(MovablePoint other) {
        return this.xSpeed == other.xSpeed && this.ySpeed == other.ySpeed;
    }
}

// Класс MovableRectangle
class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    @Override
    public void moveUp() {
        topLeft.moveUp();
        bottomRight.moveUp();
    }

    @Override
    public void moveDown() {
        topLeft.moveDown();
        bottomRight.moveDown();
    }

    @Override
    public void moveLeft() {
        topLeft.moveLeft();
        bottomRight.moveLeft();
    }

    @Override
    public void moveRight() {
        topLeft.moveRight();
        bottomRight.moveRight();
    }

    public boolean speedTest() {
        return topLeft.hasSameSpeed(bottomRight);
    }

    @Override
    public String toString() {
        return "Rectangle [Top Left: " + topLeft + ", Bottom Right: " + bottomRight + "]";
    }
}

// Тестирование
// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        MovableRectangle rectangle = new MovableRectangle(0, 10, 10, 0, 2, 2);
        System.out.println("Исходное положение: " + rectangle);
        System.out.println("Одинаковая скорость у точек: " + rectangle.speedTest());

        rectangle.moveRight();
        rectangle.moveDown();
        System.out.println("После движения вправо и вниз: " + rectangle);
    }
}
