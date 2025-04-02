// Объявление публичного класса
public class ThrowsDemo {

    public void printMessage(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: ключ не должен быть null! " + e.getMessage());
        }
    }

    public String getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }

// Главный метод программы — точка входа
    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();

        // 1. Передаём правильный ключ
        demo.printMessage("User123");

        // 2. Передаём null
        demo.printMessage(null);

        System.out.println("Программа завершена корректно.");
    }
}
