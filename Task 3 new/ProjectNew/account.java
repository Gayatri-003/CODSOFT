package ProjectNew;

import java.text.DecimalFormat;
import java.util.Scanner;

public class account {

    private int customerNumber=0;
    private int pinNumber=0;
    private int checkBalance=0;
    private int savingsBalance=0;

    Scanner input = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("'$'###,##0.00");

    /*public int setCustomerNumber(int i){
        this.customerNumber=customerNumber;
        return customerNumber;
    }
    public int getCustomerNumber(){
        return customerNumber;
    }
    public int setPinNumber(int i){
        this.pinNumber=pinNumber;
        return pinNumber;
    }
    public int getPinNumber(){
        return pinNumber;
    }*/

    public int checkingViewBalance(){
        return checkBalance;
    }
    public int savingsViewBalance(){
        return savingsBalance;
    }
    public int checkingWithdrawFund(){
        int amt=0;
        System.out.println("Enter the withdraw amount: ");
        amt=input.nextInt();
        if(checkBalance<amt){
            return -1;
        }
        else if (checkBalance>amt) {
            checkBalance=checkBalance-amt;
        }
        return checkBalance;
    }
    public int savingWithdrawFund(){
        int amt=0;
        System.out.println("Enter the withdraw amount: ");
        amt=input.nextInt();
        if(savingsBalance<amt){
            return -1;
        }
        else if (savingsBalance>amt) {
            return savingsBalance=savingsBalance-amt;
        }
        return savingsBalance;
    }
    public int checkingDepositFund(){
        int amt=0;
        System.out.println("Enter the deposit amount: ");
        amt=input.nextInt();
        return checkBalance=checkBalance+amt;
    }
    public int savingsDepositFund(){
        int amt=0;
        System.out.println("Enter the deposit amount: ");
        amt=input.nextInt();
        return savingsBalance=savingsBalance+amt;
    }
}
