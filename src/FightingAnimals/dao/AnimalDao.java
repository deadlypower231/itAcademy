package FightingAnimals.dao;

import FightingAnimals.api.dao.IAnimalDao;
import FightingAnimals.entities.Animal;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AnimalDao implements IAnimalDao {

    public File loadFromFile(String name) {

        String path = "C:\\Users\\User\\Documents\\FA\\" + name + ".txt";
        File file = new File(path);
        return file;

    }

    public void saveToFile(File file, String name){
        String path = "C:\\Users\\User\\Documents\\FA\\" + name + ".txt";
        
    }

}
