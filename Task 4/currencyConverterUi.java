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
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class currencyConverterUi extends Application {
    double amt=0;
    static String selectedBaseCurrency;
    static String selectedTargetCurrency;
    static String display;

    @Override
    public void start(Stage primaryStage) {
        TextField tf1 = new TextField();
        Button btn = new Button("Convert");
        btn.setId("convertButton");
        Button btn2 = new Button("Reset");
        btn2.setId("resetButton");
        Label lb = new Label();

        ComboBox<String> comboBox = new ComboBox<>();

        // Add items to the ComboBox
        ObservableList<String> items = FXCollections.observableArrayList(
                "Base",
                "Rupee",
                "Dollar",
                "Euro",
                "Yen"
        );
        comboBox.setItems(items);

        // Set a default selection (optional)
        comboBox.getSelectionModel().selectFirst();

        // Handle selection changes (optional)
        comboBox.setOnAction(event -> {
            String selectedOption = comboBox.getSelectionModel().getSelectedItem();
        });
        ComboBox<String> comboBox2 = new ComboBox<>();

        // Add items to the ComboBox
        ObservableList<String> items2 = FXCollections.observableArrayList(
                "Target",
                "Rupee",
                "Dollar",
                "Euro",
                "Yen"
        );
        comboBox2.setItems(items2);

        // Set a default selection (optional)
        comboBox2.getSelectionModel().selectFirst();

        // Handle selection changes (optional)
        comboBox2.setOnAction(event -> {
            String selectedOption2 = comboBox2.getSelectionModel().getSelectedItem();
        });

        btn.setOnAction(e -> {
            selectedBaseCurrency = comboBox.getSelectionModel().getSelectedItem();
            selectedTargetCurrency = comboBox2.getSelectionModel().getSelectedItem();
        
            if (selectedBaseCurrency != null && selectedTargetCurrency != null) {
                amt = Double.parseDouble(tf1.getText());
        
                switch (selectedBaseCurrency) {
                    case "Rupee":
                        rupee_to_other(selectedBaseCurrency, amt);
                        break;
                    case "Dollar":
                        dollar_to_other(selectedBaseCurrency, amt);
                        break;
                    case "Euro":
                        euro_to_other(selectedBaseCurrency, amt);
                        break;
                    case "Yen":
                        yen_to_other(selectedBaseCurrency, amt);
                        break;
                    default:
                        display=("Invalid Input.");
                        break;
                }
            }
            lb.setText(display);

        });

        btn2.setOnAction(e ->{
            tf1.clear();
            lb.setText(" ");
        });
        

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        // Adding components to the grid
        grid.add(tf1, 2, 1);
        grid.add(comboBox, 1, 1);
        grid.add(comboBox2, 3, 1);
        grid.add(btn,2,2);
        grid.add(btn2,2,3);
        grid.add(lb,2,5);

        Scene scene = new Scene(grid, 500, 500);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(500);
        primaryStage.setMaxHeight(500);
        primaryStage.setMaxHeight(500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void rupee_to_other(String selectedBaseCurrency, double amt){
        switch (selectedTargetCurrency) {
            case "Rupee":
                display = (amt+" Rupee = "+(amt)+" Rupee");
                break;
            case "Dollar":
                display = ("1 Rupee = 0.012 Dollar");
                display =(amt+" Rupees = "+(amt*0.012)+" Dollars");
                break;
            case "Euro":
                display=("1 Rupee = 0.011 Euro");
                display=(amt+" Rupees = "+(amt*0.011)+" Euro");
                break;
            case "Yen":
                display=("1 Rupee = 1.79 Yen");
                display=(amt+" Rupees = "+(amt*1.79)+" Yen");
                break;
            default:
                display=("Invalid Input.");
                break;
        }
    }
    public static void dollar_to_other(String selectedBaseCurrency, double amt){
        switch (selectedTargetCurrency) {
            case "Rupee":
                display=("1 Dollar = 83 Rupee");
                display=(amt+" Dollar = "+(amt*83)+" Rupee");
                break;
            case "Dollar":
                display=(amt+" Dollar = "+(amt)+" Dollar");
                break;
            case "Euro":
                display=("1 Dollar = 0.93 Euro");
                display=(amt+" Dollar = "+(amt*0.93)+" Euro");
                break;
            case "Yen":
                display=("1 Dollar = 148.38 Yen");
                display=(amt+" Dollar = "+(amt*148.38)+" Yen");
                break;
            default:
                display=("Invalid Input.");
                break;
        }
    }
    public static void euro_to_other(String selectedBaseCurrency, double amt){
        switch (selectedTargetCurrency) {
            case "Rupee":
                display=("1 Euro = 86.69 Rupee");
                display=(amt+" Euro = "+(amt*89.69)+" Rupee");
                break;
            case "Dollar":
                display=("1 Euro = 1.08 Dollar");
                display=(amt+" Rupees = "+(amt*1.08)+" Dollars");
                break;
            case "Euro":
                display=(amt+" Euro = "+(amt)+" Euro");
                break;
            case "Yen":
                display=("1 Euro = 160.34 Yen");
                display=(amt+" Euro = "+(amt*160.34)+" Yen");
                break;
            default:
                display=("Invalid Input.");
                break;
        }
    }
    public static void yen_to_other(String selectedBaseCurrencyr, double amt){
        switch (selectedTargetCurrency) {
            case "Rupee":
                display=("1 Yen = 0.56 Rupee");
                display=(amt+" Yen = "+(amt*0.56)+" Dollars");
                break;
            case "Dollar":
                display=("1 Yen = 0.0067 Dollar");
                display=(amt+" Yen = "+(amt*0.0067)+" Dollars");
                break;
            case "Euro":
                display=("1 Yen = 0.0062 Euro");
                display=(amt+" Yen = "+(amt*0.0062)+" Euro");
                break;
            case "Yen":
                display=(amt+" Yen = "+(amt)+" Yen");
                break;
            default:
                display=("Invalid Input.");
                break;
        }
    }
}
