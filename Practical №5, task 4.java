import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

// Объявление публичного класса
public class AnimationViewer extends JFrame {
    private JLabel imageLabel;
    private Timer timer;
    private BufferedImage spriteSheet;
    private int frameWidth;
    private int frameHeight;
    private int currentFrame = 0;
    private int totalFrames;

    public AnimationViewer(String imagePath, int frameWidth, int frameHeight, int frameCount, int delay) {
        setTitle("Animation Viewer");
        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.totalFrames = frameCount;

        try {
            spriteSheet = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            System.out.println("Ошибка загрузки изображения: " + e.getMessage());
            return;
        }

        imageLabel = new JLabel(new ImageIcon(getFrame(currentFrame)));
        add(imageLabel, BorderLayout.CENTER);

        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame = (currentFrame + 1) % totalFrames;
                imageLabel.setIcon(new ImageIcon(getFrame(currentFrame)));
            }
        });
        timer.start();
    }

    private Image getFrame(int frameIndex) {
        return spriteSheet.getSubimage(frameIndex * frameWidth, 0, frameWidth, frameHeight);
    }

// Главный метод программы — точка входа
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Использование: java AnimationViewer <путь_к_изображению> <ширина_кадра> <высота_кадра> <количество_кадров> <задержка_в_мс>");
            return;
        }
        String imagePath = args[0];
        int frameWidth = Integer.parseInt(args[1]);
        int frameHeight = Integer.parseInt(args[2]);
        int frameCount = Integer.parseInt(args[3]);
        int delay = Integer.parseInt(args[4]);

        SwingUtilities.invokeLater(() -> new AnimationViewer(imagePath, frameWidth, frameHeight, frameCount, delay).setVisible(true));
    }
}
