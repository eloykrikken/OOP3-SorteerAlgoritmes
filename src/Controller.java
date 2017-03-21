import java.util.Arrays;

/**
 * Created by Eloy on 6-3-2017.
 */
public class Controller {
    private static Model model = new Model();
    private static Boolean ready = false;
    private static int[] array;
    private QuickSort quicksort = new QuickSort();

    //private static MergeSort mergeSort = new MergeSort();

    public int[] bubbleSort(int n){
        return model.createArray(n);
    }
    public int[] quickSort(int n){
        array = model.createArray(n);
        quicksort.sort(array);
        return array;
    }
    public int[] insertionSort(int n){
        return model.createArray(n);
    }
    public synchronized int[] step(String type, int[] array){
        if(type.equals("Bubble Sort")){
            model.doBubbleSort(array);
        }
        if(type.equals("Quick Sort")){
            quicksort.sortStep();
        }
        if(type.equals("Insertion Sort")){
            model.doInsertionSort(array);
        }
        return array;
    }
    public Boolean checkFinal(){
        if(model.isDone()==true || quicksort.isDone()==true){
            ready = true;
        }
        return ready;
    }


}



