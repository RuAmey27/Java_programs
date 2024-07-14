import java.util.*;
class ASCIIVAL
{
    public static void main(String args[])
    {
        char a;
        int b;
        Byte c;
        Scanner sc= new Scanner(System.in);
        System.out.print("Press any key to find the ASCII value of that : ");
        a=sc.next().charAt(0);
        b=a;
        
        System.out.println(a +" have the ASCII value "+b);
        System.out.println(a +" have the UNICODE value "+Character.getType(a));
        
    }
}