package Game.Service.Interfaces;

import Game.Animals.Animal;

import java.io.IOException;

public interface IService {


    double getCriticalChance(Animal animal);

    double getEvasion(Animal animal);

//    double getDefence(double damage);

    double setDamageWithStrengthCat(Animal animal);

    double setDamageWithStrengthDog(Animal animal);

    double setDefenceWithAgilityCat(Animal animal);

    double setDefenceWithAgilityDog(Animal animal);

    double setHealthWithStrengthCat(Animal animal);

    double setHealthWithStrengthDog(Animal animal);

    double setManaWithIntelligenceCat(Animal animal);

    double setManaWithIntelligenceDog(Animal animal);

    int getIntReader() throws IOException;

    String getStringReader() throws IOException;

    String getRandomName(String string);

    void showAnimalStats(Animal animal);
}
