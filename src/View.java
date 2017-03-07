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

    public void draw(){
        Application.launch();
    }

    public void start(Stage primaryStage){
        Controller controller = new Controller();

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
                controller.bubbleSort(Integer.valueOf(nValue.getText()));
                sortStage("Bubble Sort");
            }
        });
        mergeSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.mergeSort(Integer.valueOf(nValue.getText()));
                sortStage("Merge Sort");
            }
        });
        insertionSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.insertionSort(Integer.valueOf(nValue.getText()));
                sortStage("Insertion Sort");
            }
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

    public void sortStage(String sortType){
        Stage stage = new Stage();
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        Scene sortScene = new Scene(vbox, 300, 400);

        Button nextStep = new Button("Next Step");

        vbox.getChildren().addAll(nextStep);
        stage.setTitle(sortType);
        stage.setScene(sortScene);
        stage.show();
    }
}

