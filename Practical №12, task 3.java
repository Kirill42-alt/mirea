import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Объявление публичного класса
public class AnimatedWindow extends JPanel implements ActionListener {
    private ImageIcon[] frames;
    private int currentFrame = 0;
    private Timer timer;

    public AnimatedWindow(String[] imagePaths, int delay) {
        frames = new ImageIcon[imagePaths.length];
// Цикл для прохода по элементам массива
        for (int i = 0; i < imagePaths.length; i++) {
            frames[i] = new ImageIcon(imagePaths[i]);
        }
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (frames[currentFrame] != null) {
            g.drawImage(frames[currentFrame].getImage(), 50, 50, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentFrame = (currentFrame + 1) % frames.length;
        repaint();
    }

// Главный метод программы — точка входа
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Укажите пути к изображениям кадров анимации в аргументах командной строки.");
            System.exit(1);
        }

        JFrame frame = new JFrame("Animation");
        AnimatedWindow animation = new AnimatedWindow(args, 100);
        frame.add(animation);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
