import java.util.Arrays;

// Класс, представляющий книгу
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}

// Класс Читатель
class Reader {
    private String fullName;
    private int libraryCardNumber;
    private String faculty;
    private String birthDate;
    private String phone;

    public Reader(String fullName, int libraryCardNumber, String faculty, String birthDate, String phone) {
        this.fullName = fullName;
        this.libraryCardNumber = libraryCardNumber;
        this.faculty = faculty;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    // Метод для взятия книг (по количеству)
    public void takeBook(int count) {
        System.out.println(fullName + " взял " + count + " книги");
    }

    // Метод для взятия книг (по названиям)
    public void takeBook(String... bookTitles) {
        System.out.println(fullName + " взял книги: " + String.join(", ", bookTitles));
    }

    // Метод для взятия книг (по объектам Book)
    public void takeBook(Book... books) {
        System.out.println(fullName + " взял книги: " + Arrays.toString(Arrays.stream(books).map(Book::getTitle).toArray()));
    }

    // Метод для возврата книг (по количеству)
    public void returnBook(int count) {
        System.out.println(fullName + " вернул " + count + " книги");
    }

    // Метод для возврата книг (по названиям)
    public void returnBook(String... bookTitles) {
        System.out.println(fullName + " вернул книги: " + String.join(", ", bookTitles));
    }

    // Метод для возврата книг (по объектам Book)
    public void returnBook(Book... books) {
        System.out.println(fullName + " вернул книги: " + Arrays.toString(Arrays.stream(books).map(Book::getTitle).toArray()));
    }
}

// Класс-тестер
// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Reader reader1 = new Reader("Петров В.В.", 12345, "Филология", "01.01.1990", "+7 900 123 45 67");
        Reader reader2 = new Reader("Иванов И.И.", 67890, "История", "15.05.1985", "+7 911 987 65 43");
        
        Book book1 = new Book("Приключения", "Автор 1");
        Book book2 = new Book("Словарь", "Автор 2");
        Book book3 = new Book("Энциклопедия", "Автор 3");

        // Демонстрация методов
        reader1.takeBook(3);
        reader1.takeBook("Приключения", "Словарь", "Энциклопедия");
        reader1.takeBook(book1, book2, book3);
        
        reader1.returnBook(3);
        reader1.returnBook("Приключения", "Словарь", "Энциклопедия");
        reader1.returnBook(book1, book2, book3);
    }
}
