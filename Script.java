package Homework;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Script {

    private static final int size = 10_000_000;
    private static final int h = size / 2;

    public static void main(String[] args) {
        float[] data1 = createArray(size);
        measureTime(() -> sequentialMethod(data1), "sequentialMethod");

        float[] data2 = createArray(size);
        measureTime(() -> parallelMethod(data2), "parallelMethod");

        System.out.println("Массивы равны: " + Arrays.equals(data1, data2));
    }

    private static void sequentialMethod(float[] data) {
        sequentialMethod(data, 0);
    }

    private static void sequentialMethod(float[] data, int offset) {
        for (int index = 0; index < data.length; index++) {
            float currentValue = data[index];
            data[index] = computeValue(index + offset, currentValue);
        }
    }


    private static void parallelMethod(float[] data) {
        float[] part1 = Arrays.copyOfRange(data, 0, h);
        float[] part2 = Arrays.copyOfRange(data, h, data.length);

        Thread thread1 = new Thread(() -> sequentialMethod(part1, 0));
        Thread thread2 = new Thread(() -> sequentialMethod(part2, h));

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println("Что-то прервал выполнение.");
            e.printStackTrace();
            return;
        }

        System.arraycopy(part1, 0, data, 0, h);
        System.arraycopy(part2, 0, data, h, h);
    }

    private static float[] createArray(int size) {
        float[] data = new float[size];
        Arrays.fill(data, 1.0f);
        return data;
    }

    private static float computeValue(int index, float currentValue) {
        return (float)(currentValue * Math.sin(0.2f + index / 5.0) * Math.cos(0.2f + index / 5.0) * Math.cos(0.4f + index / 2.0));
    }

    private static void measureTime(Runnable action, String actionName) {
        long start = System.nanoTime();
        action.run();
        long finish = System.nanoTime();
        long duration = finish - start;
        System.out.printf("Метод '%s' занял %d ms%n", actionName, TimeUnit.NANOSECONDS.toMillis(duration));
    }
}
