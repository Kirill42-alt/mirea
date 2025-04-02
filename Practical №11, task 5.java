import java.util.*;

// Объявление публичного класса
public class ListPerformanceTest {

    private static final int ELEMENTS = 100_000;

// Главный метод программы — точка входа
    public static void main(String[] args) {
        // Сравнение ArrayList и LinkedList
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("===== ADD (добавление в конец) =====");
        testAdd(arrayList, "ArrayList");
        testAdd(linkedList, "LinkedList");

        System.out.println("\n===== INSERT (вставка в середину) =====");
        testInsert(arrayList, "ArrayList");
        testInsert(linkedList, "LinkedList");

        System.out.println("\n===== REMOVE (удаление из середины) =====");
        testRemove(arrayList, "ArrayList");
        testRemove(linkedList, "LinkedList");

        System.out.println("\n===== SEARCH (поиск элемента) =====");
        testSearch(arrayList, "ArrayList");
        testSearch(linkedList, "LinkedList");
    }

    private static void testAdd(List<Integer> list, String type) {
        list.clear();
        long startTime = System.nanoTime();

// Цикл для прохода по элементам массива
        for (int i = 0; i < ELEMENTS; i++) {
            list.add(i);
        }

        long endTime = System.nanoTime();
        System.out.println(type + " - add(): " + (endTime - startTime) / 1_000_000 + " ms");
    }

    private static void testInsert(List<Integer> list, String type) {
        list.clear();
// Цикл для прохода по элементам массива
        for (int i = 0; i < ELEMENTS; i++) {
            list.add(i);
        }

        long startTime = System.nanoTime();

// Цикл для прохода по элементам массива
        for (int i = 0; i < 1000; i++) {
            list.add(ELEMENTS / 2, -1); // Вставка в середину
        }

        long endTime = System.nanoTime();
        System.out.println(type + " - insert(): " + (endTime - startTime) / 1_000_000 + " ms");
    }

    private static void testRemove(List<Integer> list, String type) {
        list.clear();
// Цикл для прохода по элементам массива
        for (int i = 0; i < ELEMENTS; i++) {
            list.add(i);
        }

        long startTime = System.nanoTime();

// Цикл для прохода по элементам массива
        for (int i = 0; i < 1000; i++) {
            list.remove(ELEMENTS / 2); // Удаление из середины
        }

        long endTime = System.nanoTime();
        System.out.println(type + " - remove(): " + (endTime - startTime) / 1_000_000 + " ms");
    }

    private static void testSearch(List<Integer> list, String type) {
        list.clear();
// Цикл для прохода по элементам массива
        for (int i = 0; i < ELEMENTS; i++) {
            list.add(i);
        }

        long startTime = System.nanoTime();

// Цикл для прохода по элементам массива
        for (int i = 0; i < 1000; i++) {
            list.contains(ELEMENTS - 1); // Поиск элемента
        }

        long endTime = System.nanoTime();
        System.out.println(type + " - search(): " + (endTime - startTime) / 1_000_000 + " ms");
    }
}
