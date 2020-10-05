package FightingAnimals;

import FightingAnimals.api.service.IAnimalService;
import FightingAnimals.entities.Animal;
import FightingAnimals.services.AnimalService;

public class Main {

    public static void main(String[] args) {

        IAnimalService animalService = new AnimalService();
        Animal animal;
        Animal computer;
        System.out.println(animalService.start());
        while (true) {
            animal = animalService.loadOrCreate();
            computer = animalService.createComputerAnimal(animal);
            System.out.println(animal + "\n" + computer);
            animalService.flipACoin(animal, computer);
            animalService.levelUp(animal);
            animalService.saveToFile(animal);
            if (animalService.exit()) {
                return;
            }
        }


    }

}