import java.util.*;
public class arrayadd
{
    public static void main(String args[])
    {
        int list[]= new int[5];
        int listtwo[]= new int[5];
        int listthree[]= new int[5];
        Scanner sc= new Scanner(System.in);
        System.out.println("Entre list one");
        for(int i=0;i<5;i++)
        {
            list[i]=sc.nextInt();
        }
        System.out.println("Entre list two");
        for(int i=0;i<5;i++)
        {
            listtwo[i]=sc.nextInt();
        }
        for(int i=0;i<5;i++)
        {
            System.out.print(list[i]);
        }
        for(int i=0;i<5;i++)
        {
            System.out.print(listtwo[i]);
        }
        System.out.println("Entre list addtion");
        for(int i=0;i<5;i++)
        {
            listthree[i]=list[i]+listtwo[i];
            System.out.println(listthree[i]);
        }
    }
}