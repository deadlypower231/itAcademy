package FightingAnimals.dao;

import FightingAnimals.api.dao.IAnimalDao;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class AnimalDao implements IAnimalDao {

    @Override
    public Map loadFromFile(String name) throws IOException {
        Map<String, String> stats = new HashMap<>();
        String path = "C:\\Users\\User\\Documents\\FA\\" + name + ".txt";
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] strings = line.split(" ");
            stats.put(strings[0], strings[1]);
        }
        return stats;

    }

    @Override
    public void saveToFile(StringBuilder stats, String name) throws FileNotFoundException {
        String path = "C:\\Users\\User\\Documents\\FA\\"  + name + ".txt";
        File file = new File(path);
        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
        out.print(stats);
        out.close();
    }

}
