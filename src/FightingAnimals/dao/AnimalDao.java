package FightingAnimals.dao;

import FightingAnimals.api.dao.IAnimalDao;
import FightingAnimals.entities.Animal;

import java.util.HashMap;
import java.util.Map;

public class AnimalDao implements IAnimalDao {

    private Map<String, Animal> animals = new HashMap<>();

}
