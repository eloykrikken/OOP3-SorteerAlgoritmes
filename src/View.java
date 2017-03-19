import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.application.Application;
import javafx.application.Platform;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * Created by Eloy on 6-3-2017.
 */
public class View extends Application {
    private static Controller controller;
    private static Boolean finished = false;
    private static ScheduledExecutorService executor;
    private static int[] array;
    private static String sortType;
    private static Rectangle[] staafarray;
    private static BorderPane borderPane = new BorderPane();
    private static Boolean done = false;
    private static Lock lock = new ReentrantLock();
    private static int MAX_THREADS;

    public void draw(){
        Application.launch();
    }

    public void start(Stage primaryStage){
        controller = new Controller();

        //BorderPane borderPane = new BorderPane();
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        Scene scene = new Scene(borderPane);

        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        TextField nValue = new NumberTextField();
        Label nLabel = new Label("Enter the Value of N: ");
        Button bubbleSort = new Button("BubbleSort");
        Button quickSort = new Button("QuickSort");
        Button insertionSort = new Button("InsertionSort");


        bubbleSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                array = controller.bubbleSort(Integer.valueOf(nValue.getText()));
                sortType = "Bubble Sort";
                sortStage(sortType, array);
                MAX_THREADS = (int)Math.pow(Integer.valueOf(nValue.getText()) , 2);
                //executor = //hier verder
                primaryStage.close();
            }
        });
        quickSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                array = controller.quickSort(Integer.valueOf(nValue.getText()));
                sortType = "Quick Sort";
                sortStage(sortType, array);
                MAX_THREADS = (int)Math.pow(Integer.valueOf(nValue.getText()) , 2);
                primaryStage.close();
            }
        });
        insertionSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                array = controller.insertionSort(Integer.valueOf(nValue.getText()));
                sortType = "Insertion Sort";
                sortStage(sortType, array);
                MAX_THREADS = (int)Math.pow(Integer.valueOf(nValue.getText()) , 2);
                primaryStage.close();
            }
        });


        vbox.getChildren().addAll(bubbleSort, quickSort, insertionSort);
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
        staafarray = new Rectangle[array.length];

        System.out.println(Arrays.toString(array));

        drawStaaf(array, staafarray, borderPane);

        Button nextStep = new Button("Next Step");
        nextStep.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                drawStaaf(controller.step(sortType, array), staafarray, borderPane);
                testFinished();
            }
        });
        Button autoStep = new Button("Automatic");
        autoStep.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for(int i = 0; i<MAX_THREADS; i++) {
                    executor.schedule(new Autostep(), 1000, TimeUnit.MILLISECONDS);
                    testFinished();
                }
                executor.shutdownNow();
            }
        });

        stage.setOnCloseRequest(event -> executor.shutdownNow());
        vbox.getChildren().addAll(borderPane, nextStep, autoStep);
        stage.setTitle(sortType);
        stage.setScene(sortScene);
        stage.show();


    }

    public static synchronized void drawStaaf(int[] array, Rectangle[] staafarray, BorderPane borderPane){
        System.out.println("Teken");
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

    public static synchronized void testFinished(){
        //System.out.println("iets");
        if(controller.checkFinal()==true || done==true){
            executor.shutdownNow();
            Stage finished = new Stage();
            BorderPane pane = new BorderPane();

            pane.setCenter(new Text("The sorting is done"));
            Button exit = new Button("OK");
            exit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executor.shutdownNow();
                    Platform.exit();
                }
            });
            pane.setBottom(exit);
            pane.setAlignment(exit,Pos.BOTTOM_CENTER);

            Scene donescene = new Scene(pane, 200, 100);
            finished.setResizable(false);
            finished.setScene(donescene);
            finished.show();
        }

    }

    private static class Autostep implements Runnable {
        public void main(){
            Thread t= new Thread(this);
            t.start();
        }
        public void run(){
            lock.lock();
            try {
                //sleep(1000);
                System.out.println("geslapen");
                testFinished();
                System.out.println("Finish getest");
                drawStaaf(controller.step(sortType, array), staafarray, borderPane);
                System.out.println("getekend");

            } catch(Exception e){
                System.out.println("iets ging fout");
            }
            //System.out.println(done);

            lock.unlock();

        }
    }


}


