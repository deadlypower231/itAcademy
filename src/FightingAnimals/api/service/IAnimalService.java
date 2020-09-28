package FightingAnimals.api.service;

import FightingAnimals.entities.Animal;

import java.io.IOException;

public interface IAnimalService {

    Animal loadOrCreate();

    Animal chooseRace();

    Animal createComputerAnimal(Animal animal);

    Animal loadFromFile(String name);

    void saveToFile(Animal animal);

    Animal createHero(Animal animal);

    String getName();

    int getIntReader();
    String exists( String fileName) throws IOException;


}
