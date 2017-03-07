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
import javafx.scene.shape.Rectangle;
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

                sortStage("Bubble Sort", controller.bubbleSort(Integer.valueOf(nValue.getText())));
            }
        });
        mergeSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sortStage("Merge Sort", controller.mergeSort(Integer.valueOf(nValue.getText())));
            }
        });
        insertionSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sortStage("Insertion Sort", controller.insertionSort(Integer.valueOf(nValue.getText())));
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

    public void sortStage(String sortType, int[] array){
        Stage stage = new Stage();
        HBox hbox = new HBox();
        VBox vbox = new VBox();
        //hbox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        Scene sortScene = new Scene(vbox);


        for(int i=0; i < array.length; i++){
            hbox.getChildren().add(new Rectangle(i*10,vbox.getHeight(),10,20*i));

        }

        Button nextStep = new Button("Next Step");

        vbox.getChildren().addAll(hbox, nextStep);
        stage.setTitle(sortType);
        stage.setScene(sortScene);
        stage.show();
    }
}

