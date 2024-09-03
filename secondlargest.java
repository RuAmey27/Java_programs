import java.util.List;

/**
 * secondlargest
 */
public class secondlargest {
    public static int secondlargest(List<Integer> arr) //List implementation    
    {
        //For input int[] arr
        //use arr.length instead arr.size() and we directly access arr[i] instead arr.get(i)
        int largest = Integer.MIN_VALUE, slargest = Integer.MIN_VALUE;
        if (arr.size()<2) {
            return -1;
        }// base case array with size less than 2

        if (slargest==Integer.MIN_VALUE) {
            return -1;
        }// base array contain no second largest element

        for (int i = 0; i < arr.size(); i++) {
            int current = arr.get(i);

            if (current > largest) {
                slargest = largest;
                largest = current;
            } else if (current > slargest && current < largest) {
                slargest = current;
            }
        }
        return slargest;
    }

}