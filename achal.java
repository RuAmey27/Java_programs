import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class Achal
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
        int i=0;
        int []X= new int[100];
        int []A= new int[100];
        int []Y= new int[100];
		while(T!=0){
		     X[i]=sc.nextInt();
		     Y[i]=sc.nextInt();
		     A[i]=sc.nextInt();
		    if(A[i]>=X[i]&&A[i]<(Y[i])){
		        System.out.print("YES");
		    }
		    else{
		    System.out.print("NO");
		    }
		i++;
		}
	}
   
}