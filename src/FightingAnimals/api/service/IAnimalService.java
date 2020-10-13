package FightingAnimals.api.service;

import FightingAnimals.entities.Animal;

public interface IAnimalService {

    Animal loadOrCreate();

    Animal chooseRace();

    Animal createComputerAnimal(Animal animal);

    Animal loadFromFile(String name);

    StringBuilder start();

    boolean exit();


}