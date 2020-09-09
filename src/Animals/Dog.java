package Animals;

import Utility.Characteristics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dog extends Animal implements Characteristics{

    @Override
    public int damage() {
        return this.damage+(int)(this.str * 0.75);
    }

    @Override
    public int defence() {
        return this.def + (int)(this.dex * 2.75);
    }

    @Override
    public int evasionChance() {
        return (int) (this.dex * 0.75 + 4);
    }

    @Override
    public int criticalChance() {
        return (int) (this.dex * 1.25 + 4);
    }

    @Override
    public int health() {
        return (int) (this.health + (this.con * 4.15));
    }

    @Override
    public void createComputer() throws IOException {

        int count = 3;
        int str = 0;
        int dex = 0;
        int con = 0;

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter the name: ");
            String name = reader.readLine();
            System.out.println("You have 3 points, distribute them between STR, DEX, CON");

            while (count != 0) {
                while (true) {
                    System.out.print(count + " points left.\nSTR: ");
                    int strRead = Integer.parseInt(reader.readLine());
                    if (strRead == 3) {
                        str = strRead;
                        count -= strRead;
                        break;
                    } else if (strRead == 2) {
                        str = strRead;
                        count -= strRead;
                        break;
                    } else if (strRead == 1) {
                        str = strRead;
                        count -= strRead;
                        break;
                    } else if (strRead == 0) {
                        str = strRead;
                        count -= strRead;
                        break;
                    } else {
                        System.out.println("Enter from 0 to " + count + "!");
                    }
                }

                while (true) {
                    System.out.print(count + " points left.\nDEX: ");
                    int dexRead = Integer.parseInt(reader.readLine());
                    if (dexRead == 3 && dexRead <= count) {
                        dex = dexRead;
                        count -= dexRead;
                        break;
                    } else if (dexRead == 2 && dexRead <= count) {
                        dex = dexRead;
                        count -= dexRead;
                        break;
                    } else if (dexRead == 1 && dexRead <= count) {
                        dex = dexRead;
                        count -= dexRead;
                        break;
                    } else if (dexRead == 0 && dexRead <= count) {
                        dex = dexRead;
                        count -= dexRead;
                        break;
                    } else {
                        System.out.println("Enter from 0 to " + count + "!");
                    }
                }

                while (true) {
                    System.out.print(count + " points left.\nDEX: ");
                    int conRead = Integer.parseInt(reader.readLine());
                    if (conRead == 3 && conRead <= count) {
                        con = conRead;
                        count -= conRead;
                        break;
                    } else if (conRead == 2 && conRead <= count) {
                        con = conRead;
                        count -= conRead;
                        break;
                    } else if (conRead == 1 && conRead <= count) {
                        con = conRead;
                        count -= conRead;
                        break;
                    } else if (conRead == 0 && conRead <= count) {
                        con = conRead;
                        count -= conRead;
                        break;
                    } else {
                        System.out.println("Enter from 0 to " + count + "!");
                    }
                }
            }


        this.name = name;
        this.str = 6 +str;
        this.dex = 2 + dex;
        this.con = 5 + con;
        this.def = 4;
        this.damage = 15;
        this.criticalStrike = 2.25;
        this.health = 150;
        this.health = health();


    }

    @Override
    public void createHero() {

        this.name = "Computer1";
        this.str = 6 + 1;
        this.dex = 2 + 1;
        this.con = 5 + 1;
        this.def = 4;
        this.damage = 15;
        this.criticalStrike = 2.25;
        this.health = 150;
        this.health = health();


    }


}
