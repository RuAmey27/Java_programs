import java.util.*;
import java.io.PrintStream;
class Base{
   public int phy;
   public  int chem;
   
    public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
    
    System.out.print("Entre the marks");
    int phy=sc.nextInt();
    int chem=sc.nextInt();
    Derived obj= new Derived();
    
    int marks;
    
    marks=obj.sum();
    
    Print("The sum of marks is"+marks);
    
    }

    
}
class Derived extends Base{
    int sum()
    {
        return phy+chem;
    }
   
}