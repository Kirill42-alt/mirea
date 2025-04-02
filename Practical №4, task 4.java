// Перечисление для марок компьютеров
enum ComputerBrand {
    DELL, HP, APPLE, ASUS, LENOVO;
}

// Класс процессора
class Processor {
    private String model;
    private double frequency; // ГГц

    public Processor(String model, double frequency) {
        this.model = model;
        this.frequency = frequency;
    }

    public String getModel() {
        return model;
    }

    public double getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return model + " @ " + frequency + " ГГц";
    }
}

// Класс оперативной памяти
class Memory {
    private int size; // ГБ

    public Memory(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return size + " ГБ RAM";
    }
}

// Класс монитора
class Monitor {
    private double size; // Дюймы
    private String resolution;

    public Monitor(double size, String resolution) {
        this.size = size;
        this.resolution = resolution;
    }

    public double getSize() {
        return size;
    }

    public String getResolution() {
        return resolution;
    }

    @Override
    public String toString() {
        return size + " дюймов, " + resolution;
    }
}

// Класс компьютера
class Computer {
    private ComputerBrand brand;
    private Processor processor;
    private Memory memory;
    private Monitor monitor;

    public Computer(ComputerBrand brand, Processor processor, Memory memory, Monitor monitor) {
        this.brand = brand;
        this.processor = processor;
        this.memory = memory;
        this.monitor = monitor;
    }

    public ComputerBrand getBrand() {
        return brand;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    @Override
    public String toString() {
        return "Компьютер " + brand + ":\n" +
                "Процессор: " + processor + "\n" +
                "Оперативная память: " + memory + "\n" +
                "Монитор: " + monitor;
    }
}

// Тестирование
// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Processor processor = new Processor("Intel Core i7", 3.5);
        Memory memory = new Memory(16);
        Monitor monitor = new Monitor(27, "2560x1440");
        
        Computer myComputer = new Computer(ComputerBrand.APPLE, processor, memory, monitor);
        
        System.out.println(myComputer);
    }
}
