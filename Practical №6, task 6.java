interface Printable {
    void print();
}

class Book implements Printable {
    private String title;
    
    public Book(String title) {
        this.title = title;
    }
    
    @Override
    public void print() {
        System.out.println("Книга: " + title);
    }
}

class Newspaper implements Printable {
    private String name;
    
    public Newspaper(String name) {
        this.name = name;
    }
    
    @Override
    public void print() {
        System.out.println("Газета: " + name);
    }
}

// Объявление публичного класса
public class TestPrintable {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Printable book = new Book("Война и мир");
        Printable newspaper = new Newspaper("Известия");
        
        book.print();
        newspaper.print();
    }
}
