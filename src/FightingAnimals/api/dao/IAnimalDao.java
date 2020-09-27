package FightingAnimals.api.dao;

import FightingAnimals.entities.Animal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface IAnimalDao {

    Map loadFromFile(String name) throws IOException;

    void saveToFile(StringBuilder stats,String directory, String name) throws FileNotFoundException;


}
