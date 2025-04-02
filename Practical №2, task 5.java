import java.util.ArrayList;
import java.util.List;

// Класс, описывающий собаку
class Dog {
    private String name;
    private int age;

    // Конструктор
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Сеттер для имени
    public void setName(String name) {
        this.name = name;
    }

    // Геттер для возраста
    public int getAge() {
        return age;
    }

    // Сеттер для возраста
    public void setAge(int age) {
        this.age = age;
    }

    // Метод для перевода возраста собаки в человеческий возраст
    public int getHumanAge() {
        return age * 7;
    }

    // Метод для представления информации об объекте в виде строки
    @Override
    public String toString() {
        return "Собака: " + name + ", возраст: " + age + " лет (человеческий возраст: " + getHumanAge() + ")";
    }
}

// Класс питомника собак
class DogKennel {
    private List<Dog> dogs;

    // Конструктор
    public DogKennel() {
        dogs = new ArrayList<>();
    }

    // Метод для добавления собаки в питомник
    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    // Метод для отображения всех собак в питомнике
    public void displayDogs() {
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
    }
}

// Класс для тестирования Dog и DogKennel
// Объявление публичного класса
public class DogTest {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        DogKennel kennel = new DogKennel();

        // Добавляем собак в питомник
        kennel.addDog(new Dog("Барсик", 3));
        kennel.addDog(new Dog("Шарик", 5));
        kennel.addDog(new Dog("Рекс", 2));

        // Вывод информации о собаках
        System.out.println("Собаки в питомнике:");
        kennel.displayDogs();
    }
}
