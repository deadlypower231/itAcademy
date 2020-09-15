package Game.Service.Interfaces;

import Game.Animals.Animal;

import java.io.IOException;
import java.util.Map;

public interface ILoadFromFile {

    Animal loadFromFile() throws IOException;

    Map read(String fileName);

    String exists(String directory, String fileName) throws IOException;

}
