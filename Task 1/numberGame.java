import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class numberGame extends Application {

    private int randomNum;
    private int guess = 5,prevGuess=0;
    private String feedback;

    @Override
    public void start(Stage primaryStage) {

        Label lb1 = new Label();
        Label lb2 = new Label();
        Label lb3 = new Label();
        Label lb4 = new Label();  // Moved lb4 here
        TextField tf1 = new TextField();
        Button btn1 = new Button("Start");
        btn1.setId("startButton");
        Button btn2 = new Button("OK");
        btn2.setId("okButton");
        Button btn3 = new Button("Replay");
        btn3.setId("replayButton");

        btn2.setDisable(true);
        btn3.setDisable(true);
        tf1.setDisable(true);

        lb1.setText("Welcome to the Number Guess Game!!! \n  \n **RULES**\n 1. Player has to guess a number between 1 to 100.\n2. Player will be provided with 5 guesses.\n3. Player wins for correct guess else loses.");

        btn1.setOnAction(e -> {
            randomNum = (int) (Math.random() * 100) + 1;
            lb2.setText("I have a number, you have to guess it.");
            btn2.setDisable(false);
            tf1.setDisable(false);
            guess=5;
            btn1.setDisable(true);
        });

        btn2.setOnAction(e -> {

            String input = tf1.getText();
            if(input.isEmpty()){
                lb4.setText("Input required!");
            }    
            int userInput = Integer.parseInt(input);
            if (userInput<=100 && userInput>=0) {
                if (userInput < randomNum) {
                    guess--;
                    feedback = "You have guessed Low. You are left with " + guess + " guesses";
                    prevGuess=userInput;
                } else if (userInput > randomNum) {
                    guess--;
                    feedback = "You have guessed High. You are left with " + guess + " guesses";
                    prevGuess=userInput;
                } else if (userInput == randomNum) {
                    feedback = "You have guessed perfectly. You have won!!!";
                    btn2.setDisable(true);
                    tf1.setDisable(true);
                    btn3.setDisable(false);
                }
                if (guess == 0) {
                    feedback = "You Lost!!! " + "The number is " + randomNum + ".";
                    btn2.setDisable(true);
                    tf1.setDisable(true);
                    btn3.setDisable(false);
                }
                lb3.setText("Previous Guess: "+prevGuess);
            lb4.setText(feedback);
            }
            else{
                lb4.setText("Input invalid!");
            }
            tf1.clear();
        });
        btn3.setOnAction(e ->{
            btn1.setDisable(false);
            btn3.setDisable(true);
            lb2.setDisable(true);
            lb3.setDisable(true);
            lb4.setDisable(true);

        });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        

        // Add components to the grid
        grid.add(lb1, 0, 0, 2, 1); // Span 2 columns
        grid.add(lb2, 0, 2, 2, 1);
        grid.add(lb3, 0, 6, 2, 1);
        grid.add(tf1, 1, 3);
        grid.add(btn1, 1, 1);
        grid.add(btn2, 1, 4);
        grid.add(btn3, 2, 4);
        grid.add(lb4, 0, 5, 2, 1);
        //grid.getChildren().addAll(lb1, lb2, lb3, tf1, btn1, btn2, lb4);

        Scene scene = new Scene(grid, 500, 500);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(500);
        primaryStage.setMaxWidth(500);
        primaryStage.setMaxHeight(500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Number Guess Game");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
