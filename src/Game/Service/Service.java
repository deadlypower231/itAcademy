package Game.Service;

import Game.Animals.Animal;
import Game.Animals.Cat;
import Game.Animals.Dog;
import Game.Service.Interfaces.ICreateHero;
import Game.Service.Interfaces.IService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Service implements IService, ICreateHero {

    public Animal chooseRace(int i) {
        return (i == 1) ? new Cat() : new Dog();
    }

    @Override
    public int getIntReader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());
        reader.close();
        return i;
    }

    @Override
    public String getStringReader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        return s;
    }

    @Override
    public void createHero(Animal animal) throws IOException {
        animal.setName(getStringReader());
    }

    @Override
    public void createComputerHero() {

    }

    @Override
    public int getCriticalChance(Animal animal) {

        return 0;
    }

    @Override
    public int getEvasion(Animal animal) {
        return 0;
    }

    @Override
    public int getDefence(Animal animal) {
        return 0;
    }
}
