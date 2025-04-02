interface Printable {
    void print();
}

class Shop implements Printable {
    private String name;
    private String address;

    public Shop(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public void print() {
        System.out.println("Магазин: " + name + ", Адрес: " + address);
    }
}

// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Shop shop1 = new Shop("Tech Store", "123 Main St");
        Shop shop2 = new Shop("Book Haven", "456 Elm St");
        
        shop1.print();
        shop2.print();
    }
}
