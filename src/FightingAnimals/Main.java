package FightingAnimals;

import FightingAnimals.api.service.IAnimalService;
import FightingAnimals.api.service.IBattle;
import FightingAnimals.entities.Animal;
import FightingAnimals.services.AnimalService;
import FightingAnimals.services.Battle;

public class Main {

    public static void main(String[] args) {

        IAnimalService animalService = new AnimalService();
        IBattle battle = new Battle();
        Animal animal;
        Animal computer;
        System.out.println(animalService.start());
        while (true) {
            animal = animalService.loadOrCreate();
            computer = animalService.createComputerAnimal(animal);
            System.out.println(animal + "\n" + computer);
            animal = battle.battle(animal, computer);
            AnimalService.levelUp(animal);
            AnimalService.saveToFile(animal);
            if (animalService.exit()) {
                return;
            }
        }


    }

}