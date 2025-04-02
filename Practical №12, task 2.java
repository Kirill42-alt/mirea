import javax.swing.*;
import java.awt.*;

// Объявление публичного класса
public class ImageDisplay extends JFrame {
    private ImageIcon imageIcon;

    public ImageDisplay(String imagePath) {
        setTitle("Image Viewer");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        imageIcon = new ImageIcon(imagePath);
        JLabel label = new JLabel(imageIcon);
        add(label);
    }

// Главный метод программы — точка входа
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Укажите путь к изображению в аргументах командной строки.");
            System.exit(1);
        }

        String imagePath = args[0];
        SwingUtilities.invokeLater(() -> new ImageDisplay(imagePath).setVisible(true));
    }
}
