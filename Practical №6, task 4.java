interface Priceable {
    double getPrice();
}

class Product implements Priceable {
    private String name;
    private double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return "Товар: " + name + ", Цена: " + price + " руб.";
    }
}

class Service implements Priceable {
    private String description;
    private double price;
    
    public Service(String description, double price) {
        this.description = description;
        this.price = price;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return "Услуга: " + description + ", Стоимость: " + price + " руб.";
    }
}

// Объявление публичного класса
public class TestPriceable {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Priceable phone = new Product("Смартфон", 49999.99);
        Priceable haircut = new Service("Стрижка", 1500.00);
        
        System.out.println(phone);
        System.out.println(haircut);
    }
}
