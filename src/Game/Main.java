package Game;

import Game.Animals.Animal;
import Game.Service.Service;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Animal user = null;
        Animal computer = null;

        Service service = new Service();
        service.chooseRace(service.getIntReader());
        service.createHero(user);

        System.out.println(user.getName());

    }

}
