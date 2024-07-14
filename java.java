import java.util.*;
class Base1{
   public static int phy;
   public static int chem;
public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
    
    System.out.print("Entre the marks");
    phy=sc.nextInt();
    chem=sc.nextInt();
    Derived1 obj= new Derived1();
    
    int marks;
    
    marks=obj.sum();
    
    System.out.println("The sum of marks is"+marks);
    
    }
}
class Derived1 extends Base1{
    int sum()
    {
        return phy+chem;
    }
}
