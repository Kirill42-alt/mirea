// Интерфейс выражения
interface Expression {
    int evaluate(int x);
}

// Класс для константы
class Const implements Expression {
    private final int value;

    public Const(int value) {
        this.value = value;
    }

    @Override
    public int evaluate(int x) {
        return value;
    }
}

// Класс для переменной
class Variable implements Expression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int evaluate(int x) {
        return x; // Игнорируем имя переменной
    }
}

// Абстрактный класс для бинарных операций
abstract class BinaryOperation implements Expression {
    protected final Expression left, right;

    public BinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}

// Класс сложения
class Add extends BinaryOperation {
    public Add(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int evaluate(int x) {
        return left.evaluate(x) + right.evaluate(x);
    }
}

// Класс вычитания
class Subtract extends BinaryOperation {
    public Subtract(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int evaluate(int x) {
        return left.evaluate(x) - right.evaluate(x);
    }
}

// Класс умножения
class Multiply extends BinaryOperation {
    public Multiply(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int evaluate(int x) {
        return left.evaluate(x) * right.evaluate(x);
    }
}

// Класс деления
class Divide extends BinaryOperation {
    public Divide(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int evaluate(int x) {
        return left.evaluate(x) / right.evaluate(x);
    }
}

// Главный класс для тестирования
// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Использование: java Main <x>");
            return;
        }
        int x = Integer.parseInt(args[0]);
        Expression expr = new Subtract(
            new Multiply(new Const(2), new Variable("x")),
            new Const(3)
        );
        System.out.println("Результат: " + expr.evaluate(x));

        // Вычисление x^2 - 2x + 1
        Expression quadratic = new Add(
            new Subtract(
                new Multiply(new Variable("x"), new Variable("x")),
                new Multiply(new Const(2), new Variable("x"))
            ),
            new Const(1)
        );
        System.out.println("Результат x^2 - 2x + 1: " + quadratic.evaluate(x));
    }
}
