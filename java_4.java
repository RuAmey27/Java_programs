/*WAP to find the
1. duplicate character from string
2. Palindrome of string
3. Print ASCII value associated with it.
With and Without In-buit functions 

For string MADAM, RADAR */
import java.util.Scanner;
class java_4{
public static boolean ispalindrome(String s)
{
    for(int i=0; i<s.length()/2;i++)
    {
        int n = s.length();
        if(s.charAt(i)!=s.charAt(n-1-i))
        {
                return false;
        }
    }
    return true;
}
public void ASCII(char c)
{
        
        int b;
        b=c;
        System.out.println(c +" have the ASCII value "+b);
}
public void Duplicate(String s)
{
    String str = s;
    char[] Array = str.toCharArray();
    int count;
    System.out.println("Duplicate Characters:");
    for (int i = 0; i < Array.length; i++) {
        count = 1;
        for (int j = i + 1; j < Array.length; j++) {
            if (Array[i] == Array[j] && Array[i] != ' ') {
                count++;
                Array[j] = '0';
            }
        }
        if (count > 1 && Array[i] != '0') {
            System.out.println(Array[i]);
        }
    }
}
public static void main(String args[])
{
    String Str;
    Scanner sc = new Scanner(System.in) ;
        System.out.println("Entre the string");
        Str=sc.nextLine();
        boolean in;
        in=ispalindrome(Str);
        if(in==true)
        {
            System.out.println("The String is palindrome");
        }
        else
        {
            System.out.println("The String is not palindrome");
        }
        char a;
        System.out.print("Press any key to find the ASCII value of that : ");
        a=sc.next().charAt(0);
        java_4 obj= new java_4();
        obj.ASCII(a);//TO FIND ASCII VALUES
        obj.Duplicate(Str);//TO FIND DUPLICATES FORM STRING
}
}





    
