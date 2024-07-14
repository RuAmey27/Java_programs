import java.util.*;
class Areaachal
{
    private int area,length,height,side;
   
    void calarea(int l, int h ){
        int a;
        a=(int) 0.5*l*h;
        
        System.out.println(a);
    }
    void calarea(int s){
        int a;
        a=s*s;
        System.out.println(a);
    }
    public static void main(String args[])
    {

        int l1,h1,s1;
        Scanner sc = new Scanner(System.in);
         int l = sc.nextInt();
         int h = sc.nextInt();
         int s = sc.nextInt();
        Areaachal obj=new Areaachal(l,h);
        obj.calarea(l,h);

        Areaachal obj1=new Areaachal(s);
        obj.calarea(s);
        
    }

}