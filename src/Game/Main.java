package Game;

import Game.Animals.Animal;
import Game.Service.Service;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Animal user;
        Animal computer;
        Service service = new Service();
        System.out.println(service.start());
        while (true) {
            user = service.loadOrCreate();
            computer = service.createComputerHero(user);
            service.showAnimalStats(user);
            service.showAnimalStats(computer);
            service.flipACoin(user, computer);
            service.saveToFile(user);
            if (service.exit()) {
                return;
            }
        }


    }

}
