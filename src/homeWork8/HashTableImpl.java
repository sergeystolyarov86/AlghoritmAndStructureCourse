package homeWork8;


import java.util.LinkedList;
import java.util.List;

public class HashTableImpl<K, V> implements HashTable<K, V> {
    final List<Item<K, V>>[] data;
    private int size;

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            if(value==null) System.out.println("товара нет в наличии");
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("key: %s -> value: %s", key, value);
        }
    }

    public HashTableImpl(int initialCapacity) {
        this.data = new List[initialCapacity * 2];
    }

    public HashTableImpl() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        int indexFromHashFunc = hashFunc(key);
        if (data[indexFromHashFunc] == null) {
            data[indexFromHashFunc] = new LinkedList<>();
        }
        data[indexFromHashFunc].add(0,new Item<>(key, value));
        size++;
        return true;
    }


    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        List<Item<K, V>> list = data[index];
        for (Item<K, V> kvItem : list) {
            if (kvItem.getKey().equals(key)) return kvItem.value;
        }
        return null;
    }

    private int indexOf(K key) {
        int indexFromHashFunc = hashFunc(key);
        for (int i = 0; i < data.length; i++) {
            if (i == indexFromHashFunc) {
                return indexFromHashFunc;
            }
        }
        return -1;
    }


    @Override
    public V remove(K key) {
        int index = indexOf(key);
        V remove = null;
        if (index == -1) {
            return null;
        }
        List<Item<K, V>> list = data[index];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                remove = list.get(i).value;
                list.remove(list.get(i));
                --size;
            }
        }

        return remove;
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
        System.out.println("Size is " + size());
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                sb.append(String.format("%s = [%s]%n", i, data[i]));
            } else {
                for (int j = 0; j < data[i].size(); j++) {
                    sb.append(String.format("%s = [%s]%n", i, data[i].get(j)));
                }
            }
        }
        return sb.toString();
    }
}

