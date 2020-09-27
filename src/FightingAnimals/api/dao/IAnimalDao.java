package FightingAnimals.api.dao;

import FightingAnimals.entities.Animal;

import java.io.FileNotFoundException;

public interface IAnimalDao {

    void saveToFile(Animal animal) throws FileNotFoundException;

}
