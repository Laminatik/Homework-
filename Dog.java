package home.work;

public class Dog extends Animal {
    public static final int MAX_RUN_DIS = 500;
    public static final int MAX_SWIM_DIS = 10;

    private static int count;

    public static int getCount() {
        return count;
    }

    public Dog(int maxRunDis, int maxSwimDis) {
        super(maxRunDis, maxSwimDis);
        count++;
    }

    public Dog() {
        this(MAX_RUN_DIS, MAX_SWIM_DIS);
    }

    @Override
    public boolean swim(int distance) {
        if (this.maxSwimDis >= distance) {
            System.out.printf("Собака проплыла дистанцию %d. Max = %d%n", distance, maxSwimDis);
            return true;
        } else {
            System.out.printf("Собака не смогла проплыть дистанцию %d. Max = %d%n", distance, maxSwimDis);
            return false;
        }
    }

    @Override
    public boolean run(int distance) {
        if (this.maxRunDis >= distance) {
            System.out.printf("Собака пробежала дистанцию %d. Max = %d%n", distance, maxRunDis);
            return true;
        } else {
            System.out.printf("Собака не смогла пробежать дистанцию %d. Max = %d%n", distance, maxRunDis);
            return false;
        }
    }
}
