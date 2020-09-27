package FightingAnimals.api.service;

import FightingAnimals.entities.Animal;

import java.io.IOException;

public interface IAnimalService {

    Animal loadFromFile(String name);
    void saveToFile(Animal animal);
    Animal createHero(Animal animal);
    String getName() throws IOException;
    int getIntReader();

}
