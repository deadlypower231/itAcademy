package FightingAnimals.api.service;

import FightingAnimals.entities.Animal;

public interface IBattle {

    void battle(Animal animal1, Animal animal2);

    void flipACoin(Animal user, Animal computer);

    int hit(Animal animal1, Animal animal2);

    double randomDamage(Animal animal);

}
