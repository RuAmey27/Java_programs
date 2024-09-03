public class inplacereverse {
    public static String toStringarr(int[] arr) {
        StringBuilder a=new StringBuilder();
        for (int i : arr) {
            a.append(i);
        }
        return a.toString();
    }// to see the result avoids repetitive code


    public static void swap(int[] input, int i, int j){
        int temp = input[i];
        input[i]=input[j];
        input[j]=temp;
    }// swap function

    public static void reverse(int[] arr){
        int i=0; // pointer form starting side 
        int l=arr.length-1;// pointer from ending side

        while (i<=l) {
            swap(arr,i,l);
            i++;
            l--;
            
        }
    }// reverse logic
    public static void main(String []args){

        int[] arr={2,3,5,6,7};
        System.out.println(toStringarr(arr));
        reverse(arr);
        int at= Integer.parseInt(toStringarr(arr));
        System.out.println(at-2);
        System.out.println(toStringarr(arr));

    }
}
