package home.work;

import java.util.Scanner;

public class Script {

    public static void main(String[] args) {

        Cat[] cats = {
                new Cat("Cat1", (int) (Math.random()*13)),
                new Cat("Cat2", (int) (Math.random()*9)),
                new Cat("Cat3", (int) (Math.random()*5)),
        };

        Plate plate = new Plate((int) (Math.random()*20));

        printInfo(cats, plate);
        haveLunch(cats, plate);

        printInfo(cats, plate);

        addFood(plate);

        System.out.println("Added food-> ");
        plate.info();
        System.out.println();

        haveLunch(cats, plate);
        printInfo(cats, plate);


    }

    private static void haveLunch(Cat[] cats, Plate plate) {
        for (Cat cat : cats) {
            boolean result = cat.eat(plate);
            System.out.printf("Did %s need eat? The cat answer: %s%n", cat.getName(), result);
        }
        System.out.println();
    }

    private static void printInfo(Cat... cats) {
        for (Cat cat : cats) {
            System.out.printf("Is %s hungry?(first appetite: %d) The cat answer: %s%n",
                    cat.getName(),
                    cat.getAppetite(),
                    !cat.isSatiety());
        }
    }

    private static void printInfo(Cat[] cats, Plate plate) {
        System.out.println("----Information----");
        plate.info();
        printInfo(cats);
        System.out.println("--------");
        System.out.println();
    }

    private static void addFood(Plate plate) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("New food count: ");
        int foodCount = scanner.nextInt();
        plate.addFood(foodCount);
    }
}
