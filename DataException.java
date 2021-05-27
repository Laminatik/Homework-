package Homework;

public class DataException extends RuntimeException {

    public DataException(String cellValue, int rowIndex, int colIndex) {
        super(String.format("Неверное значение '%s' в ячейке массива[%d][%d], обязательное целое число",
                cellValue, rowIndex, colIndex));
    }

}
