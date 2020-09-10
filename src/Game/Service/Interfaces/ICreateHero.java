package Game.Service.Interfaces;

import Game.Animals.Animal;

import java.io.IOException;

public interface ICreateHero {

    void createHero(Animal animal) throws IOException;
    void createComputerHero();
}
