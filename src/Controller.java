import java.util.Arrays;

/**
 * Created by Eloy on 6-3-2017.
 */
public class Controller {
    private static Model model = new Model();
    private static Boolean ready = false;
    private static int[] array;
    private static int[] lowHigh;
    private QuickSort quicksort = new QuickSort();

    //private static MergeSort mergeSort = new MergeSort();

    public int[] bubbleSort(int n){
        //System.out.println("bubbleSort "+n);
        return model.createArray(n);
    }
    public int[] quickSort(int n){
        //System.out.println("mergeSort");
        array = model.createArray(n);
        //System.out.println(Arrays.toString(array));
        quicksort.sort(array);
        return array;
    }
    public int[] insertionSort(int n){
        //System.out.println("insertionSort");
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
            //System.out.println(ready);
            ready = true;
        }
        return ready;
    }


}



