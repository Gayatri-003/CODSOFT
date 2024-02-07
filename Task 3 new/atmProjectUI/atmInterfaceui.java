package atmProjectUI;

import java.util.HashMap;
//import atmProjectUI.account;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class atmInterfaceui extends Application {
    static account acc = new account();

    HashMap<Integer, Integer> customerData;
    public atmInterfaceui(){
        customerData = new HashMap<>();
            customerData.put(2468,3691);
            customerData.put(1357,4812);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

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

        btn1.setOnAction(e-> {
            do{
                int customerNumber=0,pinNumber=0;
                try{
                    customerNumber = Integer.parseInt(tf1.getText());
                    pinNumber = Integer.parseInt(tf2.getText());
                }
                catch(Exception excep){
                    System.out.println(""+excep);
                    return;
                }

                if (customerData.containsKey(customerNumber) && customerData.get(customerNumber).equals(pinNumber)) {
                    showSecondStage();
                    break;
                }
                else{
                    lb4.setText("Incorrect Customer Number or Pin Number");
                }
            }while(true);
        });

        Scene scene = new Scene(grid,500,500);
        //scene.getStylesheets().add(getClass().getResource(""));

        grid.add(lb1, 0, 0);
        grid.add(tf1, 0, 1);
        grid.add(lb2, 0, 2);
        grid.add(tf2, 0, 3);
        grid.add(btn1,0,5);
        grid.add(lb4,0,6);

        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(500);
        primaryStage.setMaxWidth(500);
        primaryStage.setMaxHeight(500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("atmInterface");
        primaryStage.show();
    }

    public static void showSecondStage() {
        Stage secondStage = new Stage();
        
        Label lb5= new Label("Select the account type: ");
        Button btn3 = new Button("  Enter  ");
        // Create a ComboBox with options
        // Create a ComboBox and populate it with options
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setItems(FXCollections.observableArrayList("None", "Checking Account", "Saving Account"));

        handleComboBoxAction(comboBox);
        
        secondStage.setTitle("Option-Menu");
    
        GridPane grid2 = new GridPane();
        grid2.setHgap(10);
        grid2.setVgap(10);
    
        Button btn2 = new Button("  BACK  ");
        grid2.add(btn2, 0, 0);
        grid2.add(lb5, 1, 1);
        grid2.add(comboBox, 1, 2);
        grid2.add(btn3, 1, 3);
    
        // Handle button click to close the second stage
        btn2.setOnAction(e -> secondStage.close());
        btn3.setOnAction(e->{
            String selectedOption = comboBox.getValue();
            if(selectedOption.equals("Checking Account")){
                showThirdStage();
            }
            else if(selectedOption.equals("Saving Account")){
                //showFourthStage();
            }
        });
    
        Scene secondScene = new Scene(grid2, 500, 500);
        secondStage.setScene(secondScene);
    
        // Show the second stage
        secondStage.show();
    }

    private static void handleComboBoxAction(ComboBox<String> comboBox) {
        comboBox.setOnAction(e -> {
            String selectedOption = comboBox.getValue();
            System.out.println("Selected option: " + selectedOption);
        });
    }

    public static void showThirdStage() {
        Stage thirdStage = new Stage();
        
        Label lb5= new Label("Select the service for the Checking Account: ");
        TextField tf1 = new TextField();
        Button btn3 = new Button("  Enter  ");
        // Create a ComboBox with options
        // Create a ComboBox and populate it with options
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setItems(FXCollections.observableArrayList("None", "View Balance","Withdraw fund","Deposit fund"));

        handleComboBoxAction(comboBox);
        
        thirdStage.setTitle("Checking-Acc");
    
        GridPane grid2 = new GridPane();
        grid2.setHgap(10);
        grid2.setVgap(10);
    
        Button btn2 = new Button("  BACK  ");
        grid2.add(btn2, 0, 0);
        grid2.add(lb5, 1, 1);
        grid2.add(comboBox, 1, 2);
        grid2.add(btn3, 1, 3);
        grid2.add(tf1, 1, 4);
    
        // Handle button click to close the second stage
        btn2.setOnAction(e -> thirdStage.close());
        btn3.setOnAction(e->{
            String selectedOption = comboBox.getValue();
            if(selectedOption.equals("View Balance")){
                tf1.setText(Integer.toString(acc.checkingViewBalance()));
            }
            else if(selectedOption.equals("Withdraw Funds")){
                
            }
            else if(selectedOption.equals("Deposit Funds")){
                
            }
        });
    
        Scene secondScene = new Scene(grid2, 500, 500);
        thirdStage.setScene(secondScene);
    
        // Show the second stage
        thirdStage.show();
    }
    
}
