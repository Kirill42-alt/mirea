import java.util.Scanner;

// Исключение для недействительного ИНН
class InvalidINNException extends Exception {
    public InvalidINNException(String message) {
        super(message);
    }
}

// Класс для обработки заказа
class OnlinePurchase {
    private String fullName;
    private String inn;
    
    public OnlinePurchase(String fullName, String inn) throws InvalidINNException {
        if (!isValidINN(inn)) {
            throw new InvalidINNException("Ошибка: Недействительный ИНН!");
        }
        this.fullName = fullName;
        this.inn = inn;
    }
    
    private boolean isValidINN(String inn) {
        return inn.matches("\\d{12}"); // ИНН должен состоять из 12 цифр
    }
    
    public void confirmPurchase() {
        System.out.println("Покупка подтверждена для " + fullName + " с ИНН: " + inn);
    }
}

// Тестирование
// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите ФИО: ");
            String fullName = scanner.nextLine();
            
            System.out.print("Введите ИНН: ");
            String inn = scanner.nextLine();
            
            OnlinePurchase order = new OnlinePurchase(fullName, inn);
            order.confirmPurchase();
            
        } catch (InvalidINNException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
