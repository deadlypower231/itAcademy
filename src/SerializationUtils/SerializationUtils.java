package SerializationUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationUtils {

    public static void serialization(Object object1, String name) {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src\\FightingAnimals\\save\\" + name + ".info"))) {
            objectOutputStream.writeObject(object1);
            System.out.println("serialization");
        } catch (Exception e) {
            System.out.println("Serialization was failed!");
        }

    }

    public static Object deserialization(String name) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src\\FightingAnimals\\save\\" + name + ".info"))) {
            return objectInputStream.readObject();

        } catch (Exception e) {
            System.out.println("Deserialization was failed!");
            return null;
        }

    }
}
