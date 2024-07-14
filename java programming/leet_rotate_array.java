import java.util.Scanner;
class PrintArray {

    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int[] ans= new int[n];
        int i=1;
        int last=nums[n-1];
           while(k!=0){
            ans[0]=last;
            while(i<n)
            {
                ans[i]=nums[i-1];
                
            }
            last=ans[n-1];
            k--;
           }

    
        for(i=0;i<n;i++)
        {
            nums[i]=ans[i];
        }
        System.out.println("The array is: ");
        for ( i = 0; i <n ; i++) {
            System.out.print(nums[i]);
        }
        }


    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6,7};
        
        
        PrintArray obj= new PrintArray();
        obj.rotate(arr,3);
        
        
    }
}
