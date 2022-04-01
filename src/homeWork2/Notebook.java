package homeWork2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Notebook implements Comparable<Notebook> {
    private List<Notebook> warehouse;
    private int coast;
    private int ram;
    private Brands brand;

    private Notebook(int coast, int ram, Brands brand) {
        this.coast = coast;
        this.ram = ram;
        this.brand = brand;
    }

    public Notebook() {
    }


    @Override
    public int compareTo(Notebook o) {
        if (this.coast > o.coast) return 1;
        if (this.coast < o.coast) return -1;
        else {
            if (this.ram > o.ram) return 1;
            if (this.ram < o.ram) return -1;
            else {
                return this.brand.ordinal() - o.brand.ordinal();
            }
        }
    }

    public enum Brands {
        LENUVO,
        ASOS,
        MACNOTE,
        ESER,
        XAMIOU,
    }

    public void createNotebookWarehouse(int count) {
        warehouse = new ArrayList<>();
        Random genCoast = new Random();
        Random genRam = new Random();
        Random genBrand = new Random();
        for (int i = 0; i < count; i++) {
            int coast = 500 + genCoast.nextInt(31) * 50;
            int ram = 4 + genRam.nextInt(6) * 4;
            Brands brand = Brands.values()[genBrand.nextInt(5)];
            warehouse.add(new Notebook(coast, ram, brand));
        }
    }

    void notebookSort() {
        Notebook[] arr = new Notebook[warehouse.size()];
        for (int i = 0; i < warehouse.size(); i++) {
            arr[i] = warehouse.get(i);
        }

        for (int i = 0; i < arr.length; i++) {
            int left = i;
            for (int j = left + 1; j < arr.length; j++) {
                if (arr[left].coast > arr[j].coast) left = j;
                else if (arr[left].ram > arr[j].ram && arr[left].coast == arr[j].coast ) left = j;
                else if (arr[left].ram == arr[j].ram && arr[left].coast == arr[j].coast &&
                        arr[left].brand.ordinal() > arr[j].brand.ordinal()) left = j;
            }
            Notebook temp = arr[i];
            arr[i] = arr[left];
            arr[left] = temp;
        }
        this.warehouse = Arrays.asList(arr);
        warehouse.forEach(System.out::println);
    }

    void notebookSortWithCompareTo() {
        Notebook[] arr = new Notebook[warehouse.size()];
        for (int i = 0; i < warehouse.size(); i++) {
            arr[i] = warehouse.get(i);
        }

        for (int i = 0; i < arr.length; i++) {
            int left = i;
            for (int j = left + 1; j < arr.length; j++) {
                if (arr[left].compareTo(arr[j]) > 0 ) left = j;
            }
            Notebook temp = arr[i];
            arr[i] = arr[left];
            arr[left] = temp;
        }
        this.warehouse = Arrays.asList(arr);
        warehouse.forEach(System.out::println);
    }


    @Override
    public String toString() {
        return "Notebook{" +
                "coast=" + coast +
                ", ram=" + ram +
                ", brand=" + brand +
                '}';
    }
}
