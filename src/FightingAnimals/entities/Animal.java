package FightingAnimals.entities;


import java.io.Serializable;

public abstract class Animal implements Serializable {

    public static final String SPACE = " ";
    protected String name;

    protected double level;

    protected double experience;

    protected double health;

    protected double mana;

    protected double damage;

    protected double defence;

    protected double strength;

    protected double agility;

    protected double intelligence;

    protected double criticalStrikeMultiplier;

    protected double criticalChance;

    protected String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getDefence() {
        return defence;
    }

    public void setDefence(double defence) {
        this.defence = defence;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public double getCriticalStrikeMultiplier() {
        return criticalStrikeMultiplier;
    }

    public void setCriticalStrikeMultiplier(double criticalStrikeMultiplier) {
        this.criticalStrikeMultiplier = criticalStrikeMultiplier;
    }

    public double getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(double criticalChance) {
        this.criticalChance = criticalChance;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  "Name=" + name + SPACE +
                "Level=" + (int)level + SPACE +
                "Experience=" + (int)experience + SPACE +
                "Health=" + (int)health + SPACE +
                "Mana=" + (int)mana + SPACE +
                "Damage=" + (int)damage + SPACE +
                "Defence=" + (int)defence + SPACE +
                "Strength=" + (int)strength + SPACE +
                "Agility=" + (int)agility + SPACE +
                "Intelligence=" + (int)intelligence + SPACE +
                "CriticalStrikeMultiplier=" + (int)criticalStrikeMultiplier + SPACE +
                "CriticalChance=" + (int)criticalChance + SPACE +
                "Type=" + type + SPACE;
    }
}