import java.util.*;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class StudentGradeCalculatorUi extends Application{
    public static void main(String[] args){
        launch(args);
    }

    double marks[] = {0,0,0,0};
    @Override
    public void start(Stage primaryStage){

        Label lb4 = new Label("Student Grade Calculator");
        Label lb0 = new Label("Subject 1");
        TextField tf0 = new TextField();
        Label lb1 = new Label("Subject 2");
        TextField tf1 = new TextField();
        Label lb2 = new Label("Subject 3");
        TextField tf2 = new TextField();
        Label lb3 = new Label("Subject 4");
        TextField tf3 = new TextField();
        Button btn1 = new Button("Calculate");
        btn1.setId("calculateButton");
        Label lb5 = new Label("Total");
        TextField tf5 = new TextField();
        Label lb6 = new Label("Average Percentage");
        TextField tf6 = new TextField();
        Label lb7 = new Label("Status");
        TextField tf7 = new TextField();

        tf5.setEditable(false);
        tf6.setEditable(false);
        tf7.setEditable(false);

        btn1.setOnAction(e ->{
            marks[0] = Double.parseDouble(tf0.getText());
            marks[1] = Double.parseDouble(tf1.getText());
            marks[2] = Double.parseDouble(tf2.getText());
            marks[3] = Double.parseDouble(tf3.getText());

            double total=calcTotalMarks(marks, 4);
            double avg = calcAveragePerentage(total, 4);
            String grade = gradeCalc(avg);

            tf5.setPromptText(""+total);
            tf6.setPromptText(""+avg);
            tf7.setPromptText(""+grade);
        });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));

        // Load the background image
        Image bg_img = new Image("bg_img.jpeg");

        // Set the background image to the GridPane
        grid.setBackground(new javafx.scene.layout.Background(
                new BackgroundImage(bg_img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));


        Scene scene = new Scene(grid,500,500);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        grid.add(lb4,3,0,2,1);
        grid.add(lb0, 0, 1,2,1);
        grid.add(tf0,2,1,2,1);
        grid.add(lb1, 0, 2,2,1);
        grid.add(tf1,2,2,2,1);
        grid.add(lb2, 0, 3,2,1);
        grid.add(tf2,2,3,2,1);
        grid.add(lb3, 0, 4,2,1);
        grid.add(tf3,2,4,2,1);
        grid.add(btn1, 0, 5,2,1);
        grid.add(lb5, 0, 6,2,1);
        grid.add(tf5, 2, 6,2,1);
        grid.add(lb6, 0, 7,2,1);
        grid.add(tf6, 2, 7,2,1);
        grid.add(lb7, 0, 8,2,1);
        grid.add(tf7, 2, 8,2,1);


        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(500);
        primaryStage.setMaxWidth(500);
        primaryStage.setMaxHeight(500);

        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Number Guess Game");
        primaryStage.show();
    }
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
            return "You Failed";
        }
    }
}
