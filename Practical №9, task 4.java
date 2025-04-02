import java.util.Arrays; // Импортируем класс Arrays для работы с массивами (например, для сортировки)

// Класс Student, реализующий интерфейс Comparable
class Student implements Comparable<Student> {
    private int iDNumber;        // Уникальный идентификатор студента
    private String name;         // Имя студента
    private double GPA;          // Средний балл (GPA) студента

    // Конструктор
    public Student(int iDNumber, String name, double GPA) {
        this.iDNumber = iDNumber; // Инициализация поля iDNumber
        this.name = name;         // Инициализация поля name
        this.GPA = GPA;           // Инициализация поля GPA
    }

    // Геттер для GPA
    public double getGPA() {
        return GPA; // Возвращает значение GPA
    }

    // Реализация метода compareTo() для сортировки по GPA (по убыванию)
    @Override
    public int compareTo(Student other) {
        return Double.compare(other.getGPA(), this.GPA); // Сравнивает GPA: сначала тот, что больше (по убыванию)
    }

    @Override
    public String toString() {
        // Переопределение метода toString() для удобного вывода информации о студенте
        return "Student { ID: " + iDNumber + ", Name: " + name + ", GPA: " + GPA + " }";
    }
}

// Класс для тестирования
// Объявление публичного класса
public class ComparableTest {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        // Создаем массив студентов
        Student[] students = {
            new Student(101, "Alice", 3.8),   // Создание студента Alice с GPA 3.8
            new Student(102, "Bob", 3.5),     // Создание студента Bob с GPA 3.5
            new Student(103, "Charlie", 3.9), // Создание студента Charlie с GPA 3.9
            new Student(104, "David", 3.6)    // Создание студента David с GPA 3.6
        };

        // Вывод исходного массива
        System.out.println("Исходный массив студентов:");
        printArray(students); // Печатаем массив студентов до сортировки

        // Сортировка с использованием Comparable
        Arrays.sort(students); // Сортируем массив студентов по убыванию GPA (используется compareTo)

        // Вывод отсортированного массива
        System.out.println("\nОтсортированный массив студентов (по убыванию GPA):");
        printArray(students); // Печатаем массив студентов после сортировки
    }

    // Метод для вывода массива
    public static void printArray(Student[] array) {
        for (Student student : array) { // Проходим по всем элементам массива
            System.out.println(student); // Выводим информацию о студенте (вызов toString())
        }
    }
}
