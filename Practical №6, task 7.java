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

// Объявление публичного класса
public class TestBook {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Printable book = new Book("1984", "Джордж Оруэлл");
        book.print();
    }
}
