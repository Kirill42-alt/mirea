import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Объявление публичного класса
public class MenuApplication extends JFrame {
    private JTextArea textArea;

    public MenuApplication() {
        setTitle("Hello Swing");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Создание меню
        JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Сохранить");
        JMenuItem exitItem = new JMenuItem("Выйти");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem copyItem = new JMenuItem("Копировать");
        JMenuItem cutItem = new JMenuItem("Вырезать");
        JMenuItem pasteItem = new JMenuItem("Вставить");
        copyItem.addActionListener(e -> textArea.copy());
        cutItem.addActionListener(e -> textArea.cut());
        pasteItem.addActionListener(e -> textArea.paste());
        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);
        
        JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        // Создание текстового поля
        textArea = new JTextArea("This is the area you can write text.");
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Создание панели с кнопками
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        add(buttonPanel, BorderLayout.NORTH);
    }

// Главный метод программы — точка входа
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuApplication().setVisible(true));
    }
}
