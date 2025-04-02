import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    // Геттер для GPA
    public double getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return "Student { ID: " + iDNumber + ", Name: " + name + ", GPA: " + GPA + " }";
    }
}

// Класс для сортировки списка студентов методом слияния
class MergeSortStudents {
    public List<Student> mergeSort(List<Student> students) {
        if (students.size() <= 1) {
            return students;
        }

        int mid = students.size() / 2;
        List<Student> left = new ArrayList<>(students.subList(0, mid));
        List<Student> right = new ArrayList<>(students.subList(mid, students.size()));

        return merge(mergeSort(left), mergeSort(right));
    }

    private List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getGPA() >= right.get(j).getGPA()) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        while (i < left.size()) {
            merged.add(left.get(i++));
        }
        while (j < right.size()) {
            merged.add(right.get(j++));
        }

        return merged;
    }
}

// Класс для тестирования
// Объявление публичного класса
public class StudentMergeTest {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Random random = new Random();
        List<Student> list1 = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();

        // Заполнение двух списков случайными студентами
// Цикл для прохода по элементам массива
        for (int i = 0; i < 5; i++) {
            list1.add(new Student(random.nextInt(100) + 1, "Student_A" + (i + 1), random.nextDouble() * 4.0));
            list2.add(new Student(random.nextInt(100) + 1, "Student_B" + (i + 1), random.nextDouble() * 4.0));
        }

        // Вывод исходных списков
        System.out.println("Список 1 студентов:");
        printList(list1);
        System.out.println("\nСписок 2 студентов:");
        printList(list2);

        // Объединение и сортировка
        List<Student> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        MergeSortStudents sorter = new MergeSortStudents();
        mergedList = sorter.mergeSort(mergedList);

        // Вывод отсортированного объединенного списка
        System.out.println("\nОтсортированный объединенный список студентов:");
        printList(mergedList);
    }

    // Метод для вывода списка
    public static void printList(List<Student> list) {
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
