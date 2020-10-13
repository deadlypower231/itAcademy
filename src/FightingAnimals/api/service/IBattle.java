package FightingAnimals.api.service;

import FightingAnimals.entities.Animal;

public interface IBattle {

    Animal battle(Animal animal1, Animal animal2);

}