/*write a simple program for n students with class name as SIMPLE
 * Take input as Name And Marks of M subject. method name as Calculate total and calculate average shows 
 * total and avg of marks
 * print total and avgerage in main function. Save total and avg so as it can be reproduced afterwards.
 */
import java.util.*;

class SIMPLE
{
    
    String name;
    int Subjects;
    Integer[] marks_of_Subjects;
    void coSIMPLE(String s, int M) {
        name=s;
        Subjects=M;
        System.out.println("Entre the marks for given subjects");
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<M;i++)
        {
            marks_of_Subjects[i]=sc.nextInt();
        }
    }
    public static int Calculate_total(int []arr) {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+arr[i];
        }
        return sum;
    }
    public static int Calculate_avg(int []arr) {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+arr[i];
        }
        return sum/n;
    }
   
    public static void main(String ars[])
    {
        Scanner sc=new Scanner(System.in);
        int n;
        String []na_me;
        int[] no_of_sub;
        System.out.println("Entre the number of students");
        n=sc.nextInt();
        na_me=new String[n];
        no_of_sub=new int[n];
        
        while(n!=0)
        {
            int i=n-1;
            System.out.println("Entre the name of students");
            na_me[i]=sc.nextLine();
            System.out.println("Entre the number of students");
            no_of_sub[i]=sc.nextInt();
            SIMPLE[] obj= new SIMPLE[n];
            sc.close();
            obj[i].coSIMPLE(na_me[i],no_of_sub[i]);
            n--;
        }
    } 
 ;
}
