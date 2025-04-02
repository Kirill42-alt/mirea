import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

// Объявление публичного класса
public class GuessingGame extends JFrame {
    private int targetNumber;
    private int attempts;
    private JTextField inputField;
    private JButton guessButton;
    private JLabel messageLabel;

    public GuessingGame() {
        setTitle("Игра-угадайка");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Генерируем случайное число от 0 до 20
        Random random = new Random();
        targetNumber = random.nextInt(21);
        attempts = 3;
        
        // Панель для ввода и кнопки
        JPanel inputPanel = new JPanel();
        inputField = new JTextField(5);
        guessButton = new JButton("Угадать");
        inputPanel.add(new JLabel("Введите число (0-20):"));
        inputPanel.add(inputField);
        inputPanel.add(guessButton);
        
        // Сообщение пользователю
        messageLabel = new JLabel("Попробуйте угадать число!", SwingConstants.CENTER);
        
        // Добавляем компоненты в окно
        add(messageLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        
        // Обработчик нажатия кнопки
        guessButton.addActionListener(e -> checkGuess());
        
        // Добавление событий мыши для областей макета
        addMouseListeners();
    }

    private void checkGuess() {
        try {
            int guess = Integer.parseInt(inputField.getText());
            if (guess == targetNumber) {
                JOptionPane.showMessageDialog(this, "Поздравляем! Вы угадали число " + targetNumber);
                System.exit(0);
            } else {
                attempts--;
                if (attempts > 0) {
                    messageLabel.setText("Неправильно! Число " + (guess < targetNumber ? "больше" : "меньше") + ". Осталось попыток: " + attempts);
                } else {
                    JOptionPane.showMessageDialog(this, "Вы проиграли! Загаданное число было: " + targetNumber);
                    System.exit(0);
                }
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Введите корректное число!");
        }
    }

    private void addMouseListeners() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getX() < getWidth() / 5) {
                    JOptionPane.showMessageDialog(null, "Добро пожаловать в ЗАО");
                } else if (e.getX() > getWidth() * 4 / 5) {
                    JOptionPane.showMessageDialog(null, "Добро пожаловать в ВАО");
                } else if (e.getY() < getHeight() / 5) {
                    JOptionPane.showMessageDialog(null, "Добро пожаловать в САО");
                } else if (e.getY() > getHeight() * 4 / 5) {
                    JOptionPane.showMessageDialog(null, "Добро пожаловать в ЮАО");
                } else {
                    JOptionPane.showMessageDialog(null, "Добро пожаловать в ЦАО");
                }
            }
        });
    }

// Главный метод программы — точка входа
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuessingGame().setVisible(true));
    }
}
