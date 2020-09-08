package Animals;

import Utility.Characteristics;
import Utility.CreateHero;

public abstract class Animal implements Characteristics, CreateHero {


    protected String name;
    protected double criticalStrike = 2;
    protected int str = 3;
    protected int dex = 3;
    protected int con = 3;
    protected int def = 3;
    protected int damage = 10;
    protected int health = 100;



    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public double getCriticalStrike() {
        return criticalStrike;
    }

    public void setCriticalStrike(double criticalStrike) {
        this.criticalStrike = criticalStrike;
    }

    public void showStats(){
        System.out.println("\n" + this.name + "`s characteristics: "+ "\nHealth: " + this.health +
                "\nStr: " + this.str + "\nDex: " + this.dex + "\nCon: " + this.con + "\nDef: " + this.defence() + "\nDamage: " + this.damage() + "\nCritStrike: "+ this.criticalStrike + "\n");
    }

    @Override
    public int damage() {
        return 0;
    }

    @Override
    public int defence() {
        return 0;
    }

    @Override
    public int evasionChance() {
        return 0;
    }

    @Override
    public int criticalChance() {
        return 0;
    }

    @Override
    public int health() {
        return 0;
    }
}
