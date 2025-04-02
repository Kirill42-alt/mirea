import java.util.ArrayList;
import java.util.List;

// Фильтр для удаления ненужных элементов
interface Filter {
    boolean apply(Object o);
}

// Объявление публичного класса
public class ArrayFilter {
    
    public static <T> List<T> filter(T[] array, Filter filter) {
        List<T> result = new ArrayList<>();
        for (T element : array) {
            if (filter.apply(element)) {
                result.add(element);
            }
        }
        return result;
    }

// Главный метод программы — точка входа
    public static void main(String[] args) {
        // Тест с числами (оставляем только четные)
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> evenNumbers = filter(numbers, o -> (Integer) o % 2 == 0);
        System.out.println("Четные числа: " + evenNumbers);

        // Тест со строками (оставляем только те, которые начинаются с 'A')
        String[] words = {"Apple", "Banana", "Avocado", "Cherry", "Apricot"};
        List<String> filteredWords = filter(words, o -> ((String) o).startsWith("A"));
        System.out.println("Слова, начинающиеся на 'A': " + filteredWords);
    }
}
