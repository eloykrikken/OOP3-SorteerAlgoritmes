import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Arrays;

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
        BorderPane borderPane = new BorderPane();
        VBox vbox = new VBox(20);

        vbox.setAlignment(Pos.CENTER);
        Scene sortScene = new Scene(vbox);
        Rectangle[] staafarray = new Rectangle[array.length];

        System.out.println(Arrays.toString(array));

        drawStaaf(array, staafarray, borderPane);



        Button nextStep = new Button("Next Step");

        vbox.getChildren().addAll(borderPane, nextStep);
        stage.setTitle(sortType);
        stage.setScene(sortScene);
        stage.show();
    }

    public void drawStaaf(int[] array, Rectangle[] staafarray, BorderPane borderPane){
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.BOTTOM_LEFT);

        GridPane arraybox = new GridPane();
        arraybox.setMinSize(60,20);
        arraybox.setAlignment(Pos.CENTER);

        ColumnConstraints width = new ColumnConstraints(20);

        for(int i=0; i < array.length; i++){

            Rectangle staaf = new Rectangle(i*20,0,20,10*array[i]);
            Label label = new Label(Integer.toString(array[i]));
            staaf.setFill(Color.AQUA);
            staaf.setStroke(Color.BLACK);

            staafarray[i] = staaf;

            hbox.getChildren().add(staaf);
            arraybox.getColumnConstraints().add(width);
            arraybox.add(label, i, 0);


        }
        borderPane.setCenter(hbox);
        borderPane.setBottom(arraybox);

    }
}

