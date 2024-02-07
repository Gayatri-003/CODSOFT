import java.util.*;
/**
 * currencyConverter
 */
public class currencyConverter {

    public static void selectCurrency(){
        char ch;
        do{

            Scanner sc= new Scanner(System.in);
            System.out.println("Choose the Base Currency: \n1.Rupee\n2.Dollar\n3.Euro\n4.Yen");
            int base_curr = sc.nextInt();
            System.out.println("Enter the amount: ");
            double amt=sc.nextDouble();
            System.out.println("Choose the Target Currency: \n1.Rupee\n2.Dollar\n3.Euro\n4.Yen");
            int Target= sc.nextInt();
            switch(Target){
                case 1:
                    rupee_to_other(base_curr,amt);
                    break;
                case 2:
                    dollar_to_other(base_curr,amt);
                    break;
                case 3:
                    euro_to_other(base_curr,amt);
                    break;
                case 4:
                    yen_to_other(base_curr,amt);
                    break;
                default:
                    System.out.println("Invalid Input.");
                    break;
        }
        System.out.println();
        System.out.println("Do you want to continue?");
        ch = sc.next().charAt(0);
        }while(ch=='Y' || ch=='y');
    }
    public static void rupee_to_other(int base_curr, double amt){
        switch (base_curr) {
            case 1:
                System.out.println(amt+" Rupee = "+(amt)+" Rupee");
                break;
            case 2:
                System.out.println("1 Rupee = 0.012 Dollar");
                System.out.println(amt+" Rupees = "+(amt*0.012)+" Dollars");
                break;
            case 3:
                System.out.println("1 Rupee = 0.011 Euro");
                System.out.println(amt+" Rupees = "+(amt*0.011)+" Euro");
                break;
            case 4:
                System.out.println("1 Rupee = 1.79 Yen");
                System.out.println(amt+" Rupees = "+(amt*1.79)+" Yen");
                break;
            default:
                System.out.println("Invalid Input.");
                break;
        }
    }
    public static void dollar_to_other(int base_curr, double amt){
        switch (base_curr) {
            case 1:
                System.out.println("1 Dollar = 83 Rupee");
                System.out.println(amt+" Dollar = "+(amt*83)+" Rupee");
                break;
            case 2:
                System.out.println(amt+" Dollar = "+(amt)+" Dollar");
                break;
            case 3:
                System.out.println("1 Dollar = 0.93 Euro");
                System.out.println(amt+" Dollar = "+(amt*0.93)+" Euro");
                break;
            case 4:
                System.out.println("1 Dollar = 148.38 Yen");
                System.out.println(amt+" Dollar = "+(amt*148.38)+" Yen");
                break;
            default:
                System.out.println("Invalid Input.");
                break;
        }
    }
    public static void euro_to_other(int base_curr, double amt){
        switch (base_curr) {
            case 1:
                System.out.println("1 Euro = 86.69 Rupee");
                System.out.println(amt+" Euro = "+(amt*89.69)+" Rupee");
                break;
            case 2:
                System.out.println("1 Euro = 1.08 Dollar");
                System.out.println(amt+" Rupees = "+(amt*1.08)+" Dollars");
                break;
            case 3:
                System.out.println(amt+" Euro = "+(amt)+" Euro");
                break;
            case 4:
                System.out.println("1 Euro = 160.34 Yen");
                System.out.println(amt+" Euro = "+(amt*160.34)+" Yen");
                break;
            default:
                System.out.println("Invalid Input.");
                break;
        }
    }
    public static void yen_to_other(int base_curr, double amt){
        switch (base_curr) {
            case 1:
                System.out.println("1 Yen = 0.56 Rupee");
                System.out.println(amt+" Yen = "+(amt*0.56)+" Dollars");
                break;
            case 2:
                System.out.println("1 Yen = 0.0067 Dollar");
                System.out.println(amt+" Yen = "+(amt*0.0067)+" Dollars");
                break;
            case 3:
                System.out.println("1 Yen = 0.0062 Euro");
                System.out.println(amt+" Yen = "+(amt*0.0062)+" Euro");
                break;
            case 4:
                System.out.println(amt+" Yen = "+(amt)+" Yen");
                break;
            default:
                System.out.println("Invalid Input.");
                break;
        }
    }
    

    public static void main(String []args){
        selectCurrency();
    }
}