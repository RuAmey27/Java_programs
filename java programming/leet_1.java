import java.util.Scanner;
class leetcode {
    public  int jump(int[] nums) {
        int n=nums.length;
        int i=0;
        int initial=nums[0];
        while(initial!=nums[n-1])
        {
            initial=nums[i+nums[0]];
            i++;
        }
        i--;
        return i;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int j = 5;
        int i=0;
        int[] arr=new int[j];
        System.out.println("Entre array");
        while(i<j) {

            arr[i]=sc.nextInt();
            i++;
        }
        leetcode obj=new leetcode();
        
        int result=obj.jump(arr);
        System.out.print(result);
    }
}
