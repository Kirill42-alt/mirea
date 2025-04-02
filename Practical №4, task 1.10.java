public abstract class Transport {
    protected String name;            // Название ТС
    protected double speed;           // Скорость (км/ч)
    protected double pricePerKmPassenger; // Стоимость перевозки пассажира за км
    protected double pricePerKmCargo;     // Стоимость перевозки 1 кг груза за км

    public Transport(String name, double speed, double pricePerKmPassenger, double pricePerKmCargo) {
        this.name = name;
        this.speed = speed;
        this.pricePerKmPassenger = pricePerKmPassenger;
        this.pricePerKmCargo = pricePerKmCargo;
    }

    // Метод расчета времени перевозки (в часах)
    public double calculateTime(double distance) {
        if (speed == 0) return Double.POSITIVE_INFINITY;
        return distance / speed;
    }

    // Метод расчета стоимости перевозки пассажиров
    public double calculatePassengerCost(double distance, int passengers) {
        return distance * passengers * pricePerKmPassenger;
    }

    // Метод расчета стоимости перевозки грузов
    public double calculateCargoCost(double distance, double cargoWeight) {
        return distance * cargoWeight * pricePerKmCargo;
    }

    // Показать информацию
    public abstract void displayInfo();
}

// Объявление публичного класса
public class Car extends Transport {

    public Car() {
        super("Автомобиль", 80, 5.0, 2.0); // Примерные значения
    }

    @Override
    public void displayInfo() {
        System.out.println("Транспортное средство: " + name);
        System.out.println("Средняя скорость: " + speed + " км/ч");
        System.out.println("Стоимость за км (пассажир): " + pricePerKmPassenger + " руб.");
        System.out.println("Стоимость за км (груз): " + pricePerKmCargo + " руб.");
        System.out.println("-------------------------------");
    }
}

// Объявление публичного класса
public class Plane extends Transport {

    public Plane() {
        super("Самолет", 800, 10.0, 15.0);
    }

    @Override
    public void displayInfo() {
        System.out.println("Транспортное средство: " + name);
        System.out.println("Средняя скорость: " + speed + " км/ч");
        System.out.println("Стоимость за км (пассажир): " + pricePerKmPassenger + " руб.");
        System.out.println("Стоимость за км (груз): " + pricePerKmCargo + " руб.");
        System.out.println("-------------------------------");
    }
}

// Объявление публичного класса
public class Train extends Transport {

    public Train() {
        super("Поезд", 100, 3.0, 1.5);
    }

    @Override
    public void displayInfo() {
        System.out.println("Транспортное средство: " + name);
        System.out.println("Средняя скорость: " + speed + " км/ч");
        System.out.println("Стоимость за км (пассажир): " + pricePerKmPassenger + " руб.");
        System.out.println("Стоимость за км (груз): " + pricePerKmCargo + " руб.");
        System.out.println("-------------------------------");
    }
}

// Объявление публичного класса
public class Ship extends Transport {

    public Ship() {
        super("Корабль", 50, 4.0, 3.5);
    }

    @Override
    public void displayInfo() {
        System.out.println("Транспортное средство: " + name);
        System.out.println("Средняя скорость: " + speed + " км/ч");
        System.out.println("Стоимость за км (пассажир): " + pricePerKmPassenger + " руб.");
        System.out.println("Стоимость за км (груз): " + pricePerKmCargo + " руб.");
        System.out.println("-------------------------------");
    }
}

// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        double distance = 1000; // расстояние в км
        int passengers = 100;   // количество пассажиров
        double cargoWeight = 5000; // вес груза в кг

        // Список транспортных средств
        Transport[] transports = {
            new Car(),
            new Plane(),
            new Train(),
            new Ship()
        };

        // Тестируем каждый транспорт
        for (Transport transport : transports) {
            transport.displayInfo();

            double time = transport.calculateTime(distance);
            double passengerCost = transport.calculatePassengerCost(distance, passengers);
            double cargoCost = transport.calculateCargoCost(distance, cargoWeight);

            System.out.printf("Время в пути на %s: %.2f часов\n", transport.name, time);
            System.out.printf("Стоимость перевозки %d пассажиров: %.2f руб.\n", passengers, passengerCost);
            System.out.printf("Стоимость перевозки %.2f кг груза: %.2f руб.\n", cargoWeight, cargoCost);
            System.out.println("==========================================");
        }
    }
}
