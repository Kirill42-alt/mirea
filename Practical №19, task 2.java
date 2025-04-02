import java.util.*;

// Интерфейс Исключения
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

class EmptyStringException extends Exception {
    public EmptyStringException(String message) {
        super(message);
    }
}

// Класс Студент
class Student implements Comparable<Student> {
    private String fullName;
    private double gpa;

    public Student(String fullName, double gpa) {
        this.fullName = fullName;
        this.gpa = gpa;
    }

    public String getFullName() {
        return fullName;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(other.getGpa(), this.getGpa()); // По убыванию
    }

    @Override
    public String toString() {
        return "Студент: " + fullName + ", Средний балл: " + gpa;
    }
}

// Класс управления списком студентов
class LabClass {
    private List<Student> students;

    public LabClass() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void sortStudentsByGPA() {
        Collections.sort(students);
    }

    public Student findStudent(String fullName) throws StudentNotFoundException, EmptyStringException {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new EmptyStringException("ФИО не может быть пустым");
        }

        for (Student s : students) {
            if (s.getFullName().equalsIgnoreCase(fullName.trim())) {
                return s;
            }
        }

        throw new StudentNotFoundException("Студент с ФИО \"" + fullName + "\" не найден.");
    }

    public List<Student> getStudents() {
        return students;
    }
}

// Класс пользовательского интерфейса
class LabClassUI {
    private LabClass labClass;

    public LabClassUI(LabClass labClass) {
        this.labClass = labClass;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Меню ===");
            System.out.println("1. Добавить студента");
            System.out.println("2. Сортировать по среднему баллу");
            System.out.println("3. Найти студента по ФИО");
            System.out.println("4. Показать всех студентов");
            System.out.println("5. Выйти");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1" -> addStudent(scanner);
                    case "2" -> sortStudents();
                    case "3" -> findStudent(scanner);
                    case "4" -> showStudents();
                    case "5" -> {
                        System.out.println("Завершение программы...");
                        running = false;
                    }
                    default -> System.out.println("Неверный выбор. Попробуйте снова.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private void addStudent(Scanner scanner) throws EmptyStringException {
        System.out.print("Введите ФИО студента: ");
        String fullName = scanner.nextLine();

        if (fullName.trim().isEmpty()) {
            throw new EmptyStringException("ФИО не может быть пустым.");
        }

        double gpa = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введите средний балл (от 0 до 100): ");
            String gpaInput = scanner.nextLine();

            try {
                gpa = Double.parseDouble(gpaInput);
                if (gpa < 0 || gpa > 100) {
                    System.out.println("Средний балл должен быть от 0 до 100.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода! Пожалуйста, введите число.");
            }
        }

        Student student = new Student(fullName.trim(), gpa);
        labClass.addStudent(student);
        System.out.println("Студент успешно добавлен.");
    }

    private void sortStudents() {
        labClass.sortStudentsByGPA();
        System.out.println("Студенты отсортированы по убыванию среднего балла.");
    }

    private void findStudent(Scanner scanner) {
        System.out.print("Введите ФИО студента для поиска: ");
        String searchName = scanner.nextLine();

        try {
            Student student = labClass.findStudent(searchName);
            System.out.println("Найден студент: " + student);
        } catch (StudentNotFoundException | EmptyStringException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private void showStudents() {
        List<Student> students = labClass.getStudents();
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст.");
        } else {
            System.out.println("\n=== Список студентов ===");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}

// Класс запуска приложения
// Объявление публичного класса
public class LabClassDriver {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        LabClass labClass = new LabClass();
        LabClassUI labClassUI = new LabClassUI(labClass);
        labClassUI.start();
    }
}
