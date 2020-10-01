package FightingAnimals.api.service;

import FightingAnimals.entities.Animal;

import java.io.IOException;

public interface IAnimalService {

    Animal loadOrCreate();

    Animal chooseRace();

    Animal createComputerAnimal(Animal animal);

    Animal loadFromFile(String name);

    void saveToFile(Animal animal);

    void createHero(Animal animal);

    String getName();
    int getIntReader() throws IOException;

    String exists(String fileName);

    void flipACoin(Animal user, Animal computer);

    void levelUp(Animal animal);

    StringBuilder start();

    boolean exit();


}
