import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        List<String> cat= new LinkedList<>();

        Animal animal = new Cat();
        Animal animal1 = new Cat();
        animal.setName("sdf");
        animal1.setName("qwe");




        Set<String> set = new HashSet<>();

        set.add("sdf1");
        set.add("sdf2");
        set.add("sdf3");
        set.add("sdf4");
        set.add("sdf5");
        set.add("sdf6");
        set.add("sdf7");
        set.add("sdf8");
        set.stream().sorted().forEach(System.out::println);

        String text = "Shot what able cold new the see hold 1500. Friendly as an betrayed formerly he." +
                " Morning because as to society behaved moments. Put ladies design mrs sister was. " +
                "Play on hill felt john no gate. Am 1500 passed figure to marked in. Prosperous middletons is ye inhabiting as assistance me especially." +
                " For looking two cousins regular amongst. ";


    }
}
