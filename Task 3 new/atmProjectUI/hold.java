package atmProjectUI;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class hold extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX ComboBox Example");

        // Create a ComboBox with options
        ComboBox<String> comboBox = new ComboBox<>();
        ObservableList<String> options = FXCollections.observableArrayList(
                "Option 1",
                "Option 2",
                "Option 3"
        );
        comboBox.setItems(options);

        // Set default selection
        comboBox.getSelectionModel().selectFirst();

        // Handle selection changes
        comboBox.setOnAction(e -> {
            String selectedOption = comboBox.getSelectionModel().getSelectedItem();
            System.out.println("Selected Option: " + selectedOption);
        });

        StackPane root = new StackPane();
        root.getChildren().add(comboBox);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
