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

// Класс для сортировки студентов
class SortingStudentsByGPA {
    private List<Student> students;

    // Конструктор
    public SortingStudentsByGPA() {
        students = new ArrayList<>();
    }

    // Метод заполнения списка студентов случайными данными
    public void setArray(int size) {
        Random random = new Random();
// Цикл для прохода по элементам массива
        for (int i = 0; i < size; i++) {
            students.add(new Student(random.nextInt(100) + 1, "Student" + (i + 1), random.nextDouble() * 4.0));
        }
    }

    // Метод вывода студентов
    public void outArray() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Быстрая сортировка по убыванию GPA
    public void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        Student pivot = students.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (students.get(j).getGPA() > pivot.getGPA()) {
                i++;
                Collections.swap(students, i, j);
            }
        }
        Collections.swap(students, i + 1, high);
        return i + 1;
    }

    // Сортировка слиянием по убыванию GPA
    public void mergeSort() {
        students = mergeSortHelper(students);
    }

    private List<Student> mergeSortHelper(List<Student> list) {
        if (list.size() <= 1) {
            return list;
        }
        int mid = list.size() / 2;
        List<Student> left = mergeSortHelper(new ArrayList<>(list.subList(0, mid)));
        List<Student> right = mergeSortHelper(new ArrayList<>(list.subList(mid, list.size())));
        return merge(left, right);
    }

    private List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getGPA() > right.get(j).getGPA()) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }
        merged.addAll(left.subList(i, left.size()));
        merged.addAll(right.subList(j, right.size()));
        return merged;
    }

    // Сортировка по ID
    public void sortByID() {
        students.sort(Comparator.comparingInt(Student::getIDNumber));
    }
}

// Тестовый класс
// Объявление публичного класса
public class StudentTest {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        SortingStudentsByGPA sorter = new SortingStudentsByGPA();
        sorter.setArray(5);
        
        System.out.println("Исходный список студентов:");
        sorter.outArray();
        
        // Быстрая сортировка по GPA
        sorter.quickSort(0, 4);
        System.out.println("\nОтсортировано по убыванию GPA (быстрая сортировка):");
        sorter.outArray();
        
        // Повторное заполнение списка
        sorter.setArray(5);
        
        // Сортировка слиянием по GPA
        sorter.mergeSort();
        System.out.println("\nОтсортировано по убыванию GPA (слияние):");
        sorter.outArray();
        
        // Сортировка по ID
        sorter.sortByID();
        System.out.println("\nОтсортировано по ID:");
        sorter.outArray();
    }
}
