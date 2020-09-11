package Game.Service;

import Game.Animals.Animal;
import Game.Animals.Cat;
import Game.Animals.Dog;
import Game.Service.Interfaces.ICreateHero;
import Game.Service.Interfaces.IService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Service implements IService, ICreateHero {

    /*Метод flipACoin пользователь и компьютер подбрасывает монету, кто побеждает - тот атакует первым!
     * Выводит в консоль рандомные значения.
     * В зависимости от победителя, в метод battle передаются соответствующие аргументы.*/
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

    /*Метод battle */
    public void battle(Animal animal1, Animal animal2) throws IOException {
        int counterRound = 1;
        while (true) {
            if (counterRound % 2 != 0) {
                System.out.println("Round " + counterRound + "!\n");
                int hp = hit(animal1, animal2);
                counterRound++;
                if (hp <= 0) {
                    System.out.println("Congratulation " + animal1.getName() + " won!");
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
                    System.out.println(animal2.getName() + " won!");
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
    public int hit(Animal animal1, Animal animal2) {
        if (getEvasion(animal2)) {
            System.out.println(animal2.getName() + " dodges!");
        } else if (getCriticalChance(animal1)) {
            double criticalDamage = animal1.getDamage() * animal1.getCriticalStrikeMultiplier();
            double criticalDamageWithDefence = criticalDamage - criticalDamage / 100 * getDefencePercent(animal2);
            System.out.println(animal1.getName() + " deal " + (int) criticalDamageWithDefence + " critical damage!");
            animal2.setHealth(animal2.getHealth() - (int) criticalDamageWithDefence);
        } else {
            double damage = animal1.getDamage() - animal1.getDamage() / 100 * getDefencePercent(animal2);
            System.out.println(animal1.getName() + " deal " + (int) damage + " damage!");
            animal2.setHealth(animal2.getHealth() - (int) damage);
        }
        return (int) animal2.getHealth();
    }

    /*Метод chooseRace создает на выбор Кота или Собаку.*/
    public Animal chooseRace() {
        while (true) {
            System.out.println("Выберите 1 или 2");//test
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

    /*Метод createHero создает пользовательскую сущность.
     * Задает стандартные характеристики сущности.
     * Запрашивает из консоли имя создоваемой сущности.
     * Так же обновляет урон, защиту, здоровье, ману - в зависимости от характеристик.*/
    @Override
    public void createHero(Animal animal) throws IOException {
        System.out.print("Enter your name: ");
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

    /*Метод createComputerHero проверяет входное значение пользователя, и сверяет на схожесть.
     * Создает компьютера с схожим классом и присваевает имя через метод getRandomName (Computer... + рандомное число).
     * Задает стандартные характеристики сущности.
     * Так же обновляет урон, защиту, здоровье, ману - в зависимости от характеристик.
     * Возвращает сущность.*/
    @Override
    public Animal createComputerHero(Animal user) {
        if (user instanceof Cat) {
            Cat computer = new Cat();
            computer.setName(getRandomName("ComputerCat"));
            computer.setLevel(user.getLevel());
            createHeroCat(computer);
            computer.setDamage(setDamageWithStrengthCat(computer));
            computer.setDefence(setDefenceWithAgilityCat(computer));
            computer.setHealth(setHealthWithStrengthCat(computer));
            computer.setMana(setManaWithIntelligenceCat(computer));
            return computer;

        } else {
            Dog computer = new Dog();
            computer.setName(getRandomName("ComputerDog"));
            computer.setLevel(user.getLevel());
            createHeroDog(computer);
            computer.setDamage(setDamageWithStrengthDog(computer));
            computer.setDefence(setDefenceWithAgilityDog(computer));
            computer.setHealth(setHealthWithStrengthDog(computer));
            computer.setMana(setManaWithIntelligenceDog(computer));
            return computer;
        }

    }

    /*Метод createHeroCat задает сущности Cat стандартные характеристики.*/
    @Override
    public void createHeroCat(Animal animal) {

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

    /*Метод showAnimalStats выводит в консоль характеристики сущности.*/
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
}
