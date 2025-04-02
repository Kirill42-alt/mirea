// Класс Employee
// Объявление публичного класса
public class Employee {
    private String fullName;   // ФИО сотрудника
    private double salary;     // Зарплата сотрудника

    // Конструктор
    public Employee(String fullName, double salary) {
        this.fullName = fullName;
        this.salary = salary;
    }

    // Геттеры для получения данных
    public String getFullName() {
        return fullName;
    }

    public double getSalary() {
        return salary;
    }
}

// Класс Report для формирования отчёта
// Объявление публичного класса
public class Report {

    // Статический метод для генерации отчёта по массиву сотрудников
    public static void generateReport(Employee[] employees) {

        // Заголовок таблицы
        System.out.printf("%-30s %20s\n", "Сотрудник", "Зарплата (USD)");
        System.out.println("---------------------------------------------------------------");

        // Проход по каждому сотруднику и вывод данных
        for (Employee emp : employees) {
            // %-30s - имя, выравнено по левому краю, ширина 30 символов
            // %20.2f - зарплата, выравнено по правому краю, 2 знака после запятой
            System.out.printf("%-30s %20.2f\n", emp.getFullName(), emp.getSalary());
        }

        // Конец таблицы
        System.out.println("---------------------------------------------------------------");
    }
}


// Основной класс с методом main
// Объявление публичного класса
public class Main {

// Главный метод программы — точка входа
    public static void main(String[] args) {
        // Создание массива сотрудников
        Employee[] employees = {
            new Employee("Иванов Иван Иванович", 55000.50),
            new Employee("Петров Петр Петрович", 70000.00),
            new Employee("Сидорова Светлана Юрьевна", 62000.75),
            new Employee("Кузнецов Андрей Павлович", 80000.00),
            new Employee("Смирнова Мария Викторовна", 72000.20)
        };

        // Генерация отчёта
        Report.generateReport(employees);
    }
}
