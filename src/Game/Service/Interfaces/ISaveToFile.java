package Game.Service.Interfaces;

import Game.Animals.Animal;

import java.io.FileNotFoundException;

public interface ISaveToFile {

    void saveToFile(Animal animal) throws FileNotFoundException;

    void write(String fileName, StringBuilder stats) throws FileNotFoundException;
}
