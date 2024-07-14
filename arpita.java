import java.util.Scanner;
class Triangle{
    private int b;
    private int h;
    public void setdata(int base,int height)
    {
        this.b= base;
        this.h=height;
    }

    public void area(){
        System.out.println("Area Of triangle:    "+0.5*b*h);
    }
}
class Square extends Triangle{
    private int side,side1;
    public void setdata(int side,int side1)
    {
        this.side=side;
        this.side1=side1;
    }
    public void area(){
        System.out.println("Area Of Squrare: "+side*side1);
    }
}
public class Demo1 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Base and height : ");
        int base = s.nextInt();
        int height  = s.nextInt();
        System.out.println("Enter Side of Square : ");
        int side = s.nextInt();
        Triangle obj = new Triangle();
        obj.setdata(base,height);
        obj.area();
        Square obj1 = new Square();
        obj1.setdata(side,side);
        obj1.area();
}
}


