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

    public int[] bubbleSort(int n){
        //System.out.println("bubbleSort "+n);
        int[] array = model.createArray(n);
        model.doBubbleSort(array);
        return array;

    }
    public int[] mergeSort(int n){
        //System.out.println("mergeSort");
        int[] array = model.createArray(n);
        model.doBubbleSort(array);
        return array;
    }
    public int[] insertionSort(int n){
        //System.out.println("insertionSort");
        int[] array = model.createArray(n);
        model.doBubbleSort(array);
        return array;
    }


}



