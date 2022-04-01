package homeWork2;



public class HomeWork2 {
    public static void main(String[] args) {
        /**
         создаем обьект для генерации склада ноутбуков и их сортировки
         */
        Notebook test = new Notebook();
        /**
         создаем склад рандомных ноутбуков,но с характеристиками согласно условия задачи,кол-во ноутбуко можно указать
         в параметры метода createNotebookWarehouse()
         */
        test.createNotebookWarehouse(10000);
        /**
         проверка методов для сортировки ноутбуков на складе,сортировка реализована с помощью сортировки метода выбора
         с CompareTo и без него
         */
        test.notebookSortWithCompareTo();
        test.notebookSort();
    }
}







