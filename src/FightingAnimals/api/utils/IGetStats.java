package FightingAnimals.api.utils;

import FightingAnimals.entities.Animal;

public interface IGetStats {

    boolean getEvasion(Animal animal);

    boolean getCriticalChance(Animal animal);

    double getDefencePercent(Animal animal);

}
