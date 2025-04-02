import java.util.Date;

// Объявление публичного класса
public class DeveloperInfo {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        // Фамилия разработчика
        String developerName = "Малинин";
        
        // Дата и время получения задания (примерное значение)
        Date receivedDate = new Date(1640995200000L); // 1 января 2022, 00:00:00
        
        // Дата и время сдачи задания (текущее время)
        Date submissionDate = new Date();
        
        // Вывод информации
        System.out.println("Фамилия разработчика: " + developerName);
        System.out.println("Дата и время получения задания: " + receivedDate);
        System.out.println("Дата и время сдачи задания: " + submissionDate);
    }
}
