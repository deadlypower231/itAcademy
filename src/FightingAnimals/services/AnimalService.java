package FightingAnimals.services;

import FightingAnimals.api.dao.IAnimalDao;
import FightingAnimals.api.service.IAnimalService;
import FightingAnimals.api.service.IBattle;
import FightingAnimals.api.utils.ISetStatsNextLevel;
import FightingAnimals.dao.AnimalDao;
import FightingAnimals.entities.Animal;
import FightingAnimals.entities.Cat;
import FightingAnimals.entities.Dog;
import FightingAnimals.utils.SetStatsNextLevel;

import java.io.*;
import java.util.Map;

public class AnimalService implements IAnimalService {

    public static final String TITLE = "~=~=~=~=~=~=~=~=~=~=~=~=~=~=~\n";
    public static final String ENTER_YOUR_NAME = "Enter your name: ";

    IAnimalDao animalDao = new AnimalDao();

    @Override
    public Animal loadOrCreate() {
        Animal animal;
        while (true) {
            System.out.println("\nLoad a hero or create a new hero?\n1-Load.\n2-Create.");
            int i = getIntReader();
            if (i > 0 && i < 3) {
                if (i == 1) {
                    System.out.println(ENTER_YOUR_NAME);
                    try {
                        return loadFromFile(exists(getName()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    animal = chooseRace();
                    System.out.println(ENTER_YOUR_NAME);
                    animal.setName(getName());
                    createHero(animal);
                    return animal;
                }
            }
        }
    }

    @Override
    public Animal chooseRace() {
        while (true) {
            System.out.println("Choose:\n1-Cat.\n2-Dog.");
            int i = getIntReader();
            if (i > 0 && i < 3) {
                return (i == 1) ? new Cat() : new Dog();
            }
        }
    }

    @Override
    public Animal createComputerAnimal(Animal animal) {
        ISetStatsNextLevel setStatsNextLevel = new SetStatsNextLevel();
        Animal computer = null;
        if (animal instanceof Cat) {
            computer = new Cat();
            computer.setName("ComputerCat");
            createHero(computer);
            computer.setLevel(animal.getLevel());
            if(animal.getLevel()>1) {
                setStatsNextLevel.setStatsNextLevel(computer);
            }
        } else if (animal instanceof Dog) {
            computer = new Dog();
            computer.setName("ComputerDog");
            createHero(computer);
            computer.setLevel(animal.getLevel());
            if(animal.getLevel()>1) {
                setStatsNextLevel.setStatsNextLevel(computer);
            }
        }

        return computer;
    }

    @Override
    public void createHero(Animal animal) {
        if (animal instanceof Cat) {
            animal.setLevel(1);
            animal.setType("cat");
            animal.setHealth(100);
            animal.setMana(25);
            animal.setDamage(10);
            animal.setDefence(2);
            animal.setStrength(3);
            animal.setAgility(5);
            animal.setIntelligence(2);
            animal.setCriticalChance(3);
            animal.setCriticalStrikeMultiplier(2);
        } else if (animal instanceof Dog) {
            animal.setLevel(1);
            animal.setType("dog");
            animal.setHealth(100);
            animal.setMana(25);
            animal.setDamage(10);
            animal.setDefence(2);
            animal.setStrength(5);
            animal.setAgility(3);
            animal.setIntelligence(2);
            animal.setCriticalChance(3);
            animal.setCriticalStrikeMultiplier(2);
        }
    }

    @Override
    public String getName() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                System.out.println("Reader, exception");
            }
        }

    }

    @Override
    public int getIntReader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Enter number:");
            }
        }
    }

    @Override
    public void saveToFile(Animal animal) {
        StringBuilder stats = new StringBuilder()
                .append("id0: ").append(animal.getType())
                .append("\nid1: ").append(animal.getName())
                .append("\nid2: ").append(animal.getLevel())
                .append("\nid3: ").append(animal.getExperience())
                .append("\nid4: ").append(animal.getHealth())
                .append("\nid5: ").append(animal.getMana())
                .append("\nid6: ").append(animal.getDamage())
                .append("\nid7: ").append(animal.getDefence())
                .append("\nid8: ").append(animal.getStrength())
                .append("\nid9: ").append(animal.getAgility())
                .append("\nid10: ").append(animal.getIntelligence())
                .append("\nid11: ").append(animal.getCriticalChance())
                .append("\nid12: ").append(animal.getCriticalStrikeMultiplier());
        try {
            animalDao.saveToFile(stats, animal.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Animal loadFromFile(String name) {
        Animal animal = null;

        try {

            Map<String, String> stats = animalDao.loadFromFile(name);
            for (Map.Entry<String, String> type : stats.entrySet()) {
                if (type.getKey().equals("id0:")) {
                    if (type.getValue().equals("cat")) {
                        animal = new Cat();
                    } else if (type.getValue().equals("dog")) {
                        animal = new Dog();
                    }
                    break;
                }
            }

            for (Map.Entry<String, String> s :
                    stats.entrySet()) {
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
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return animal;
    }

    @Override
    public String exists(String fileName) {
        String fullName = "C:\\Users\\User\\Documents\\FA\\" + fileName + ".txt";
        File file = new File(fullName);
        if (!file.exists()) {
            System.out.println("File does not exists!");
            System.out.println(ENTER_YOUR_NAME);
            return exists(getName());
        }
        return fileName;
    }


    @Override
    public void flipACoin(Animal user, Animal computer) {
        IBattle iBattle = new Battle();
        int userThrows = 0;
        int computerThrows = 0;
        while (userThrows == computerThrows) {
            userThrows = (int) (Math.random() * 100 + 1);
            computerThrows = (int) (Math.random() * 100 + 1);
        }
        if (userThrows > computerThrows) {
            System.out.println(user.getName() + " rolls (1-100): " + userThrows + "\n" + computer.getName() + " rolls (1-100): " +
                    computerThrows + "\n" + user.getName() + " attacks first!\n");
            iBattle.battle(user, computer);
        } else {

            System.out.println(user.getName() + " rolls (1-100): " + userThrows + "\n" + computer.getName() + " rolls (1-100): " +
                    computerThrows + "\n" + computer.getName() + " attacks first!\n");
            iBattle.battle(computer, user);
        }
    }

    @Override
    public void levelUp(Animal animal) {
        ISetStatsNextLevel setStatsNextLevel = new SetStatsNextLevel();
        int level = (int) animal.getLevel();
        int levelUp = 100 * (level * (1 + level));
        if (animal.getExperience() >= levelUp) {
            animal.setLevel(animal.getLevel() + 1);
            setStatsNextLevel.setStatsNextLevel(animal);
        }
    }

    @Override
    public StringBuilder start() {
        StringBuilder stringBuilder = new StringBuilder(TITLE);
        stringBuilder.append("\t\tWelcome to FA\n").append(TITLE);
        return stringBuilder;
    }

    /**
     * Метод exit запрашивает у пользователя, продолжить покинуть игру или нет.
     *
     * @return boolean
     */
    @Override
    public boolean exit() {
        System.out.println("Quit the game?\n1-Yes.\n2-No.\n");
        while (true) {
            int i = getIntReader();
            if (i == 1) {
                return true;
            } else if (i == 2) {
                return false;
            }
        }
    }

}


