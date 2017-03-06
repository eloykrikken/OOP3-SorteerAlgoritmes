import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Eloy on 6-3-2017.
 */
public class View extends Application {

    public void start(Stage primaryStage){

        BorderPane borderPane = new BorderPane();
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        Scene scene = new Scene(borderPane);

        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        TextField nValue = new NumberTextField();
        Label nLabel = new Label("Enter the Value of N: ");
        Button bubbleSort = new Button("BubbleSort");
        Button mergeSort = new Button("MergeSort");
        Button insertionSort = new Button("InsertionSort");


        bubbleSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.bubbleSort();
            }
        });
        mergeSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { controller.mergeSort(); }
        });
        insertionSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { controller.insertionSort(); }
        });

        vbox.getChildren().addAll(bubbleSort, mergeSort, insertionSort);
        hbox.getChildren().addAll(nLabel,nValue);
        borderPane.setTop(hbox);
        borderPane.setCenter(vbox);

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sorting");
        primaryStage.show();
    }
}

