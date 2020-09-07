package Animals;

import Utility.Characteristics;

public class Cat implements Characteristics {

        private String name;
        private int health = 100;
        private int str = 3;
        private int dex = 3;
        private int con = 4;
        private int def = 1;
        private int damage = 10;

    @Override
    public void health() {
        this.health = this.health + (int)(this.con * 1.15);
    }

    @Override
    public int damage(){
        return this.damage+(int)(this.str*0.35);
    }

    @Override
    public int defence(){
        return this.def + (int)(this.dex * 2.35);
    }

    @Override
    public int evasion() {
        return (int) (this.dex * 0.75);
    }

    public Cat(){

        }

        public Cat(String name){
            this.name = name;
        }

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

        public void showCat(){
            System.out.println(this.name + "`s characteristics: "+ "\nHealth: " + this.health +
                    "\nStr: " + this.str + "\nDex: " + this.dex + "\nCon: " + this.con);
        }
    }
