package FightingAnimals.entities;

public class Cat extends Animal {
    @Override
    public String toString() {
        return  "name=" + name + "\n" +
                "level=" + level + "\n" +
                "experience=" + experience + "\n" +
                "health=" + health + "\n" +
                "mana=" + mana + "\n" +
                "damage=" + damage + "\n" +
                "defence=" + defence + "\n" +
                "strength=" + strength + "\n" +
                "agility=" + agility + "\n" +
                "intelligence=" + intelligence + "\n" +
                "criticalStrikeMultiplier=" + criticalStrikeMultiplier + "\n" +
                "criticalChance=" + criticalChance + "\n" +
                "type=" + type + "\n";
    }
}
