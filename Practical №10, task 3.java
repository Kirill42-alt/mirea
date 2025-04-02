import java.util.*;

// Класс Student
class Student {
    private int iDNumber;
    private String name;
    private double GPA;

    // Конструктор
    public Student(int iDNumber, String name, double GPA) {
        this.iDNumber = iDNumber;
        this.name = name;
        this.GPA = GPA;
    }

    // Геттеры
    public int getIDNumber() {
        return iDNumber;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return "Student { ID: " + iDNumber + ", Name: " + name + ", GPA: " + GPA + " }";
    }
}

// Класс для объединения и сортировки списков студентов
class StudentMerger {
    // Метод объединения и сортировки списка студентов
    public static List<Student> mergeAndSortLists(List<Student> list1, List<Student> list2) {
        List<Student> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        
        // Сортировка по GPA по убыванию
        mergedList.sort(Comparator.comparingDouble(Student::getGPA).reversed());
        return mergedList;
    }
}

// Тестовый класс
// Объявление публичного класса
public class StudentTest {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        List<Student> list1 = Arrays.asList(
            new Student(101, "Alice", 3.8),
            new Student(102, "Bob", 3.5),
            new Student(103, "Charlie", 3.9)
        );

        List<Student> list2 = Arrays.asList(
            new Student(201, "David", 3.7),
            new Student(202, "Eve", 3.6),
            new Student(203, "Frank", 3.4)
        );

        // Вывод исходных списков
        System.out.println("Список 1 студентов:");
        list1.forEach(System.out::println);

        System.out.println("\nСписок 2 студентов:");
        list2.forEach(System.out::println);

        // Объединение и сортировка
        List<Student> mergedList = StudentMerger.mergeAndSortLists(list1, list2);

        // Вывод объединённого и отсортированного списка
        System.out.println("\nОбъединённый и отсортированный список студентов:");
        mergedList.forEach(System.out::println);
    }
}
