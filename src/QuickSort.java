import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Eloy on 14-3-2017.
 */
public class QuickSort {
    private int[] array;
    private static Stack<Integer> stack = new Stack<>();
    private static Boolean done = false;

    public void sort(int[] array) {
        System.out.println(Arrays.toString(array));
        this.array = array;
        stack.add(array.length - 1);
        stack.add(0);
    }

    private int[] quickSort(int low, int high) {
        int i = low;
        int j = high;
        int pivot = array[(int) (Math.random() * high)];
        while (i <= j) {

            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                i++;
                j--;
            }

        }
        if (low < j) {
            stack.add(j);
            stack.add(low);
        }
        if (i < high) {
            stack.add(high);
            stack.add(i);
        }
        return array;

    }

    public void sortStep() {
        try {
            int x = stack.pop();
            int y = stack.pop();

            quickSort(x, y);
        }
        catch (Exception e){
            done = true;
        }
    }

    public Boolean isDone(){
        return done;
    }

}
