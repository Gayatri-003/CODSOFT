package atmProjectUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


import java.util.HashMap;
import java.util.Stack;

public class AtmMachine extends Application {

    private Stage primaryStage;
    private Stack<Scene> sceneStack = new Stack<>();
    static account acc = new account();

    HashMap<Integer, Integer> customerData;
    public AtmMachine(){
        customerData = new HashMap<>();
            customerData.put(2468,3691);
            customerData.put(1357,4812);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Multi Scene Navigation Example");

        Scene initialScene = home();;
        sceneStack.push(initialScene);  

        primaryStage.setScene(initialScene);
        primaryStage.show();
    }

    public Scene home() {

        TextField tf1= new TextField();
        TextField tf2=new TextField();
        Label lb1= new Label("Customer ID");
        Label lb2= new Label("Pin");
        //Label lb3= new Label();
        Label lb4= new Label();
        Button btn1= new Button("Proceed");

        GridPane grid =new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));

        // Set background image
        Image backgroundImage = new Image("https://img.freepik.com/premium-vector/abstract-tech-concept-background-overlapped-lines_181182-573.jpg");
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                null, null, null, null);
        Background backgroundWithImage = new Background(backgroundImg);
        grid.setBackground(backgroundWithImage);

        btn1.setOnAction(e -> {
        try {
            int customerNumber = Integer.parseInt(tf1.getText());
            int pinNumber = Integer.parseInt(tf2.getText());

            if (customerData.containsKey(customerNumber) && customerData.get(customerNumber).equals(pinNumber)) {
                Platform.runLater(() -> showScene(createGridPaneScene()));
            } else {
                Platform.runLater(() -> lb4.setText("Incorrect Customer Number or Pin Number"));
            }
        } catch (Exception exception) {
            System.out.println("" + exception);
        }
    });
        //scene.getStylesheets().add(getClass().getResource(""));

        grid.add(lb1, 0, 0);
        grid.add(tf1, 0, 1);
        grid.add(lb2, 0, 2);
        grid.add(tf2, 0, 3);
        grid.add(btn1,0,5);
        grid.add(lb4,0,6);

        return new Scene(grid, 600, 300);
    }

    private Scene createGridPaneScene() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Set background image
        Image backgroundImage = new Image("https://img.freepik.com/premium-vector/modern-blue-abstract-background-vector-illustration-design-presentation-banner-cover-web-flyer-card-poster-wallpaper-texture-slide-magazine-powerpoint_181182-19660.jpg");
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                null, null, null, null);
        Background backgroundWithImage = new Background(backgroundImg);
        gridPane.setBackground(backgroundWithImage);

        // Create buttons to switch between scenes
        Button scene1Button = new Button("Checking Account");
        Button scene2Button = new Button("Saving Account");
        Button logout = new Button("LogOut");

        logout.setPrefWidth(20);

        // Handle button actions
        scene1Button.setOnAction(e -> showScene(createScene1()));
        scene2Button.setOnAction(e -> showScene(createScene2()));
        logout.setOnAction(e-> goBack());

        // Add buttons to the grid
        gridPane.add(scene1Button, 40, 20);
        gridPane.add(scene2Button, 40, 21);
        gridPane.add(logout, 0, 0);

        return new Scene(gridPane, 626, 358);
    }

    private Scene createScene1() {
        GridPane sceneContent = new GridPane();
        sceneContent.setPadding(new Insets(10));
        sceneContent.setHgap(10);
        sceneContent.setVgap(10);

        Image backgroundImage = new Image("https://img.freepik.com/free-vector/simple-blank-green-background-business_53876-117344.jpg");
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                null, null, null, null);
        Background backgroundWithImage = new Background(backgroundImg);
        sceneContent.setBackground(backgroundWithImage);

        // Add components to sceneContent as needed
        Button btn1=new Button("View Balance");
        Button btn2=new Button("Withdraw Funds");
        Button btn3=new Button("Deposit Funds");
        Label lb1= new Label("Withdraw Amount");
        TextField tf1 = new TextField();
        Label lb2= new Label("Deposit Amount");
        TextField tf2 = new TextField();
        Label lb3= new Label("Balance");
        TextField tf3 = new TextField();
        Button backButton = new Button("Back");
        TextField tf4= new TextField();
        
        backButton.setOnAction(e -> goBack());
        btn1.setOnAction(e->{
            tf3.setText(Integer.toString(acc.checkingViewBalance()));
        });
        btn2.setOnAction(e -> {
            Platform.runLater(() -> {
                int amt = Integer.parseInt(tf1.getText());
                int res = acc.checkingWithdrawFund(amt);
                    if (res==-1) {
                        tf4.setText("Insufficient Balance.");
                    }
                    else{
                        tf4.setText("Withdrawn Successfully.");
                    }
                tf3.setText(Integer.toString(acc.checkingViewBalance()));
            });
        });
        btn3.setOnAction(e->{
            int amt = Integer.parseInt(tf2.getText());
            int res= (acc.checkingDepositFund(amt));
            tf3.setText(Integer.toString(acc.checkingViewBalance()));
            tf4.setText("Deposited Successfully.");
        });


        sceneContent.add(backButton, 0, 0);
        sceneContent.add(btn1, 5, 5);
        sceneContent.add(btn2, 5, 6);
        sceneContent.add(btn3, 5, 7);
        sceneContent.add(lb1, 1, 1);
        sceneContent.add(tf1, 1, 2);
        sceneContent.add(lb2, 2, 1);
        sceneContent.add(tf2,2, 2);
        sceneContent.add(lb3, (int) 1.5, 3);
        sceneContent.add(tf3, (int) 1.5, 4);
        sceneContent.add(tf4, 1, 8);

        return new Scene(sceneContent, 626, 358);
    }

    private Scene createScene2() {
        GridPane sceneContent = new GridPane();
        sceneContent.setPadding(new Insets(10));
        sceneContent.setHgap(10);
        sceneContent.setVgap(10);

        Image backgroundImage = new Image("https://img.freepik.com/free-vector/simple-blue-gradient-background-vector-business_53876-143439.jpg?size=626&ext=jpg&ga=GA1.1.1448711260.1706659200&semt=ais");
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                null, null, null, null);
        Background backgroundWithImage = new Background(backgroundImg);
        sceneContent.setBackground(backgroundWithImage);

        // Add components to sceneContent as needed
        Button btn1=new Button("View Balance");
        Button btn2=new Button("Withdraw Funds");
        Button btn3=new Button("Deposit Funds");
        Label lb1= new Label("Withdraw Amount");
        TextField tf1 = new TextField();
        Label lb2= new Label("Deposit Amount");
        TextField tf2 = new TextField();
        Label lb3= new Label("Balance");
        TextField tf3 = new TextField();
        Button backButton = new Button("Back");
        TextField tf4= new TextField();
        
        backButton.setOnAction(e -> goBack());
        btn1.setOnAction(e->{
            tf3.setText(Integer.toString(acc.savingsViewBalance()));
        });
        btn2.setOnAction(e -> {
            Platform.runLater(() -> {
                int amt = Integer.parseInt(tf1.getText());
                int res = acc.savingWithdrawFund(amt);
                    if (res==-1) {
                        tf4.setText("Insufficient Balance.");
                    }
                    else{
                        tf4.setText("Withdrawn Successfully.");
                    }
                tf3.setText(Integer.toString(acc.savingsViewBalance()));
            });
        });
        btn3.setOnAction(e->{
            int amt = Integer.parseInt(tf2.getText());
            int res= (acc.savingsDepositFund(amt));
            tf3.setText(Integer.toString(acc.savingsViewBalance()));
            tf4.setText("Deposited Successfully.");
        });


        sceneContent.add(backButton, 0, 0);
        sceneContent.add(btn1, 5, 5);
        sceneContent.add(btn2, 5, 6);
        sceneContent.add(btn3, 5, 7);
        sceneContent.add(lb1, 1, 1);
        sceneContent.add(tf1, 1, 2);
        sceneContent.add(lb2, 2, 1);
        sceneContent.add(tf2,2, 2);
        sceneContent.add(lb3, (int) 1.5, 3);
        sceneContent.add(tf3, (int) 1.5, 4);
        sceneContent.add(tf4, 1, 8);

        return new Scene(sceneContent, 626, 358);
    }

    private void showScene(Scene scene) {
        sceneStack.push(scene);
        primaryStage.setScene(scene);
    }

    private void goBack() {
        if (!sceneStack.isEmpty()) {
            sceneStack.pop(); // Remove current scene from the stack
            if (!sceneStack.isEmpty()) {
                Scene previousScene = sceneStack.peek(); // Get the previous scene
                primaryStage.setScene(previousScene);
            }
        }
    }

}
