public interface IDocument {
    void open();
    void save();
    void close();
}

public interface ICreateDocument {
    IDocument createNew();
    IDocument createOpen();
}

// Объявление публичного класса
public class TextDocument implements IDocument {
    @Override
    public void open() {
        System.out.println("Открыт текстовый документ.");
    }

    @Override
    public void save() {
        System.out.println("Сохранён текстовый документ.");
    }

    @Override
    public void close() {
        System.out.println("Закрыт текстовый документ.");
    }

    @Override
    public String toString() {
        return "Текстовый документ";
    }
}

// Объявление публичного класса
public class CreateTextDocument implements ICreateDocument {
    @Override
    public IDocument createNew() {
        System.out.println("Создан новый текстовый документ.");
        return new TextDocument();
    }

    @Override
    public IDocument createOpen() {
        System.out.println("Открыт существующий текстовый документ.");
        return new TextDocument();
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Объявление публичного класса
public class EditorApplication extends JFrame {
    private IDocument document;
    private final ICreateDocument factory;

    public EditorApplication(ICreateDocument factory) {
        this.factory = factory;
        setupGUI();
    }

    private void setupGUI() {
        setTitle("Редактор документа");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        // Меню File
        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Обработчики событий
        newItem.addActionListener(e -> createNewDocument());
        openItem.addActionListener(e -> openDocument());
        saveItem.addActionListener(e -> saveDocument());
        exitItem.addActionListener(e -> exitApplication());

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    private void createNewDocument() {
        document = factory.createNew();
        document.open();
    }

    private void openDocument() {
        document = factory.createOpen();
        document.open();
    }

    private void saveDocument() {
        if (document != null) {
            document.save();
        } else {
            JOptionPane.showMessageDialog(this, "Нет открытого документа для сохранения.");
        }
    }

    private void exitApplication() {
        if (document != null) {
            document.close();
        }
        System.out.println("Выход из приложения...");
        dispose(); // Закрытие окна
        System.exit(0);
    }
}

// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ICreateDocument factory = new CreateTextDocument();
            EditorApplication editor = new EditorApplication(factory);
            editor.setVisible(true);
        });
    }
}
