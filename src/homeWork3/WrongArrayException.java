package homeWork3;

public class WrongArrayException extends RuntimeException{
    public WrongArrayException() {
        super("введите массив с одним пропущенным элементом начиная с 1");
    }
}
