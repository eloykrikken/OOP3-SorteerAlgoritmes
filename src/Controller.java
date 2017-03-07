import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.lang.reflect.Array;

/**
 * Created by Eloy on 6-3-2017.
 */
public class Controller {
    private  View view;
    private Model model;

    public Controller(){

        Model model = new Model();
    }

    public void bubbleSort(int n){
        //System.out.println("bubbleSort "+n);

    }
    public void mergeSort(int n){
        //System.out.println("mergeSort");
    }
    public void insertionSort(int n){
        //System.out.println("insertionSort");
    }

    public Array getArray(){
        return model.retArray();

    }


}



