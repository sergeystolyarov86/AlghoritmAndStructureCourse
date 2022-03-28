package homeWork1;


public class HomeWork1 {

    /**
     -. Поиск элемента массива с известным индексом -   O(1)
     -. Дублирование одномерного массива через foreach  - O(n)
     -. Удаление элемента массива с известным индексом без сдвига - O(1)
     -. Удаление элемента массива с неизвестным индексом без сдвига - O(n)
     -. Удаление элемента массива с неизвестным индексом со сдвигом - O(n)


     а)
     int n = 10000;                                O(1)
     List<Integer> arrayList = new ArrayList<>();  O(1)
     for (int i = 0; i < n; i++) {                 O(n)
     for (int j = 1; j < n; j *= 2) {              O(logn)
     arrayList.add(i * j);                         O(1)
     }
     }                                     Ответ - O(n*logn)


     b)

     int n = 10000;                                 O(1)
     List<Integer> arrayList = new ArrayList<>();   O(1)
     for (int i = 0; i < n; i += 2) {               O(n)
     for (int j = i; j < n; j++) {                  O(n)
     arrayList.add(i * j);                          O(1)
     }
     }                                      Ответ - O(n^2)

     с)

     int n = 10000;                                O(1)
     List<Integer> arrayList = new ArrayList<>();  O(1)
     for (int i = 0; i < n; i ++) {                O(n)
     for (int j = 0; j < n; j++) {                 O(n)
     arrayList.add(i * j);                         O(1)
     n--;                                          O(1)
     }
     }                                     Ответ - O(n^2)


     d*)

     factorial(12)

     public static int factorial(int n) {
     if (n == 1) {
     return n;                               O(1)
     }
     return n * factorial(n - 1);            O(n)
     }                               Ответ - O(n)

     e*)
     fib(20);

     public static int fib(int n) {
     if (n == 1) || (n == 2)) {
     return n;                                O(1)
     }
     return fib(n - 1) + fib(n - 2);          O(n)
     }                                Ответ - O(n)

     */


    }

