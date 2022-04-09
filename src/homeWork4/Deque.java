package homeWork4;

public interface Deque<E> {

    void insertFirst(E value);

    void insertLast(E value);

    E removeFirst();

    E removeLast();

    E getLast();

    E getFirst();

    int size();

    boolean isEmpty();

    void display();

    void reverseDisplay();


}
