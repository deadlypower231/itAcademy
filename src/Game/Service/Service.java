package Game.Service;

import Game.Animals.Animal;
import Game.Animals.Cat;
import Game.Animals.Dog;
import Game.Service.Interfaces.ICreateHero;
import Game.Service.Interfaces.ILoadFromFile;
import Game.Service.Interfaces.ISaveToFile;
import Game.Service.Interfaces.IService;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Service implements IService, ICreateHero, ISaveToFile, ILoadFromFile {

    public static final String TITLE = "~=~=~=~=~=~=~=~=~=~=~=~=~=~=~\n";
    public static final String ENTER_YOUR_NAME = "Enter your name: ";

    /**
     * Метод flipACoin пользователь и компьютер подбрасывает монету, кто побеждает - тот атакует первым!
     * Выводит в консоль рандомные значения.
     * В зависимости от победителя, в метод battle передаются соответствующие аргументы.
     *
     * @param user     Object
     * @param computer Object
     */
    public void flipACoin(Animal user, Animal computer) throws IOException {
        int userThrows = 0;
        int computerThrows = 0;
        while (userThrows == computerThrows) {
            userThrows = (int) (Math.random() * 100 + 1);
            computerThrows = (int) (Math.random() * 100 + 1);
        }
        if (userThrows > computerThrows) {
            System.out.println(user.getName() + " rolls (1-100): " + userThrows + "\n" + computer.getName() + " rolls (1-100): " +
                    computerThrows + "\n" + user.getName() + " attacks first!\n");
            battle(user, computer);
        } else {

            System.out.println(user.getName() + " rolls (1-100): " + userThrows + "\n" + computer.getName() + " rolls (1-100): " +
                    computerThrows + "\n" + computer.getName() + " attacks first!\n");
            battle(computer, user);
        }
    }


    public void battle(Animal animal1, Animal animal2) throws IOException {
        int counterRound = 1;
        double startHpAnimal1 = animal1.getHealth();
        double startHpAnimal2 = animal2.getHealth();
        while (true) {
            if (counterRound % 2 != 0) {
                System.out.println("Round " + counterRound + "!\n");
                int hp = hit(animal1, animal2);
                counterRound++;
                if (hp <= 0) {
                    System.out.println("Congratulation " + animal1.getName() + " won!");
                    animal1.setExperience(animal1.getExperience() + (50 * animal1.getLevel() / 2));
                    animal2.setExperience(animal2.getExperience() + (25 * animal2.getLevel() / 2));
                    animal1.setHealth(startHpAnimal1);
                    animal2.setHealth(startHpAnimal2);
                    break;
                } else {
                    System.out.println(animal1.getName() + " health: " + (int) animal1.getHealth() + "\n" +
                            animal2.getName() + " health: " + (int) animal2.getHealth());
                }
            } else {
                System.out.println("Round " + counterRound + "!\n");
                int hp = hit(animal2, animal1);
                counterRound++;
                if (hp <= 0) {
                    System.out.println("Congratulation " + animal2.getName() + " won!");
                    animal2.setExperience(animal2.getExperience() + (50 * animal2.getLevel() / 2));
                    animal1.setExperience(animal1.getExperience() + (25 * animal1.getLevel() / 2));
                    animal1.setHealth(startHpAnimal1);
                    animal2.setHealth(startHpAnimal2);
                    break;
                } else {
                    System.out.println(animal1.getName() + " health: " + (int) animal1.getHealth() + "\n" +
                            animal2.getName() + " health: " + (int) animal2.getHealth());
                }
            }
            System.out.println("Press any button!");
            getStringReader();
        }
    }

    @Override
    public double randomDamage(Animal animal) {
        double random = Math.random() * 3;
        return (animal.getDamage() - 1) + random;
    }

    @Override
    public int hit(Animal animal1, Animal animal2) {
        if (getEvasion(animal2)) {
            System.out.println(animal2.getName() + " dodges!");
        } else if (getCriticalChance(animal1)) {
            double criticalDamage = randomDamage(animal1) * animal1.getCriticalStrikeMultiplier();
            double criticalDamageWithDefence = criticalDamage - criticalDamage / 100 * getDefencePercent(animal2);
            System.out.println(animal1.getName() + " deal " + (int) criticalDamageWithDefence + " critical damage!");
            animal2.setHealth(animal2.getHealth() - (int) criticalDamageWithDefence);
        } else {
            double randomDamage = randomDamage(animal1);
            double damage = randomDamage - randomDamage / 100 * getDefencePercent(animal2);
            System.out.println(animal1.getName() + " deal " + (int) damage + " damage!");
            animal2.setHealth(animal2.getHealth() - (int) damage);
        }
        return (int) animal2.getHealth();
    }

    /*Метод chooseRace создает на выбор Кота или Собаку.*/
    public Animal chooseRace() {
        while (true) {
            System.out.println("Choose:\n1-Cat.\n2-Dog.");
            int i = getIntReader();
            if (i > 0 && i < 3) {
                return (i == 1) ? new Cat() : new Dog();
            }
        }
    }

    /*Метод getIntReader читает из консоли вводимое значение и проверяет - является ли это значение числом.
     * Возвращает целочисленное число.*/
    @Override
    public int getIntReader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Введите число:");
            }
        }
    }

    /*Метод getStringReader читает из консоли строку.
     * Возвращает строковое значение.*/
    @Override
    public String getStringReader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    /**
     * Метод saveToFile сохраняет в файл на компьютере сущность.
     */
    @Override
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
    public void write(String fileName, StringBuilder stats) throws FileNotFoundException {
        File file = new File(fileName);
        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
        out.print(stats);
        out.close();
    }

    /**
     * Метод loadOrCreate предоставляет выбор: загрузить сущность или создать новую.
     *
     * @return Animal
     */
    @Override
    public Animal loadOrCreate() throws IOException {
        Animal animal;
        while (true) {
            System.out.println("\nLoad a hero or create a new hero?\n1-Load.\n2-Create.");
            int i = getIntReader();
            if (i > 0 && i < 3) {
                if (i == 1) {
                    return loadFromFile();
                } else {
                    animal = chooseRace();
                    createHero(animal);
                    return animal;
                }
            }
        }
    }

    @Override
    public Animal loadFromFile() throws IOException {
        Animal animal = chooseRace();
        String directory;
        System.out.println(ENTER_YOUR_NAME);
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
    public Map read(String fileName) {
        File file = new File(fileName);
        Map<String, String> map = new HashMap<>();
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                String s;
                while ((s = reader.readLine()) != null) {
                    String[] string = s.split(" ");
                    map.put(string[0], string[1]);
                }
            }
        } catch (Exception ignored) {
        }
        return map;
    }

    @Override
    public String exists(String directory, String fileName) throws IOException {
        String fullName = directory + fileName + ".txt";
        File file = new File(fullName);
        while (!file.exists()) {
            System.out.println("File does not exists!");
            System.out.println(ENTER_YOUR_NAME);
            return exists(directory, getStringReader());
        }
        return fullName;
    }

    /*Метод createHero создает пользовательскую сущность.
     * Задает стандартные характеристики сущности.
     * Запрашивает из консоли имя создоваемой сущности.
     * Так же обновляет урон, защиту, здоровье, ману - в зависимости от характеристик.*/
    @Override
    public void createHero(Animal animal) throws IOException {
        System.out.print(ENTER_YOUR_NAME);
        animal.setName(getStringReader());
        animal.setLevel(1);
        if (animal instanceof Cat) {
            createHeroCat(animal);
            animal.setDamage(setDamageWithStrengthCat(animal));
            animal.setDefence(setDefenceWithAgilityCat(animal));
            animal.setHealth(setHealthWithStrengthCat(animal));
            animal.setMana(setManaWithIntelligenceCat(animal));
        } else if (animal instanceof Dog) {
            createHeroDog(animal);
            animal.setDamage(setDamageWithStrengthDog(animal));
            animal.setDefence(setDefenceWithAgilityDog(animal));
            animal.setHealth(setHealthWithStrengthDog(animal));
            animal.setMana(setManaWithIntelligenceDog(animal));
        }

    }

    /**
     * Метод createComputerHero проверяет входное значение пользователя, и сверяет на схожесть.
     * Создает компьютера с схожим классом и присваевает имя через метод getRandomName (Computer... + рандомное число).
     * Задает стандартные характеристики сущности.
     * Так же обновляет урон, защиту, здоровье, ману - в зависимости от характеристик.
     * Возвращает сущность.
     *
     * @return Animal
     */
    @Override
    public Animal createComputerHero(Animal user) {
        if (user instanceof Cat) {
            Cat computer = new Cat();
            computer.setName(getRandomName("ComputerCat"));
            computer.setLevel(1);
            createHeroCat(computer);
            computer.setDamage(setDamageWithStrengthCat(computer));
            computer.setDefence(setDefenceWithAgilityCat(computer));
            computer.setHealth(setHealthWithStrengthCat(computer));
            computer.setMana(setManaWithIntelligenceCat(computer));
            while (computer.getLevel() != user.getLevel()) {
                if (computer.getLevel() < user.getLevel()) {
                    setStatsNextLevel(computer);
                    computer.setLevel(computer.getLevel() + 1);
                }
            }
            return computer;

        } else {
            Dog computer = new Dog();
            computer.setName(getRandomName("ComputerDog"));
            computer.setLevel(1);
            createHeroDog(computer);
            computer.setDamage(setDamageWithStrengthDog(computer));
            computer.setDefence(setDefenceWithAgilityDog(computer));
            computer.setHealth(setHealthWithStrengthDog(computer));
            computer.setMana(setManaWithIntelligenceDog(computer));
            while (computer.getLevel() != user.getLevel()) {
                if (computer.getLevel() < user.getLevel()) {
                    setStatsNextLevel(computer);
                    computer.setLevel(computer.getLevel() + 1);
                }
            }
            return computer;
        }

    }

    /*Метод createHeroCat задает сущности Cat стандартные характеристики.*/
    @Override
    public void createHeroCat(Animal animal) {
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
        animal.setEvasion(3);
    }

    /*Метод createHeroDog задает сущности Dog стандартные характеристики.*/
    @Override
    public void createHeroDog(Animal animal) {
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
        animal.setEvasion(3);
    }

    /*Метод setDamageWithStrengthCat изменяет стандартные значения Cat на значения с учетом силы.
     * Возвращает double.*/
    @Override
    public double setDamageWithStrengthCat(Animal animal) {
        return animal.getDamage() + (animal.getStrength() * 0.95);
    }

    /*Метод setDamageWithStrengthDog изменяет стандартные значения Dog на значения с учетом силы.
     * Возвращает double.*/
    @Override
    public double setDamageWithStrengthDog(Animal animal) {
        return animal.getDamage() + (animal.getStrength() * 1.05);
    }

    /*Метод setDefenceWithAgilityCat изменяет стандартные значения Cat на значения с учетом ловкости.
     * Возвращает double.*/
    @Override
    public double setDefenceWithAgilityCat(Animal animal) {
        return animal.getDefence() + (animal.getAgility() * 1.35);
    }

    /*Метод setDefenceWithAgilityDog изменяет стандартные значения Dog на значения с учетом ловкости.
     * Возвращает double.*/
    @Override
    public double setDefenceWithAgilityDog(Animal animal) {
        return animal.getDefence() + (animal.getAgility() * 1.75);
    }

    /*Метод setHealthWithStrengthCat изменяет стандартные значения Cat на значения с учетом силы.
     * Возвращает double.*/
    @Override
    public double setHealthWithStrengthCat(Animal animal) {
        return animal.getHealth() + (animal.getStrength() * 2.05);
    }

    /*Метод setHealthWithStrengthDog изменяет стандартные значения Dog на значения с учетом силы.
     * Возвращает double.*/
    @Override
    public double setHealthWithStrengthDog(Animal animal) {
        return animal.getHealth() + (animal.getStrength() * 3.05);
    }

    /*Метод setManaWithIntelligenceCat изменяет стандартные значения Cat на значения с учетом интеллекта.
     * Возвращает double.*/
    @Override
    public double setManaWithIntelligenceCat(Animal animal) {
        return animal.getMana() + (animal.getIntelligence() * 1.55);
    }

    /*Метод setManaWithIntelligenceDog изменяет стандартные значения Dog на значения с учетом интеллекта.
     * Возвращает double.*/
    @Override
    public double setManaWithIntelligenceDog(Animal animal) {
        return animal.getMana() + (animal.getIntelligence() * 1.55);
    }

    /**
     * Метод showAnimalStats выводит в консоль характеристики сущности.
     */
    @Override
    public void showAnimalStats(Animal animal) {
        System.out.println("~~~~~~~~~~" + animal.getName() + "~~~~~~~~~~\n" + "\nHealth: " + (int) animal.getHealth() +
                "\nMana: " + (int) animal.getMana() + "\nDamage: " + (int) animal.getDamage() +
                "\nDefence: " + (int) animal.getDefence() + "\nStrength: " + (int) animal.getStrength() +
                "\nAgility: " + (int) animal.getAgility() + "\nIntelligence: " + (int) animal.getIntelligence() +
                "\nLevel: " + (int) animal.getLevel() + "\n");
    }

    /*Метод getRandomName склеивает входную строку с рандомным числом от 0 до 99
     * Возвращает строку.*/
    @Override
    public String getRandomName(String string) {
        return string + (int) (Math.random() * 100);
    }

    /*Метод getCriticalChance возвращает шанс критической атаки в зависимости от ловкости входной сущности.
     * Возвращает boolean.*/
    @Override
    public boolean getCriticalChance(Animal animal) {
        return (int) (Math.random() * 100 + 1) <= (animal.getCriticalChance() + (animal.getAgility() * 0.05));
    }

    /*Метод getEvasion возвращает шанс уклонения от атаки в зависимости от ловкости входной сущности.
     * Возвращает boolean.*/
    @Override
    public boolean getEvasion(Animal animal) {
        int random = (int) (Math.random() * 100 + 1);
        return random <= (animal.getEvasion() + (animal.getAgility() * 0.05));

    }

    /*Метод getDefencePercent возвращает процент защиты сушности.
     * Возвращает boolean.*/
    @Override
    public double getDefencePercent(Animal animal) {
        return animal.getDefence() * 1.70;
    }

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
            if (i > 0 && i < 3) {
                return (i == 1) ? true : false;
            }
        }
    }

    @Override
    public void levelUp(Animal animal) {
        int level = (int) animal.getLevel();
        int levelUp = 100 * (level * (1 + level));
        if (animal.getExperience() >= levelUp) {
            animal.setLevel(animal.getLevel() + 1);
            setStatsNextLevel(animal);
        }
    }

    @Override
    public void setStatsNextLevel(Animal animal) {
        int level = (int) animal.getLevel();
        if (animal instanceof Cat) {
            animal.setHealth(animal.getHealth() + (10 + level * 2));
            animal.setMana(animal.getMana() + (5 + level));
            animal.setDamage(animal.getDamage() + (2 + level * 0.5));
            animal.setStrength(animal.getStrength() + 1.25);
            animal.setAgility(animal.getAgility() + 2.05);
            animal.setIntelligence(animal.getIntelligence() + 0.95);
            animal.setDamage(setDamageWithStrengthDog(animal));
            animal.setDefence(setDefenceWithAgilityDog(animal));
            animal.setHealth(setHealthWithStrengthDog(animal));
            animal.setMana(setManaWithIntelligenceDog(animal));
        } else if (animal instanceof Dog) {
            animal.setHealth(animal.getHealth() + (12 + level * 2));
            animal.setMana(animal.getMana() + (4 + level));
            animal.setDamage(animal.getDamage() + (3 + level * 0.5));
            animal.setStrength(animal.getStrength() + 2.25);
            animal.setAgility(animal.getAgility() + 1.05);
            animal.setIntelligence(animal.getIntelligence() + 0.85);
            animal.setDamage(setDamageWithStrengthDog(animal));
            animal.setDefence(setDefenceWithAgilityDog(animal));
            animal.setHealth(setHealthWithStrengthDog(animal));
            animal.setMana(setManaWithIntelligenceDog(animal));
        }
    }
}
