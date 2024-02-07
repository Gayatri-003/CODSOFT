package ProjectNew;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class menu extends account{
        Scanner sc = new Scanner(System.in);
        //DecimalFormat df  =new DecimalFormat("'$'###,##0.00");

        HashMap<Integer, Integer> customerData;

        public menu(){
            customerData = new HashMap<>();
            customerData.put(2468,3691);
            customerData.put(1357,4812);
        }
        
        public void getLogin() throws IOException{
            int attempts=0;
            do{
                int customerNumber=0,pinNumber=0;
                try{
                    System.out.println("Welcome to the ATM Machine!");
                    System.out.println("Enter your Custmor Number: ");
                    customerNumber = sc.nextInt();

                    System.out.println("Enter your PIN Number: ");
                    pinNumber = sc.nextInt();
                }
                catch(Exception e){
                    System.out.println("\n"+ "Invalid Charcters(s). Only Numbers."+"\n");
                    return;
                }

                if (customerData.containsKey(customerNumber) && customerData.get(customerNumber).equals(pinNumber)) {
                    getAccountType();
                    break;
                }
                else{
                    System.out.println("\n"+"Wrong Customer Number or Pin Number" + "\n");
                    attempts++;
                    if(attempts==3){
                        System.out.println("Session Expired.");
                        break;
                    }
                    System.out.println("Attempts left: "+(3-attempts));
                }
            }while(true);
        }

        public void getAccountType(){
            System.out.println("Select the Account Type: \n1. Checking Account\n2. Savings Account\n 3.Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    getCheckingAccount();
                    break;
                case 2:
                    getSavingAccount();
                    break;
                case 3:
                    System.out.println("\nThank You for using the ATM Machine.");
                    break; 
                
                default:
                    System.out.println("\nInvalid Choice.");
                    getAccountType();
                    break;
            }
        }

        public void getCheckingAccount(){
            System.out.println("Select the service for the Checking Account: \n1.View Balance\n2. Withdraw fund\n3.Deposit fund\n4. Exit");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Your Account Balance: "+checkingViewBalance());
                    getCheckingAccount();
                    break;
                case 2:
                    int res = checkingWithdrawFund();
                    if (res==-1) {
                        System.out.println("Insufficient Balance. Cannot perform the operation.");
                    }
                    else{
                        System.out.println("Money withdrawn Successfully."+"Your Account Balance: "+checkingViewBalance());
                    }
                    getCheckingAccount();
                    break;
                case 3:
                    System.out.println("Money Deposited Successfully."+"Your Account Balance: "+checkingDepositFund());
                    getCheckingAccount();
                    break;
                case 4:
                    System.out.println("Exit from Checking Account.");
                    getAccountType();
                    break;
                default:
                    System.out.println("\nInvalid Choice.");
                    getCheckingAccount();
                    break;
            }
        }

        public void getSavingAccount(){
            System.out.println("Select the service for the savings account: \n1.View Balance\n2. Withdraw fund\n3.Deposit fund\n4.Exit ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your Account Balance: "+savingsViewBalance());
                    getSavingAccount();
                    break;
                case 2:
                    int res = savingWithdrawFund();
                    if (res==-1) {
                        System.out.println("Insufficient Balance. Cannot perform the operation.");
                    }
                    else{
                        System.out.println("Money withdrawn Successfully."+"Your Account Balance: "+savingsViewBalance());
                    }
                    getSavingAccount();
                    break;
                case 3:
                    System.out.println("Money Deposited Successfully."+"Your Account Balance: "+savingsDepositFund());
                    getSavingAccount();
                    break;
                case 4:
                    System.out.println("Exit from Saving Account.");
                    getAccountType();
                    break;
            
                default:
                    System.out.println("\nInvalid Choice.");
                    getSavingAccount();
                    break;
            }
        }
    }
