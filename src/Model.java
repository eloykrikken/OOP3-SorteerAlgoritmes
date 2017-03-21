

/**
 * Created by Eloy on 6-3-2017.
 */
public class Model {
    private static int i = 0;
    private static int j;
    private static Boolean done = false;
    private static int noSwap = 0;

    public int[] createArray(int n){
        int[] array;
        array = new int[n];

        for(int i=0; i<n; i++){
            int randnum = (int)(Math.random() * (n-1) + 1);
            array[i] = randnum;
        }
        return array;
    }

    public int[] doBubbleSort(int[] array){
        try {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
            else{
                noSwap++;
            }
            i++;

        }
        catch (Exception e){
            i = 0;
            noSwap = 0;
        }
        if(noSwap==array.length - 1){
            done = true;
        }

        return array;

    }

    public int[] doInsertionSort(int[] array){
        int temp;

        if(i<(array.length-1)) {
            if (array[i] > array[i + 1]) {
                for(j=i; j>=0; j--){
                    if (array[j] > array[j + 1]) {
                        temp = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = temp;
                    }
                    else{
                        break;
                    }
                }

            }
            i++;
        }
        else {
            done=true;
        }
        return array;
    }


    public Boolean isDone(){
        return done;
    }


}
