interface Nameable {
    String getName();
}

class Planet implements Nameable {
    private String name;
    
    public Planet(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return "Планета: " + name;
    }
}

class Car implements Nameable {
    private String name;
    
    public Car(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return "Автомобиль: " + name;
    }
}

class Animal implements Nameable {
    private String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return "Животное: " + name;
    }
}

// Объявление публичного класса
public class TestNameable {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Nameable earth = new Planet("Земля");
        Nameable tesla = new Car("Tesla Model S");
        Nameable dog = new Animal("Лабрадор");
        
        System.out.println(earth.getName());
        System.out.println(tesla.getName());
        System.out.println(dog.getName());
    }
}
