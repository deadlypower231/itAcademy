import java.util.*;

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
        




    }
}
