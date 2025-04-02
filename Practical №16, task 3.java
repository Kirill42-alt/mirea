import javax.swing.*;
import java.awt.*;

// Объявление публичного класса
public class PasswordApplication {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        // Создание основного окна
        JFrame frame = new JFrame("Password application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 150);
        frame.setLayout(new GridLayout(3, 2, 5, 5));

        // Создание компонентов
        JLabel serviceLabel = new JLabel("Service:");
        JTextField serviceField = new JTextField();
        
        JLabel userLabel = new JLabel("User name:");
        JTextField userField = new JTextField();
        
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        // Добавление компонентов в окно
        frame.add(serviceLabel);
        frame.add(serviceField);
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passwordLabel);
        frame.add(passwordField);

        // Отображение окна
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
