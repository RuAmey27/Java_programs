import java.util.*;
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int n= nums.length;
         int[]two=new int[2];
        for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(nums[i]+nums[j]==target&&i!=j)
                    {
                        two[0]=i;
                        two[1]=j;
                    }
                }
            }
        return two;
        }
                public static void main(String args[])
                {
    
                    int n;
                    Scanner sc=new Scanner(System.in);
                    System.out.println("Entre the array size");
                    n=sc.nextInt();
                    int nums[]=new int[n];
                    int Sum[]=new int[2];
                    int target;
    
                    System.out.println("Entre the array ");
                    for(int i=0;i<n;i++)
                    {
                        nums[i]=sc.nextInt();
                    }
                    System.out.println("Entre the targrt");
                    target=sc.nextInt();
                    Sum=twoSum(nums,target);
                    System.out.println(Sum[0]+","+Sum[1]);
                    
                }

    }
    