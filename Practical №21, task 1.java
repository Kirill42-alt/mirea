// Интерфейс фабрики комплексных чисел
public interface ComplexAbstractFactory {
    Complex createComplex();                          // создание комплексного числа без параметров
    Complex createComplex(int real, int image);       // создание комплексного числа с параметрами
}

// Конкретная фабрика, реализующая интерфейс ComplexAbstractFactory
// Объявление публичного класса
public class ConcreteFactory implements ComplexAbstractFactory {

    @Override
    public Complex createComplex() {
        return new Complex(0, 0);    // по умолчанию комплексное число (0 + 0i)
    }

    @Override
    public Complex createComplex(int real, int image) {
        return new Complex(real, image);
    }
}

// Класс комплексного числа
// Объявление публичного класса
public class Complex {
    private int real;     // действительная часть
    private int image;    // мнимая часть

    public Complex(int real, int image) {
        this.real = real;
        this.image = image;
    }

    // Геттеры
    public int getReal() {
        return real;
    }

    public int getImage() {
        return image;
    }

    // Сеттеры
    public void setReal(int real) {
        this.real = real;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        if (image >= 0) {
            return real + " + " + image + "i";
        } else {
            return real + " - " + (-image) + "i";
        }
    }

    // Пример операции сложения комплексных чисел
    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.image + other.image);
    }
}

// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        try {
            // Создаем фабрику
            ComplexAbstractFactory factory = new ConcreteFactory();

            // Создаем комплексные числа через фабрику
            Complex c1 = factory.createComplex(3, 4);
            Complex c2 = factory.createComplex(1, -2);
            Complex zeroComplex = factory.createComplex();

            // Выводим комплексные числа
            System.out.println("Комплексное число c1: " + c1);
            System.out.println("Комплексное число c2: " + c2);
            System.out.println("Комплексное число по умолчанию: " + zeroComplex);

            // Пример сложения
            Complex result = c1.add(c2);
            System.out.println("Результат сложения c1 + c2: " + result);

        } catch (Exception e) {
            System.out.println("Ошибка при работе с комплексными числами: " + e.getMessage());
        }
    }
}
