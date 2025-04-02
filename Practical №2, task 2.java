class Ball {
    private double x = 0.0;
    private double y = 0.0;

    // Конструктор с параметрами
    public Ball(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Конструктор без параметров
    public Ball() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // Геттеры
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Сеттеры
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Метод перемещения мяча
    public void move(double xDisp, double yDisp) {
        this.x += xDisp;
        this.y += yDisp;
    }

    // Метод toString
    @Override
    public String toString() {
        return "Ball at (" + x + ", " + y + ")";
    }
}

// Класс для тестирования Ball
// Объявление публичного класса
public class TestBall {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        // Создание объекта Ball
        Ball ball = new Ball(5.0, 7.0);
        System.out.println(ball);
        
        // Перемещение мяча
        ball.move(3.0, -2.0);
        System.out.println("После перемещения: " + ball);
        
        // Изменение координат
        ball.setXY(10.0, 15.0);
        System.out.println("После установки новых координат: " + ball);
    }
}
