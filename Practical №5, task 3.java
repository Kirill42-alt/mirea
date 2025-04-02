import javax.swing.*;
import java.awt.*;

// Объявление публичного класса
public class ImageViewer extends JFrame {
    private ImageIcon image;

    public ImageViewer(String imagePath) {
        setTitle("Image Viewer");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        image = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(image);
        add(imageLabel, BorderLayout.CENTER);
    }

// Главный метод программы — точка входа
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Ошибка: Укажите путь к изображению в аргументах командной строки.");
            return;
        }
        String imagePath = args[0];
        SwingUtilities.invokeLater(() -> new ImageViewer(imagePath).setVisible(true));
    }
}

// java ImageViewer "файл.png"
