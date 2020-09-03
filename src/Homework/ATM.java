package Homework;

import Animals.Main;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class ATM {

    public static final String HUNDRED_BYN = "100BYN";
    public static final String FIFTY_BYN = "50BYN";
    public static final String TWENTY_BYN = "20BYN";
    public static final String MULTIPLY = " * ";
    public static final String OPERATION_SUCCESSFUL = "Operation successful!";
    public static final String WITHDRAW_OF_MONEY = "Withdraw of money: ";
    public static final String DOT_SPACE = ". ";
    public static final String VERTICAL_SLASH = "|||||||||||||||||||||||||||||||||||||||||||||";

    public int totalMoney;
    public int quantityBillsOf20;
    public int quantityBillsOf50;
    public int quantityBillsOf100;
    public int selectBill;

    public ATM(){

    }

    public ATM(int quantityBillsOf20, int quantityBillsOf50, int quantityBillsOf100){
        this.quantityBillsOf20 = quantityBillsOf20;
        this.quantityBillsOf50 = quantityBillsOf50;
        this.quantityBillsOf100 = quantityBillsOf100;
        this.totalMoney = (quantityBillsOf20 * 20) + (quantityBillsOf50 * 50) + (quantityBillsOf100 * 100);

    }

    public void setQuantityBills(int quantityBillsOf20, int quantityBillsOf50, int quantityBillsOf100){
        this.quantityBillsOf20 = quantityBillsOf20;
        this.quantityBillsOf50 = quantityBillsOf50;
        this.quantityBillsOf100 = quantityBillsOf100;
        this.totalMoney = (quantityBillsOf20 * 20) + (quantityBillsOf50 * 50) + (quantityBillsOf100 * 100);
    }

    public int checkSelect(int select){

        if (select == 100 && quantityBillsOf100 != 0){
            System.out.println("Maximum withdrawal amount: "+ select * quantityBillsOf100);
            selectBill = 100;
        }else if (select == 50 && quantityBillsOf50 != 0){
            System.out.println("Maximum withdrawal amount: "+ select * quantityBillsOf50);
            selectBill = 50;
        }else if (select == 20 && quantityBillsOf20 != 0){
            System.out.println("Maximum withdrawal amount: "+ select * quantityBillsOf20);
            selectBill = 20;
        }else  {
            selectBill = 0;
        }
        return selectBill;
    }

    public void cashWithdrawal(int quantity, int select){
        int amountOf20Bills = quantityBillsOf20 * 20;
        int amountOf50Bills = quantityBillsOf50 * 50;
        int amountOf100Bills = quantityBillsOf100 * 100;
        int count;

        if (quantity <= amountOf100Bills && quantity % select == 0 && select == 100){

            System.out.println(OPERATION_SUCCESSFUL.toUpperCase());
            count = quantity / 100;
            System.out.println(WITHDRAW_OF_MONEY + quantity  + Main.SPACE + HUNDRED_BYN + MULTIPLY +  count);
            setQuantityBills(quantityBillsOf20,quantityBillsOf50, quantityBillsOf100 - count);

        }else if (quantity <= amountOf50Bills && quantity % select == 0 && select == 50){

            count = quantity / 50;
            System.out.println(OPERATION_SUCCESSFUL.toUpperCase());
            System.out.println(WITHDRAW_OF_MONEY + quantity  + Main.SPACE + FIFTY_BYN + MULTIPLY + count);
            setQuantityBills(quantityBillsOf20,quantityBillsOf50 - count, quantityBillsOf100);
        }else if (quantity <= amountOf20Bills && quantity % select == 0 && select == 20){

            count = quantity / 20;
            System.out.println(OPERATION_SUCCESSFUL.toUpperCase());
            System.out.println(WITHDRAW_OF_MONEY + quantity  + Main.SPACE + TWENTY_BYN + MULTIPLY + count);
            setQuantityBills(quantityBillsOf20 - count, quantityBillsOf50, quantityBillsOf100);

        }else {

            System.out.println("This operation is failed!".toUpperCase());
            System.out.println("This operation is failed!".toUpperCase());

        }



    }

    public void checkBills(){

        StringBuilder stringBuilder = new StringBuilder(VERTICAL_SLASH + "\nAvailability of bills : ");
        if (quantityBillsOf100 > 0){
            stringBuilder.append(HUNDRED_BYN + DOT_SPACE);
        }if (quantityBillsOf50 > 0){
            stringBuilder.append(FIFTY_BYN + DOT_SPACE);
        }if (quantityBillsOf20 > 0){
            stringBuilder.append(TWENTY_BYN + DOT_SPACE);
        }
        stringBuilder.append("\n" + VERTICAL_SLASH);
        System.out.println(stringBuilder);
    }

    public int getQuantityBillsOf20() {
        return quantityBillsOf20;
    }

    public int getQuantityBillsOf50() {
        return quantityBillsOf50;
    }

    public int getQuantityBillsOf100() {
        return quantityBillsOf100;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public int getSelectBill() {
        return selectBill;
    }

    public void setQuantityBillsOf20(int quantityBillsOf20) {
        this.quantityBillsOf20 = quantityBillsOf20;
    }

    public void setQuantityBillsOf50(int quantityBillsOf50) {
        this.quantityBillsOf50 = quantityBillsOf50;
    }

    public void setQuantityBillsOf100(int quantityBillsOf100) {
        this.quantityBillsOf100 = quantityBillsOf100;
    }
}
