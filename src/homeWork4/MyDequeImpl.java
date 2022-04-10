package homeWork4;

import java.util.Iterator;
import java.util.function.Consumer;

public class MyDequeImpl<E> implements Deque<E>, Iterable<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    @Override
    public void insertFirst(E value) {
        if (isEmpty()) first = new Node<>(value, null, first);
        Node<E> newNode = new Node<>(value, null, first);
        first.prev = newNode;
        first = newNode;

        size++;
        if (size == 1) {
            last = first;
        }

    }

    @Override
    public void insertLast(E value) {
        if (isEmpty()) {
            insertFirst(value);
            return;
        }

        Node<E> newNode = new Node<>(value, last, null);
        last.next = newNode;
        last = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = first;
        first = removedNode.next;
        first.prev = null;
        size--;
        return removedNode.value;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = last;
        last = removedNode.prev;
        last.next = null;
        size--;
        return removedNode.value;
    }

    @Override
    public E getLast() {
        return (E) last;
    }

    @Override
    public E getFirst() {
        return (E) first;
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
    public void display() {
        System.out.println(this);
    }

    @Override
    public void reverseDisplay() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = last;

        while (current != null) {
            sb.append(current.value);
            if (current.prev != null) {
                sb.append(" -> ");
            }
            current = current.prev;
        }

        sb.append("]");
        System.out.println(sb);

    }

    /**
     *   второе задание
     */

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                try {
                    return current.value;
                } finally {
                    current = current.next;
                }
            }
        };
    }


    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }


    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        public Node(E value, Node<E> prev, Node<E> next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

//        @Override
//        public String toString() {
//            return "Node{" +
//                    "value=" + value +
//                    '}';
//        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;

        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.append("]").toString();

    }
}
