import java.util.*;
class classwork_1{
    public static int add(int a, int b)
    {
        return a+b;
    }
    public static void main(String args[])
    {
        int num1,num2;
        final int ans;// final is used for comapatibility to store output of static mentod
        Scanner sc= new Scanner(System.in);
        num1=sc.nextInt();
        num2=sc.nextInt();
        ans=add(num1,num2);
        System.out.println(ans);
    }
}