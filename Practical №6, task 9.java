interface Printable {
    void print();
}

class Book implements Printable {
    private String title;
    private String author;
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    @Override
    public void print() {
        System.out.println("Книга: " + title + " (Автор: " + author + ")");
    }
}

class Magazine implements Printable {
    private String name;
    
    public Magazine(String name) {
        this.name = name;
    }
    
    @Override
    public void print() {
        System.out.println("Журнал: " + name);
    }
}

// Объявление публичного класса
public class TestPrintableArray {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Printable[] printables = {
            new Book("1984", "Джордж Оруэлл"),
            new Magazine("National Geographic"),
            new Book("Мастер и Маргарита", "Михаил Булгаков"),
            new Magazine("Forbes")
        };
        
        for (Printable printable : printables) {
            printable.print();
        }
    }
}
