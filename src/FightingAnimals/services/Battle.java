package FightingAnimals.services;

import FightingAnimals.api.service.IAnimalService;
import FightingAnimals.api.service.IBattle;
import FightingAnimals.api.utils.IGetStats;
import FightingAnimals.entities.Animal;
import FightingAnimals.utils.GetStats;

public class Battle implements IBattle {

    IAnimalService animalService = new AnimalService();

    @Override
    public void battle(Animal animal1, Animal animal2) {
        int counterRound = 1;
        double startHpAnimal1 = animal1.getHealth();
        double startHpAnimal2 = animal2.getHealth();
        while (true) {
            if (counterRound % 2 != 0) {
                System.out.println("Round " + counterRound + "!\n");
                int hp = hit(animal1, animal2);
                counterRound++;
                if (hp <= 0) {
                    System.out.println("Congratulation " + animal1.getName() + " won!");
                    animal1.setExperience(animal1.getExperience() + (50 * animal1.getLevel() / 2));
                    animal2.setExperience(animal2.getExperience() + (25 * animal2.getLevel() / 2));
                    animal1.setHealth(startHpAnimal1);
                    animal2.setHealth(startHpAnimal2);
                    break;
                } else {
                    System.out.println(animal1.getName() + " health: " + (int) animal1.getHealth() + "\n" +
                            animal2.getName() + " health: " + (int) animal2.getHealth());
                }
            } else {
                System.out.println("Round " + counterRound + "!\n");
                int hp = hit(animal2, animal1);
                counterRound++;
                if (hp <= 0) {
                    System.out.println("Congratulation " + animal2.getName() + " won!");
                    animal2.setExperience(animal2.getExperience() + (50 * animal2.getLevel() / 2));
                    animal1.setExperience(animal1.getExperience() + (25 * animal1.getLevel() / 2));
                    animal1.setHealth(startHpAnimal1);
                    animal2.setHealth(startHpAnimal2);
                    break;
                } else {
                    System.out.println(animal1.getName() + " health: " + (int) animal1.getHealth() + "\n" +
                            animal2.getName() + " health: " + (int) animal2.getHealth());
                }
            }
            System.out.println("Press enter!");
            animalService.getName();

        }
    }

    @Override
    public void flipACoin(Animal user, Animal computer) {
        int userThrows = 0;
        int computerThrows = 0;
        while (userThrows == computerThrows) {
            userThrows = (int) (Math.random() * 100 + 1);
            computerThrows = (int) (Math.random() * 100 + 1);
        }
        if (userThrows > computerThrows) {
            System.out.println(user.getName() + " rolls (1-100): " + userThrows + "\n" + computer.getName() + " rolls (1-100): " +
                    computerThrows + "\n" + user.getName() + " attacks first!\n");
            battle(user, computer);
        } else {

            System.out.println(user.getName() + " rolls (1-100): " + userThrows + "\n" + computer.getName() + " rolls (1-100): " +
                    computerThrows + "\n" + computer.getName() + " attacks first!\n");
            battle(computer, user);
        }
    }

    @Override
    public double randomDamage(Animal animal) {
        double random = Math.random() * 3;
        return (animal.getDamage() - 1) + random;
    }

    @Override
    public int hit(Animal animal1, Animal animal2) {

        IGetStats getStats = new GetStats();

        if (getStats.getEvasion(animal2)) {
            System.out.println(animal2.getName() + " dodges!");
        } else if (getStats.getCriticalChance(animal1)) {
            double criticalDamage = randomDamage(animal1) * animal1.getCriticalStrikeMultiplier();
            double criticalDamageWithDefence = criticalDamage - criticalDamage / 100 * getStats.getDefencePercent(animal2);
            System.out.println(animal1.getName() + " deal " + (int) criticalDamageWithDefence + " critical damage!");
            animal2.setHealth(animal2.getHealth() - (int) criticalDamageWithDefence);
        } else {
            double randomDamage = randomDamage(animal1);
            double damage = randomDamage - randomDamage / 100 * getStats.getDefencePercent(animal2);
            System.out.println(animal1.getName() + " deal " + (int) damage + " damage!");
            animal2.setHealth(animal2.getHealth() - (int) damage);
        }
        return (int) animal2.getHealth();
    }

}
