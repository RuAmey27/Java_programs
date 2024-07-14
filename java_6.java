interface Area{
 abstract  double area();
}
class java_6 implements Area{
public static void main(String args[])
{
    double area;
    java_6 obj=new Circle(10);
    java_6 obj2=new Rectangle(10,20);
    java_6 obj3=new Triangle(12,15);
    System.out.println(area=obj.area());
    System.out.println(area=obj2.area());
    System.out.println(area=obj3.area());
}
}
class Rectangle extends java_6{
    double a;
    double l;
    double b;
    Rectangle(double i, double j){
        l=i;
        b=j;
    }

    @Override
    public double area() {
        // TODO Auto-generated method stub
        System.out.print("Rectangle: ");
        a=l*b;
        return a;
    }
    
}
class Circle extends java_6{
    double r;
    double a;
    Circle(int i){
        r=i;
    }
    @Override
    public double area() {
        System.out.print("circle: ");
        // TODO Auto-generated method stub
        a=3.14*r*r;
        return a;
    }
    
}
class Triangle extends java_6{
    double h;
    double b;
    double a;
    Triangle(double i, double j){
        h=i;
        b=j;
    }
    @Override
    public double area() {
        System.out.print("Triangle: ");
        // TODO Auto-generated method stub
        a=0.5*b*h;
        return b;
    }

}

    

