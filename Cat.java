package home.work;

public class Cat extends Animal {
    public static final int MAX_RUN_DIS = 200;
    public static final int MAX_SWIM_DIS = 0;

    private static int count;

    public static int getCount() {
        return count;
    }

    public Cat(int maxRunDis, int maxSwimDis) {
        super(maxRunDis, maxSwimDis);
        count++;
    }

    public Cat() {
        this(MAX_RUN_DIS, MAX_SWIM_DIS);
    }

    @Override
    public boolean swim(int distance) {
        System.out.println("Кот не умеет плавать");
        return false;
    }

    @Override
    public boolean run(int distance) {
        if (this.maxRunDis >= distance) {
            System.out.printf("Кот пробежал дистанцию %d. Max = %d%n", distance, maxRunDis);
            return true;
        } else {
            System.out.printf("Коту не удалось пробежать дистанцию %d. Max = %d%n", distance, maxRunDis);
            return false;
        }
    }
}
