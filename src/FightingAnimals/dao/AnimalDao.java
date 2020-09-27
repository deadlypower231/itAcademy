package FightingAnimals.dao;

import FightingAnimals.api.dao.IAnimalDao;
import FightingAnimals.entities.Animal;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class AnimalDao implements IAnimalDao {

    private Map<String, Animal> animals = new HashMap<>();

    public void saveToFile(Animal animal) throws FileNotFoundException {
        StringBuilder stats = new StringBuilder();
        Map<String, Animal> map = new HashMap<>();
        map.put(animal.getName(), animal);
        for (Map.Entry<String, Animal> entry : map.entrySet()) {
            stats.append("id0: ").append(entry.getValue().getType());
            stats.append("\nid1: ").append(entry.getValue().getName());
            stats.append("\nid2: ").append(entry.getValue().getLevel());
            stats.append("\nid3: ").append(entry.getValue().getExperience());
            stats.append("\nid4: ").append(entry.getValue().getHealth());
            stats.append("\nid5: ").append(entry.getValue().getMana());
            stats.append("\nid6: ").append(entry.getValue().getDamage());
            stats.append("\nid7: ").append(entry.getValue().getDefence());
            stats.append("\nid8: ").append(entry.getValue().getStrength());
            stats.append("\nid9: ").append(entry.getValue().getAgility());
            stats.append("\nid10: ").append(entry.getValue().getIntelligence());
            stats.append("\nid11: ").append(entry.getValue().getCriticalChance());
            stats.append("\nid12: ").append(entry.getValue().getCriticalStrikeMultiplier());
            stats.append("\nid13: ").append(entry.getValue().getEvasion());
        }
        if (animal.getType().equals("cat")) {
            String fileName = "C:\\Users\\User\\Documents\\FA\\Cat\\" + animal.getName().toLowerCase() + ".txt";
            write(fileName, stats);
        } else if (animal.getType().equals("dog")) {
            String fileName = "C:\\Users\\User\\Documents\\FA\\Dog\\" + animal.getName().toLowerCase() + ".txt";
            write(fileName, stats);
        }
    }

}
