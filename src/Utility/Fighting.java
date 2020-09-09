package Utility;

import Animals.Animal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fighting extends Animal implements Characteristics {

    public static final String ROLLS_1_10 = " rolls (1-10): ";

    public void roll(Animal animal1, Animal animal2) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double firstCatRoll = 1;
        double secondCatRoll = 1;

        while (firstCatRoll == secondCatRoll) {

            firstCatRoll = (int) (Math.random() * 10 + 1);
            secondCatRoll = (int) (Math.random() * 10 + 1);

        }

        StringBuilder stringBuilder = new StringBuilder("Who attacks first?\n");
        stringBuilder.append(animal1.getName()).append(ROLLS_1_10).append((int) firstCatRoll).append("\n")
                .append(animal2.getName()).append(ROLLS_1_10).append((int) secondCatRoll);
        System.out.println(stringBuilder);

        if (firstCatRoll > secondCatRoll) {

            System.out.println("\n" + animal1.getName() + " attack first!\n\n");
            System.out.println("Are you ready?\n");
            String s = reader.readLine();
            fight(animal1, animal2);

        } else {

            System.out.println("\n" + animal2.getName() + " attack first!\n\n");
            System.out.println("Are you ready?\n");
            String s = reader.readLine();
            fight(animal2, animal1);

        }
    }

    public void fight(Animal animal1, Animal animal2) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int r = 11;
        int round = 1;

        while (!(animal1.getHealth() <= 0) || !(animal2.getHealth() <= 0)) {

            System.out.println("\nRound " + round + "!\n");
            if (r  % 2 != 0) {

                int random = (int) (Math.random()*3);

                System.out.println(animal1.getName() + " attack!");

                float damage = ((animal1.damage() - 1) + random)- (float) animal1.damage()/ 100 * animal2.defence();


                if (evasion(animal2)){

                    System.out.println(animal2.getName() + " dodged the " + animal1.getName() + "`s attack!");

                }else {

                    if (critical(animal1)){

                        animal2.setHealth((animal2.getHealth() - (int)(damage * animal1.getCriticalStrike())));

                        System.out.println("Critical strike!\n" + animal1.getName() + " deal critical "
                                + (int)(damage * animal1.getCriticalStrike()) + " damage to " + animal2.getName());

                    }else {

                        animal2.setHealth(animal2.getHealth() - (int)(damage));
                        System.out.println(animal1.getName() + " deal " + (int)(damage) + " damage to " + animal2.getName());

                    }
                }

                round++;
                r++;

            } else if (r % 2 == 0){

                int random = (int) (Math.random()*3);
                System.out.println(animal2.getName() + " attack!");

                float damage = ((animal2.damage() - 1) + random) - (float) animal2.damage() / 100 * animal1.defence();

                if (evasion(animal1)) {

                    System.out.println(animal1.getName() + " dodged the " + animal2.getName() + "`s attack!");

                }else {

                    if (critical(animal2)) {

                        animal1.setHealth((animal1.getHealth() - (int)(damage * animal2.getCriticalStrike())));

                        System.out.println(animal2.getName() + " deal critical  "
                                + (int)(damage * animal2.getCriticalStrike()) + " damage to " + animal1.getName());

                    } else {

                        animal1.setHealth(animal1.getHealth() - (int)(damage));
                        System.out.println(animal2.getName() + " deal " + (int)(damage) + " damage to " + animal1.getName());

                    }
                }

                round++;
                r++;

            }
            if (animal1.getHealth() <= 0){

                System.out.println(animal2.getName() + " wins " + animal1.getName());
                break;

            }
            else if (animal2.getHealth() <= 0){

                System.out.println(animal1.getName() + " wins " + animal2.getName());
                break;

            }else {

                System.out.println(animal1.getName() + ": " + animal1.getHealth() + "hp.\n" + animal2.getName() + ": " + animal2.getHealth() + "hp.");

            }

            System.out.println("Press any button: ");
            String s = reader.readLine();

        }


    }

    public boolean evasion(Animal animal){

        int random = (int) (Math.random()*100 + 1);
        return (random <= animal.evasionChance()) ? true : false;

    }

    public boolean critical(Animal animal){

        int random = (int) (Math.random()*100 + 1);
        return (random <= animal.criticalChance()) ? true : false;
    }

    @Override
    public void createComputer() {

    }

    @Override
    public void createHero() throws IOException {

    }
}

