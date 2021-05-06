package home.work;

public abstract class Animal {

    private static int count;

    public static int getCount() {
        return count;
    }

    protected int maxRunDis;
    protected int maxSwimDis;

    public Animal(int maxRunDis, int maxSwimDis) {
        this.maxRunDis = maxRunDis;
        this.maxSwimDis = maxSwimDis;
        count++;
    }

    public abstract  boolean run(int distance);
    public abstract  boolean swim(int distance);

    public void printinfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() + "{" +
                "maxRunDis=" + maxRunDis +
                ", maxSwimDistance=" + maxSwimDis +
                "}";
    }

}
