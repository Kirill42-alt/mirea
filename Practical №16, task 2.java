import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Объявление публичного класса
public class TextEditor extends JFrame {
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu colorMenu, fontMenu;
    private JMenuItem blueItem, redItem, blackItem;
    private JMenuItem timesItem, sansItem, courierItem;

    public TextEditor() {
        setTitle("Text Editor");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(new JScrollPane(textArea));
        
        menuBar = new JMenuBar();
        
        // Меню выбора цвета
        colorMenu = new JMenu("Цвет");
        blueItem = new JMenuItem("Синий");
        redItem = new JMenuItem("Красный");
        blackItem = new JMenuItem("Черный");
        
        colorMenu.add(blueItem);
        colorMenu.add(redItem);
        colorMenu.add(blackItem);
        
        // Меню выбора шрифта
        fontMenu = new JMenu("Шрифт");
        timesItem = new JMenuItem("Times New Roman");
        sansItem = new JMenuItem("MS Sans Serif");
        courierItem = new JMenuItem("Courier New");
        
        fontMenu.add(timesItem);
        fontMenu.add(sansItem);
        fontMenu.add(courierItem);
        
        menuBar.add(colorMenu);
        menuBar.add(fontMenu);
        setJMenuBar(menuBar);
        
        // Обработчики событий для изменения цвета
        blueItem.addActionListener(e -> textArea.setForeground(Color.BLUE));
        redItem.addActionListener(e -> textArea.setForeground(Color.RED));
        blackItem.addActionListener(e -> textArea.setForeground(Color.BLACK));
        
        // Обработчики событий для изменения шрифта
        timesItem.addActionListener(e -> textArea.setFont(new Font("Times New Roman", Font.PLAIN, 16)));
        sansItem.addActionListener(e -> textArea.setFont(new Font("MS Sans Serif", Font.PLAIN, 16)));
        courierItem.addActionListener(e -> textArea.setFont(new Font("Courier New", Font.PLAIN, 16)));
    }

// Главный метод программы — точка входа
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextEditor().setVisible(true));
    }
}
