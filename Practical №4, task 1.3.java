class Person {
    private String fullName;
    private int age;

    // Конструктор без параметров
    public Person() {
        this.fullName = "Неизвестный";
        this.age = 0;
    }

    // Конструктор с параметрами
    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    // Метод move()
    public void move() {
        System.out.println(fullName + " двигается");
    }

    // Метод talk()
    public void talk() {
        System.out.println(fullName + " говорит");
    }

    @Override
    public String toString() {
        return "Имя: " + fullName + ", Возраст: " + age;
    }
}

// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        // Объект с конструктором без параметров
        Person person1 = new Person();
        
        // Объект с конструктором с параметрами
        Person person2 = new Person("Иван Иванов", 30);

        // Вывод информации и вызов методов
        System.out.println(person1);
        person1.move();
        person1.talk();

        System.out.println(person2);
        person2.move();
        person2.talk();
    }
}
