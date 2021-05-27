package Homework;

public class Script {

    private static final int REQUIRED_ARRAY_SIZE = 4;

    private static final String[][] INCORRECT_SIZE = new String[][]{
            {"5", "7", "3"},
            {"2", "3", "4", "43"},
            {"20", "15", "19", "16"},
            {"8", "12", "14"},
    };

    private static final String[][] INCORRECT_VALUE = new String[][]{
            {"1", "5", "6", "0"},
            {"4", "9", "2", "4"},
            {"312", "O", "8", "5"},
            {"15", "14", "32k", "176"},
    };

    private static final String[][] CORRECT = new String[][]{
            {"5", "10", "3", "4"},
            {"5", "6", "4", "43"},
            {"20", "15", "19", "22"},
            {"2", "15", "11", "32"},
    };

    public static void main(String[] args) {
        try {
            int result = sumArrayValues(INCORRECT_SIZE);
            System.out.println("----------------------------");
            System.out.println("Сума всех чисел масива равна: " + result);
            System.out.println("----------------------------");
        } catch (SizeException e) {
            System.err.println("Массив некоректного размера:(");
            e.printStackTrace();
        } catch (DataException e) {
            System.err.println("В масиве указаны некоректные данные:(");
            e.printStackTrace();
        }

        try {
            int result = sumArrayValues(INCORRECT_VALUE);
            System.out.println("----------------------------");
            System.out.println("Сума всех чисел масива равна: " + result);
            System.out.println("----------------------------");
        } catch (SizeException e) {
            System.err.println("Массив некоректного размера:(");
            e.printStackTrace();
        } catch (DataException e) {
            System.err.println("В масиве указаны некоректные данные:(");
            e.printStackTrace();
        }

        try {
            int result = sumArrayValues(CORRECT);
            System.out.println("----------------------------");
            System.out.println("Сума всех чисел масива равна: " + result);
            System.out.println("----------------------------");
        } catch (SizeException e) {
            System.err.println("Массив некоректного размера:(");
            e.printStackTrace();
        } catch (DataException e) {
            System.err.println("В масиве указаны некоректные данные:(");
            e.printStackTrace();
        }
    }

    private static void checkArraySize(String[][] data) {
        if (data.length != REQUIRED_ARRAY_SIZE) {
            throw new SizeException();
        }

        for (String[] row : data) {
            if (row.length != REQUIRED_ARRAY_SIZE) {
                throw new SizeException();
            }
        }
    }

    private static int sumArrayValues(String[][] data) throws SizeException, DataException {
        checkArraySize(data);

        int sumResult = 0;

        for (int rowIndex = 0; rowIndex < data.length; rowIndex++) {
            String[] row = data[rowIndex];
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                String value = row[colIndex];
                try {
                    sumResult += Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    throw new DataException(value, rowIndex, colIndex);
                }
            }
        }

        return sumResult;
    }
}
