package homeWork3;

import java.util.Arrays;

public class QueueImpl<E> implements Queue<E> {

    private final E[] data;
    private int size;
    private int tail;
    private int head;

    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        tail = -1;
        head = 0;


    }

    @Override
    public boolean insert(E value) {
        if (isFull()) return false;
        if (tail + 1 == data.length) tail = -1;
        data[++tail] = value;
        size++;

//        System.out.println("tail " + tail);
//        System.out.println("head " + head);
//        System.out.println(Arrays.toString(data));
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) return null;
        if (size == 1) {
            data[head] = null;
            tail = -1;
            head = 0;
        }
        E value = data[head];
        data[head++] = null;
        if (head == data.length) head = 0;

        size--;
//        System.out.println("tail " + tail);
//        System.out.println("head " + head);
//        System.out.println(Arrays.toString(data));
        return value;
    }

    @Override
    public E peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (head > tail) {
            for (int i = head; i < data.length; i++) {
                sb.append(data[i]);
                sb.append(", ");
            }
            for (int i = 0; i <= tail; i++) {
                sb.append(data[i]);
                if (i != tail) {
                    sb.append(", ");
                }
            }
            return sb.append("]").toString();

        }
        for (int i = head; i <= tail; i++) {
            sb.append(data[i]);
            if (i < tail) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
}
