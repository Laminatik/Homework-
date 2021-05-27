package Homework;

public class SizeException extends IllegalArgumentException {

    public SizeException() {
        super("Неверный размер массива, требуется размер: 4x4");
    }
}
