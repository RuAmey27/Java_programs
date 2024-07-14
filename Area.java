import java.util.*;
class Area{
    private int area,length,height,side;
    Area(int l, int h ){
        length=l;
        height=h;
    }
    Area(int s){
        side=s;
    }
    void set(int a){
        area=a;
    }
    void calarea(int l, int h ){
        int a;
        a=(1/2)*l*h;
        
        System.out.println(a);
    }
    void calarea(int s){
        int a;
        a=s*s;
        System.out.println(a);
    }
    public static void main(String args[])
    {

        int l,h,s;
        Area obj=new Area(l,h);
        obj.calarea(l,h);

        Area obj1=new Area(s);
        obj.calarea(s);
        
    }

}