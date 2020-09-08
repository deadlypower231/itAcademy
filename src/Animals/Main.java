package Animals;


import Utility.Fighting;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static final String X = "//////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n" +
            "\t\tWelcome to Animal Fighting!\n" +
            "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\//////////////////////\n";

    public static void main(String[] args) throws IOException {
        Cat heroCat = new Cat();
        Cat computer = new Cat("Computer");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(X);
        System.out.print("Enter the name: ");
        heroCat.setName(reader.readLine());
        heroCat.health();
        heroCat.showCat();
        computer.health();

        Fighting fight = new Fighting();
        fight.roll(heroCat,computer);

        reader.close();

    }
}
