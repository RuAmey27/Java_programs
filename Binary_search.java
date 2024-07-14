import java.util.*;
class Binary_Search{
    /**
     * @param arr
     * @param i
     * @return
     */
    int Search_key(int []arr,int i) {
    int n= arr.length;
    int first=0;
    int last=n-1;
    int middle=(first+last)/2;
    while(first<=last)
    {
        if(arr[middle]<i)
            first=middle+1;
        else
        if(arr[middle]==i)
            {
            return middle+1;
            break;
            } 
            
        else    
                last=middle-1;
        
    middle=(first+last)/2;
    }
        if(first>last)
            return 0;
    }
   

    public static void main(String args[])
    {
       
        int pos;
        int key=5;
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        Binary_Search obj=new Binary_Search();
        pos=obj.Search_key(arr,key);
        System.out.println(pos);

}
}