package FightingAnimals;

import FightingAnimals.api.service.IAnimalService;
import FightingAnimals.entities.Animal;
import FightingAnimals.entities.Cat;
import FightingAnimals.services.AnimalService;

public class Main {

    public static void main(String[] args) {

        IAnimalService animalService = new AnimalService();
        Animal animal;
        Animal computer;
        animal = animalService.loadOrCreate();
        computer = animalService.createComputerAnimal(animal);
        System.out.println(animal+ "\n"+ computer);


    }

}
