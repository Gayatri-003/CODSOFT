//package taskOne;

import java.util.*;

class numberGameRaw{

        void GuessNumber() {
                Scanner sc = new Scanner(System.in);
                char ch;
                System.out.println("Welcome to the Number Guess Game!!!");
                do {
                        System.out.println("I have a number, you have to guess it.");
                        int randomNum = (int)(Math.random() *100)+1;
                        System.out.println("You will be provided with 5 guesses.");
                        int guess =5;

                        for(int i=1;i<=5;i++) {
                        System.out.println("Enter your number : ");
                        int num = sc.nextInt();

                        if(num<randomNum) {
                                guess--;
                                System.out.println("You have guessed Low." + "You are left with "+guess+" guesses");
                        }
                        else if(num>randomNum){
                                guess--;
                                System.out.println("You have guessed High." + "You are left with "+guess+" guesses");
                        }
                        else if(num==randomNum) {
                                System.out.println("You have guessed perfectly." + "You are won!!!");
                                break;
                        }
                        if(guess==0) {
                                System.out.println("You Lost!!! "+ "The number is "+randomNum+" .");
                                break;
                        }
                        }
                        
                        System.out.println("Do you want to continue?");
                        ch = sc.next().charAt(0);
                }while(ch=='y'||ch=='Y');

                System.out.println("Game Finished!");
        }

        public static void main(String[] args) {
                numberGameRaw ng = new numberGameRaw();
                ng.GuessNumber();
        }
}