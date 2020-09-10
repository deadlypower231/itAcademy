package Game.Service.Interfaces;

import Game.Animals.Animal;

import java.io.IOException;

public interface IService {

    int getCriticalChance(Animal animal);
    int getEvasion(Animal animal);
    int getDefence(Animal animal);
    int getIntReader() throws IOException;
    String getStringReader() throws IOException;
}
