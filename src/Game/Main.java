package Game;

import Game.Animals.Animal;
import Game.Service.Service;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        /*Создаем объекты.*/

        Animal user = null;
        Animal computer = null;
        Service service = new Service();

        /*Выбираем вид героя, которым будем играть.
         * и создаем героя.*/

        user = service.chooseRace();
        service.createHero(user);

        /*Создаем компьютера от выбранного вида пользователя*/

        computer = service.createComputerHero(user);

        /*Выводим на экран характеристики пользователя и компьютера*/

        service.showAnimalStats(user);
        service.showAnimalStats(computer);

        
        service.flipACoin(user, computer);


    }

}
