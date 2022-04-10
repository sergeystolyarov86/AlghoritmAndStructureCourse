package homeWork4;

public class Test {
    public static void main(String[] args) {
        /**
         * третье задание реализовано в классе MyDequeImpl
         */

        MyDequeImpl<Integer> test = new MyDequeImpl<>();

        test.insertFirst(5);
        test.insertFirst(4);
        test.insertFirst(3);
        test.insertFirst(2);
        test.insertFirst(1);
        test.insertLast(6);
        test.insertFirst(0);
        test.removeLast();
        test.removeFirst();


        test.forEach(s -> System.out.print(s + " "));
        System.out.println();

        test.display();
        test.reverseDisplay();

    }


}
