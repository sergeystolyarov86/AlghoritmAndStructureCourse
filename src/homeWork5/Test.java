package homeWork5;


import java.util.*;

public class Test {
    static Set<String> resultSet = new LinkedHashSet<>();
    static String[] arr;
    static Map<String, Integer> heightMap;
    static Map<String, Integer> coastMap;

    public static void main(String[] args) {
        heightMap = new HashMap<>();
        coastMap = new HashMap<>();

        heightMap.put("watch", 1);
        heightMap.put("notebook", 4);
        heightMap.put("kettlebell", 4);
        heightMap.put("guitar", 2);
        heightMap.put("smartphone", 1);
        coastMap.put("watch", 15000);
        coastMap.put("notebook", 40000);
        coastMap.put("kettlebell", 3500);
        coastMap.put("guitar", 37000);
        coastMap.put("smartphone", 15000);

        List<String> things = new ArrayList<>(coastMap.keySet());

        System.out.println(exponentiation(2, 5));

        bag(things);

        System.out.printf("лучше всего из этого списка взять %s,это будет стоить %d и весить %d кг",iAmWinner(resultSet),
                coastThings(iAmWinner(resultSet)),heightThings(iAmWinner(resultSet)));


    }
 /**
    задание 1
  */
    static int exponentiation(int value, int degree) {
        if (degree == 1) return value;
        return value * exponentiation(value, --degree);
    }


   static Set<String> bag(List<String> things) {
        resultSet.clear();
        arr = new String[things.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = things.get(i);
        }
        find(arr.length);
        return resultSet;
    }

   static void find(int lenght) {
        if (lenght == 1) return;
        for (int i = 0; i < lenght; i++) {
            find(lenght - 1);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < lenght; j++) {

                 sb.append(arr[j]);
                if(j!= lenght-1)sb.append(",");
            }
            if (heightThings(sb.toString())<6)  resultSet.add(sb.toString());
            sb = null;
            rotate(lenght);
        }
    }

   static void rotate(int lenght) {
        int first = arr.length - lenght;
        String temp = arr[first];
        for (int i = first + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
    }

   static int heightThings(String str) {
        int height = 0;
        String[] arr = str.split(",");
        for (int i = 0; i < arr.length ; i++) {
             height += heightMap.get(arr[i]);
        }
        return height;
    }

   static int coastThings(String str){
        int coast = 0;
        String[] arr = str.split(",");
        for (int i = 0; i < arr.length ; i++) {
           coast += coastMap.get(arr[i]);
        }
        return coast;
    }

     static String iAmWinner(Set<String> str) {
         int max = 0;
         String result = null;
         for (String s : resultSet) {
             if (coastThings(s) > max) {
                 result = s;
                 max=coastThings(s);
             }
         }return result;
     }

}

