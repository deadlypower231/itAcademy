package FightingAnimals.dao;

import FightingAnimals.api.dao.IAnimalDao;
import FightingAnimals.entities.Animal;

import java.io.*;
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

    @Override
    public Animal loadFromFile() throws IOException {
        Animal animal = chooseRace();
        String directory;
        System.out.println("Enter your name: ");
        String fileName = null;
        if (animal instanceof Cat) {
            directory = "C:\\Users\\User\\Documents\\FA\\Cat\\";
            fileName = exists(directory, getStringReader());
        } else if (animal instanceof Dog) {
            directory = "C:\\Users\\User\\Documents\\FA\\Dog\\";
            fileName = exists(directory, getStringReader());
        }
        Map<String, String> map = read(fileName);
        for (Map.Entry<String, String> s :
                map.entrySet()) {
            switch (s.getKey()) {
                case "id0:":
                    animal.setType(s.getValue());
                    break;
                case "id1:":
                    animal.setName(s.getValue());
                    break;
                case "id2:":
                    animal.setLevel(Double.parseDouble(s.getValue()));
                    break;
                case "id3:":
                    animal.setExperience(Double.parseDouble(s.getValue()));
                    break;
                case "id4:":
                    animal.setHealth(Double.parseDouble(s.getValue()));
                    break;
                case "id5:":
                    animal.setMana(Double.parseDouble(s.getValue()));
                    break;
                case "id6:":
                    animal.setDamage(Double.parseDouble(s.getValue()));
                    break;
                case "id7:":
                    animal.setDefence(Double.parseDouble(s.getValue()));
                    break;
                case "id8:":
                    animal.setStrength(Double.parseDouble(s.getValue()));
                    break;
                case "id9:":
                    animal.setAgility(Double.parseDouble(s.getValue()));
                    break;
                case "id10:":
                    animal.setIntelligence(Double.parseDouble(s.getValue()));
                    break;
                case "id11:":
                    animal.setCriticalChance(Double.parseDouble(s.getValue()));
                    break;
                case "id12:":
                    animal.setCriticalStrikeMultiplier(Double.parseDouble(s.getValue()));
                    break;
                case "id13:":
                    animal.setEvasion(Double.parseDouble(s.getValue()));
                    break;
            }
        }

        return animal;

    }

    @Override
    public Map read(String fileName) throws Exception {
        File file = new File(fileName);
        Map<String, String> map = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
        String s;
        while ((s = reader.readLine()) != null) {
            String[] string = s.split(" ");
            map.put(string[0], string[1]);

        }

        return map;
    }

    @Override
    public void write(String fileName, StringBuilder stats) throws FileNotFoundException {
        File file = new File(fileName);
        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
        out.print(stats);
        out.close();
    }

}
