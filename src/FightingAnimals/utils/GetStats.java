package FightingAnimals.utils;

import FightingAnimals.api.utils.IGetStats;
import FightingAnimals.entities.Animal;

public class GetStats implements IGetStats {

    @Override
    public boolean getEvasion(Animal animal) {
        int random = (int) (Math.random() * 100 + 1);
        return random <= (5 + (animal.getAgility() * 0.05));

    }

    @Override
    public boolean getCriticalChance(Animal animal) {
        return (int) (Math.random() * 100 + 1) <= (animal.getCriticalChance() + (animal.getAgility() * 0.05));
    }

    @Override
    public double getDefencePercent(Animal animal) {
        return animal.getDefence() * 0.9;
    }

}
