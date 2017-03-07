import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.lang.reflect.Array;

/**
 * Created by Eloy on 6-3-2017.
 */
public class Controller {
    private static Model model = new Model();

    public Controller(){

    }

    public void bubbleSort(int n){
        //System.out.println("bubbleSort "+n);
        model.doBubbleSort(model.createArray(n));

    }
    public void mergeSort(int n){
        //System.out.println("mergeSort");
        model.createArray(n);
    }
    public void insertionSort(int n){
        //System.out.println("insertionSort");
        model.createArray(n);
    }


}



