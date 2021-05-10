package home.work;

public class Cat {

    private final String name;
    private final int appetite;
    private boolean hunger;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean eat(Plate plate) {
        String validateMessage = checkEat(plate);
        if (validateMessage != null) {
            System.out.println(validateMessage);
            return false;
        }

        doEat(plate);
        hunger = true;
        return true;
    }

    private String checkEat(Plate plate) {
        if ( !plate.isFoodEnough(appetite) ) {
            return "Oops... food seems to run out";
        }
        if (hunger) {
            return "Cat is already satiety!";
        }

        return null;
    }

    private void doEat(Plate plate) {
        plate.decreaseFood(appetite);
    }

    public boolean isSatiety() {
        return hunger;
    }
}
