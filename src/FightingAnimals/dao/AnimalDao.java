package FightingAnimals.dao;

import FightingAnimals.api.dao.IAnimalDao;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;


public class AnimalDao implements IAnimalDao {

    @Override
    public Map<String, String> loadFromFile(String name) throws IOException {
        return Files.lines(Paths.get("src\\FightingAnimals\\save\\" + name + ".txt"))
                .collect(Collectors.toMap(x -> StringUtils.substringBefore(x, " ")
                        , x -> StringUtils.substringAfter(x, " ")));
    }

    @Override
    public void saveToFile(StringBuilder stats, String name) throws FileNotFoundException {
        String path = "src\\FightingAnimals\\save\\" + name + ".txt";
        File file = new File(path);
        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
        out.print(stats);
        out.close();
    }

}
