package Animals;


import Utility.Fighting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static final String X = "//////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n" +
            "\t\tWelcome to Animal Fighting!\n" +
            "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\//////////////////////\n";

    public static void main(String[] args) throws IOException {

        Animal user = null;
        Animal computer1 = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(X);
        System.out.println("Choice Hero:\n1-Cat.\n2-Dog.");
        System.out.print("Your choice: ");

        int choiceHero = Integer.parseInt(reader.readLine());
        if (choiceHero == 1){
            user = new Cat();
            user.createHero();
            computer1 = new Cat();
            computer1.createComputer();
            user.showStats();
            computer1.showStats();
        }else if (choiceHero == 2){
            user = new Dog();
            user.createHero();
            computer1 = new Dog();
            computer1.createComputer();
            user.showStats();
            computer1.showStats();
        }


        Fighting fight = new Fighting();
        fight.roll(user,computer1);

        reader.close();

    }
}
