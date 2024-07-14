import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void check(int n, int m, int k){
         if(n<=(m-k))
        {
            System.out.println("Yes");
        }
        else
        {
           System.out.println("No"); 
        }
    }
	public static void main (String[] args)
	{
		 int T;
		 Codechef obj=new Codechef();
		Scanner sc= new Scanner(System.in);
		    T=sc.nextInt();
		 int n[]=new int[T];
		 int m[]=new int[T];
		 int k[]=new int[T];
		for(int i=0;i<T;i++)
		{
		  n[i]=sc.nextInt();
		  m[i]=sc.nextInt();
		  k[i]=sc.nextInt();
		}
		for(int i=0;i<T;i++)
		{
		    check(n[i],m[i],k[i]);
		}
	}
}

    

