// Интерфейс абстрактной фабрики
interface ComplexAbstractFactory {
    Complex createComplex();
    Complex createComplex(int real, int image);
}

// Класс комплексного числа
class Complex {
    private int real;
    private int image;
    
    public Complex(int real, int image) {
        this.real = real;
        this.image = image;
    }
    
    public int getReal() {
        return real;
    }
    
    public int getImage() {
        return image;
    }
    
    @Override
    public String toString() {
        return real + " + " + image + "i";
    }
}

// Конкретная фабрика комплексных чисел
class ConcreteFactory implements ComplexAbstractFactory {
    @Override
    public Complex createComplex() {
        return new Complex(0, 0);
    }
    
    @Override
    public Complex createComplex(int real, int image) {
        return new Complex(real, image);
    }
}

// Тестирование фабрики
// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        ComplexAbstractFactory factory = new ConcreteFactory();
        
        Complex defaultComplex = factory.createComplex();
        Complex customComplex = factory.createComplex(5, 3);
        
        System.out.println("Комплексное число по умолчанию: " + defaultComplex);
        System.out.println("Созданное комплексное число: " + customComplex);
    }
}
