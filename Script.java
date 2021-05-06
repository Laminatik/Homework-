package home.work;

import java.util.Random;

public class Script {
    public static void main(String[] args) {
        Animal[] participants = prepareParticipants();
        playGame(participants);
    }

    private static Animal[] prepareParticipants() {
        return new Animal[] {
                new Cat(),
                new Dog(),
                new Cat(350, 5),
                new Dog(350, 300),
        };
    }

    private static void playGame(Animal[] participants) {
        Random random = new Random();

        for (Animal participant : participants) {
            participant.printinfo();
            System.out.println(participant.run(random.nextInt(400)));
            System.out.println(participant.swim(random.nextInt(100)));
            System.out.println();
        }

        System.out.println("Всего животных: " + Animal.getCount());
        System.out.println("Всего собак: " + Dog.getCount());
        System.out.println("Всего котов: " + Cat.getCount());
    }

}
