package Animals;

import Homework.ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final String SPACE = " ";

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

//        ATM atm = new ATM(100, 100, 100);
//
//        do {
//            atm.checkBills();
//            System.out.print("Select a bill: ");
//            while (atm.checkSelect(Integer.parseInt(bf.readLine())) == 0) {
//                System.out.println("False");
//                System.out.print("Select a bill: ");
//            }
//            System.out.print("Enter the amount of money to withdraw: ");
//            atm.cashWithdrawal(Integer.parseInt(bf.readLine()), atm.getSelectBill());
//            System.out.println("Do you want to continue? : enter Y or N");
//            String s = bf.readLine();
//            if (s.toLowerCase().equals("y")) {
//                continue;
//            } else if (s.toLowerCase().equals("n")) {
//                System.out.println("Good buy!");
//                break;
//            }
//        } while (true);
//        bf.close();

        Cat cat = new Cat();
        cat.setName("Vaska");
        cat.setAge(5);

        Dog dog = new Dog();
        dog.setAge(3);
        dog.setName("Barsik");

        cat.saySmth();
        dog.saySmth();

        cat.play();


    }
}
