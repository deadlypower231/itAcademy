package FightingAnimals.api.dao;

import FightingAnimals.entities.Animal;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IAnimalDao {

    void saveToFile(Animal animal) throws FileNotFoundException;

    void write(String fileName, StringBuilder stats) throws FileNotFoundException;

    Animal loadFromFile() throws IOException;

}
