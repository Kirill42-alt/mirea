// Объявление публичного класса
public class Student {
    private String firstName; // имя
    private String lastName; // фамилия
    private String major; // специальность
    private int year; // курс
    private String group; // группа

    // Конструктор
    public Student(String firstName, String lastName, String major, int year, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.year = year;
        this.group = group;
    }

    // Геттеры (методы для чтения значений полей)
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMajor() {
        return major;
    }

    public int getYear() {
        return year;
    }

    public String getGroup() {
        return group;
    }

    // Сеттеры (методы для изменения значений полей)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student { " +
                "Имя: '" + firstName + '\'' +
                ", Фамилия: '" + lastName + '\'' +
                ", Специальность: '" + major + '\'' +
                ", Курс: " + year +
                ", Группа: '" + group + '\'' +
                " }";
    }

    // Тестовый класс
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Student student = new Student("Иван", "Петров", "Информатика", 3, "ИВТ-21");
        System.out.println(student);

        // Обновление данных
        student.setYear(4);
        student.setGroup("ИВТ-22");
        System.out.println("После обновления: " + student);
    }
}
