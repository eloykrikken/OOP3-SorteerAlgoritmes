
/**
 * Created by Eloy on 6-3-2017.
 */
public class Controller {
    private static Model model = new Model();
    private static Boolean ready = false;
    private static int[] array;
    private static int[] lowHigh;

    //private static MergeSort mergeSort = new MergeSort();

    public int[] bubbleSort(int n){
        //System.out.println("bubbleSort "+n);
        return model.createArray(n);
    }
    public int[] quickSort(int n){
        //System.out.println("mergeSort");
        array = model.createArray(n);
        //lowHigh = mergeSort.start(array);
        return array;
    }
    public int[] insertionSort(int n){
        //System.out.println("insertionSort");
        return model.createArray(n);
    }
    public int[] step(String type, int[] array){
        if(type.equals("Bubble Sort")){
            model.doBubbleSort(array);
        }
        if(type.equals("Quick Sort")){
            //mergeSort.quickSort(lowHigh[0], lowHigh[1]);
        }
        if(type.equals("Insertion Sort")){
            model.doInsertionSort(array);
        }
        return array;
    }
    public Boolean checkFinal(){
        if(model.isDone()==true){
            //System.out.println(ready);
            ready = true;
        }
        return ready;
    }


}



