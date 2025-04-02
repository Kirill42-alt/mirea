// Интерфейс StringOperations
interface StringOperations {
    int countCharacters(String s);
    String oddCharacters(String s);
    String reverseString(String s);
}

// Класс StringProcessor, реализующий интерфейс
class StringProcessor implements StringOperations {
    @Override
    public int countCharacters(String s) {
        return s.length();
    }

    @Override
    public String oddCharacters(String s) {
        StringBuilder result = new StringBuilder();
// Цикл для прохода по элементам массива
        for (int i = 0; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    @Override
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

// Тестирование
// Объявление публичного класса
public class Main {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        StringOperations strOp = new StringProcessor();
        String testString = "Программирование";
        
        // Подсчет символов
        System.out.println("Количество символов: " + strOp.countCharacters(testString));
        
        // Строка из нечетных позиций
        System.out.println("Символы на нечетных позициях: " + strOp.oddCharacters(testString));
        
        // Инвертированная строка
        System.out.println("Инвертированная строка: " + strOp.reverseString(testString));
    }
}
