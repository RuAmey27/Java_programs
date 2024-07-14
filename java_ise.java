import java.util.*;
class Base{
    int phy;
    int chem;
    void in(int i,int j)
    {
        phy=i;
        chem=j;
    }
    public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
    int a,b;
    System.out.print("Entre the marks");
    a=sc.nextInt();
    b=sc.nextInt();
    DER obj= new DER();
    obj.in(a,b);
    int marks;
    int sub;
    marks=obj.sum();
    sub=obj.sub();
    System.out.println("The sum of marks is"+marks);
    System.out.println("The sub of marks is"+sub);
    }
}
class DER extends Base{
    int sum()
    {
        return phy+chem;
    }
    int sub()
    {
        return phy-chem;
    }
}
