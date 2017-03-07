import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Eloy on 6-3-2017.
 */
public class Model {
    private static int[] Narray;

    public static void Model(){

    }



    public int[] createArray(int n){
        //System.out.println(" "+n);

        int[] Narray;
        Narray = new int[n];

        for(int i=0; i<n; i++){
            int randnum = (int)(Math.random() * n);
            Narray[i] = randnum;
        }
        //System.out.println(Arrays.toString(Narray));

        return Narray;
    }

    public void doBubbleSort(int[] Narray){
        //System.out.println(Arrays.toString(Narray));

        

    }


}
