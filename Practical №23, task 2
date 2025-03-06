import java.util.Queue;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;

// Определение интерфейса очереди
interface CustomQueue<E> {
    void enqueue(E element);
    E dequeue();
    E element();
    int size();
    boolean isEmpty();
    void clear();
}

// Абстрактный класс для очереди
abstract class AbstractQueue<E> implements CustomQueue<E> {
    protected int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

// Очередь на массиве
class ArrayQueue<E> extends AbstractQueue<E> {
    private Object[] elements = new Object[10];
    private int head = 0, tail = 0;

    @Override
    public void enqueue(E element) {
        ensureCapacity(size + 1);
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        E result = (E) elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return result;
    }

    @Override
    public E element() {
        if (isEmpty()) throw new NoSuchElementException();
        return (E) elements[head];
    }

    @Override
    public void clear() {
        elements = new Object[10];
        size = head = tail = 0;
    }

    private void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
            head = 0;
            tail = size;
        }
    }
}

// Очередь на связанном списке
class LinkedQueue<E> extends AbstractQueue<E> {
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;

    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        E result = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return result;
    }

    @Override
    public E element() {
        if (isEmpty()) throw new NoSuchElementException();
        return head.value;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }
}
