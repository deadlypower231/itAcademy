package FightingAnimals.dao;

import FightingAnimals.api.dao.IAnimalDao;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import java.util.stream.Collectors;


public class AnimalDao implements IAnimalDao {

    @Override
    public Map<String, String> loadFromFile(String name) throws IOException {
        return Files.lines(Paths.get("C:\\Users\\User\\Documents\\FA\\" + name + ".txt"))
                .collect(Collectors.toMap(x -> StringUtils.substringBefore(x," ")
                        ,x -> StringUtils.substringAfter(x," ")));
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
