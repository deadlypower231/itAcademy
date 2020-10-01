package FightingAnimals.utils;

import FightingAnimals.entities.Animal;
import FightingAnimals.entities.Cat;
import FightingAnimals.entities.Dog;

public class SetStatsNextLevel{

    public void setStatsNextLevel(Animal animal) {
        int level = (int) animal.getLevel();
        if (animal instanceof Cat) {
            animal.setStrength(animal.getStrength() + ((level * 1.2) - 1.2));
            animal.setAgility(animal.getAgility() + ((level * 2) - 2));
            animal.setIntelligence(animal.getIntelligence() + ((level * 0.9) - 0.9));
            animal.setHealth(animal.getHealth() + (10 + level * 2) + (animal.getStrength() * 1.3));
            animal.setMana(animal.getMana() + (5 + level));
            animal.setDamage(animal.getDamage()  + (animal.getAgility() * 1.2));


        } else if (animal instanceof Dog) {

            animal.setStrength(animal.getStrength() + ((level * 2.2) - 2.2));
            animal.setAgility(animal.getAgility() + ((level * 1.1) - 1.1));
            animal.setIntelligence(animal.getIntelligence() + ((level * 0.9) - 0.9));
            animal.setHealth(animal.getHealth() + (12 + level * 2) + (animal.getStrength() * 1.4));
            animal.setMana(animal.getMana() + (4 + level));
            animal.setDamage(animal.getDamage()  + (animal.getStrength() * 1.3));
        }
    }

}
