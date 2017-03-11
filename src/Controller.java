
/**
 * Created by Eloy on 6-3-2017.
 */
public class Controller {
    private static Model model = new Model();
    private static Boolean ready = false;

    public int[] bubbleSort(int n){
        //System.out.println("bubbleSort "+n);
        return model.createArray(n);
    }
    public int[] mergeSort(int n){
        //System.out.println("mergeSort");
        return model.createArray(n);
    }
    public int[] insertionSort(int n){
        //System.out.println("insertionSort");
        return model.createArray(n);
    }
    public int[] step(String type, int[] array){
        if(type.equals("Bubble Sort")){
            array = model.doBubbleSort(array);
        }
        if(type.equals("Merge Sort")){
            //model.doMergeSort();
        }
        if(type.equals("Insertion Sort")){
            //model.doInsertionSort();
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



