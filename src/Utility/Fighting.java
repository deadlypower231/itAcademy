package Utility;

import Animals.Cat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.stream.IntStream;


public class Fighting {

    public static final String ROLLS_1_10 = " rolls (1-10): ";
    int attack;

    public void roll(Cat cat1, Cat cat2) throws IOException {
        double firstCatRoll = 1;
        double secondCatRoll = 1;
        while (firstCatRoll == secondCatRoll) {
            firstCatRoll = (int) (Math.random() * 10 + 1);
            secondCatRoll = (int) (Math.random() * 10 + 1);
        }
        StringBuilder stringBuilder = new StringBuilder("Who attacks first?\n");
        stringBuilder.append(cat1.getName()).append(ROLLS_1_10).append((int) firstCatRoll).append("\n")
                .append(cat2.getName()).append(ROLLS_1_10).append((int) secondCatRoll);
        System.out.println(stringBuilder);
        if (firstCatRoll > secondCatRoll) {
            fight(cat1, cat2);
        } else {
            fight(cat2, cat1);
        }
    }

    public void fight(Cat cat1, Cat cat2) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int r = (cat1.getName().startsWith("Computer")) ? 1 : 0;
        int round = 1;

        while (!(cat1.getHealth() <= 0) || !(cat2.getHealth() <= 0)) {


            System.out.println("\nRound " + round + "!\n");
            if (r % 2 != 0) {

                System.out.println(cat1.getName() + " attack!");//comp
                int damage1 = cat1.damage();
                int defence = cat2.defence();
                float damageDefence = (float) damage1 / 100 * defence;
                float damage = damage1 - damageDefence;
                cat2.setHealth(cat2.getHealth() - Math.round(damage));
                System.out.println(cat1.getName() + " deal " + (int)damage + " damage to " + cat2.getName());
                cat2.showCat();
                round++;
                r++;

            } else if (r % 2 == 0){
                System.out.println(cat2.getName() + " attack!");//user
                int damage1 = cat2.damage();
                int defence = cat1.defence();
                float damageDefence = (float) damage1 / 100 * defence;
                float damage = damage1 - damageDefence;
                cat1.setHealth(cat1.getHealth() - Math.round(damage));
                System.out.println(cat2.getName() + " deal " + (int)damage + " damage to " + cat1.getName());
                cat1.showCat();
                round++;
                r++;

            }
            if (cat1.getHealth() <= 0){
                System.out.println(cat2.getName() + " wins " + cat1.getName());
                break;
            }
            else if (cat2.getHealth() <= 0){
                System.out.println(cat1.getName() + " wins " + cat2.getName());
                break;
            }
            System.out.println("Press any button: ");
            String s = reader.readLine();

        }

    }
}

