import java.swing.*;
abstract class shape{
    void display()
    {
        System.out.println("i am the base class");
    }
    abstract int area(int length,int breadth);



}
class  rectangle extends shape{
    @Override
    int area(int length,int Breadth){
        return length*Breadth;
    }
}
class triagle extends shape{
    int area(int length,int Breadth)
    {

        return (1/2*length*Breadth);
    }
}
class cirle extends shape{
    @Override
    int area(int length, int breadth) {
        return (22/7)*length*length;
    }
}
public class javapr {
    public static void main(String[] args) {
        triagle sc=new triagle();
        System.out.println( sc.area(5,6));
        rectangle scc=new rectangle();
        System.out.println(scc.area(5,6));
         cirle s=new cirle();
        System.out.println(s.area(5,6));
    }
}
