import java.util.Scanner;
class leetcode {
    public static int jump(int[] nums) {
        int n=nums.length;
        int i=0;
        int initial=nums[0];
        while(initial!=nums[n-1])
        {
            initial=nums[initial];
            i++;
        }
        return i;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int j = 5;
        int[] arr=new int[j];
        for (int i = 0; i < j; i++) {
            arr[i]=sc.nextInt();
        }
        int result=jump(arr);
        System.out.print(result);
    }
}
