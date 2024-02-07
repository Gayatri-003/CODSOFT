import java.util.*;

/**
 * StudentGradeCalculator
 */
public class StudentGradeCalculator {
    
    static double calcTotalMarks(double[] marks,int n){
        double sum=0;
        for(int i=0;i<n;i++){
            if(marks[i]<=100 && marks[i]>=0){
                sum = sum+marks[i];
            }
        }
        return sum;    
    }
    static double calcAveragePerentage(Double total,int numSub){
        return total/numSub;
    }
    static String gradeCalc(double avg){
        if (avg>=90){
            return "Grade: A";
        }
        else if (avg>=80 && avg<90) {
            return "Grade: B";
        }
        else if (avg>=70 && avg<80) {
            return "Grade: C";
        }
        else if (avg>=60 && avg<70) {
            return "Grade: D";
        }
        else if (avg>=50 && avg<60) {
            return "Grade: E";
        }
        else if(avg>=40 && avg<50){
            return "Grade: F";
        }
        else{
            return "You Failed.";
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char ch;

        do{
        System.out.println("Enter the number of Subjects (out of 100): ");
        int n = sc.nextInt();
        double marks[] = new double[n];
        String stat=null;
        for(int i=0;i<n;i++){
            double temp=0;
            System.out.println("Enter the marks of Subject "+(i+1)+": ");
            temp =sc.nextDouble();
            if(temp>=0 && temp<=100)
                marks[i]=temp;
            else{
                stat = "Invalid Input";
                System.out.println(stat);
                break;
            }
        }

        if(stat !=null && stat.equals("Invalid Input")){
            System.out.println("No result displayed.");
        }
        else{
            Double total =calcTotalMarks(marks,n);
            System.out.println("Total Marks(out of "+(n*100)+"): "+total);
            double avg = calcAveragePerentage(total,n);
            System.out.format("Average Percentage: %.2f",avg);
            String grade = gradeCalc(avg);
            System.out.println("\n"+grade);
        }
        System.out.println("Do You want to continue? ");
        ch = sc.next().charAt(0);
    }while(ch=='Y' || ch=='y');
    }
}