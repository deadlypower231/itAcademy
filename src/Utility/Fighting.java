package Utility;

import Animals.Cat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Fighting {

    public static final String ROLLS_1_10 = " rolls (1-10): ";

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
            if ((r + 10) % 2 != 0) {

                System.out.println(cat1.getName() + " attack!");//comp

                float damage = cat1.damage() - (float) cat1.damage() / 100 * cat2.defence();
                if (evasion(cat2)){
                    System.out.println(cat2.getName() + " dodged the " + cat1.getName() + "`s attack!");
                }else {
                    if (critical(cat1)){
                        cat2.setHealth(cat2.getHealth() - Math.round(damage * 2));
                        System.out.println(cat1.getName() + " deal critical " + Math.round(damage * 2) + " damage to " + cat2.getName());
                    }else {
                        cat2.setHealth(cat2.getHealth() - Math.round(damage));
                        System.out.println(cat1.getName() + " deal " + Math.round(damage) + " damage to " + cat2.getName());
                    }
                }
                round++;
                r++;

            } else if ((r + 10) % 2 == 0){
                System.out.println(cat2.getName() + " attack!");//user

                float damage = cat2.damage() - (float) cat2.damage() / 100 * cat1.defence();
                if (evasion(cat1)) {
                    System.out.println(cat1.getName() + " dodged the " + cat2.getName() + "`s attack!");
                }else {
                    if (critical(cat2)) {
                        cat1.setHealth(cat1.getHealth() - Math.round(damage * 2));
                        System.out.println(cat2.getName() + " deal critical  " + Math.round(damage * 2) + " damage to " + cat1.getName());
                    } else {
                        cat1.setHealth(cat1.getHealth() - Math.round(damage));
                    System.out.println(cat2.getName() + " deal " + Math.round(damage) + " damage to " + cat1.getName());
                    }
                }
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
            }else {
                System.out.println(cat1.getName() + ": " + cat1.getHealth() + "hp.\n" + cat2.getName() + ": " + cat2.getHealth() + "hp.");
            }
            System.out.println("Press any button: ");
            String s = reader.readLine();

        }

        reader.close();

    }
    public boolean evasion(Cat cat){

        int random = (int) (Math.random()*100 + 1);
        return (random <= cat.evasionChance()) ? true : false;

    }

    public boolean critical(Cat cat){

        int random = (int) (Math.random()*100 + 1);
        return (random <= cat.criticalChance()) ? true : false;
    }
}

