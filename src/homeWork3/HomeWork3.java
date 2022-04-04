package homeWork3;

public class HomeWork3 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15};//11
        int[] arr2 = {1, 2, 4, 5, 6};// 3
        int[] arr3 = {2, 3, 4, 5, 6, 7, 8}; // 1
        int[] arr4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}; // 15
        int[] arr5 = {};// 1
        int[] wrongArr = {1, 3, 5}; //Exception

        System.out.println(whoWasForgotten(arr1));
        System.out.println(whoWasForgotten(arr2));
        System.out.println(whoWasForgotten(arr3));
        System.out.println(whoWasForgotten(arr4));
        System.out.println(whoWasForgotten(arr5));
        new Thread(() -> System.out.println(whoWasForgotten(wrongArr))).start();


        QueueImpl<Integer> queue = new QueueImpl<>(5);
        queue.insert(34);
        queue.insert(12);
        queue.insert(20);
        queue.insert(14);
        queue.insert(17);
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.insert(8);
        System.out.println(queue);
        queue.insert(5);
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);


    }

    /**
     * У меня была мысль реализовать этот алгоритм сравнивая суммы первого и последнего числа массива и с каждой
     * итерацией arr(i) == arr[arr.lenght-1-i]  arr.leght кол-во раз,если сумма отличалась от первой,то дырка найдена,
     * но уже не успеваю так сделать.у меня вопрос,такой подход был бы лучше,чем тот что я сделал?по сложности вроде
     * также получается.
     */
    static int whoWasForgotten(int[] arr) {
        if (arr.length == 0) return 1;
        if (arr[0] != 1 && arr[0] > 2) throw new WrongArrayException();
        if (arr[0] != 1) return 1;
        int res = 0;
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int prev = arr[i - 1];
            if (prev + 1 != current && current - prev < 3) {
                res = prev + 1;
                count++;
            }
            if (current - prev > 2 || count > 1) throw new WrongArrayException();
            if (i == arr.length - 1 && res == 0) res = arr[i] + 1;
        }
        return res;
    }
}

