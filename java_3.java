class java_3 {
    int area(int r)
    {
        int ans =(22/7)*r*r;
        return ans;
        //System.out.println("The area of circle is"+ 3.14*i*i);
    };
    double area(double b,double h)
    {
        double ans = 0.5*b*h;
       return ans;
        //System.out.println("The area of circle is"+ 0.5*i*j);
    };
    public static void main(String args[])
    {
        double areat;
        int areac;
        java_3 obj=new java_3();
        java_3 obj2=new java_3();
        areac=obj.area(15);
        areat=obj2.area(30.25,15.01);//same method area is overloaded to calculate different figure's area
        System.out.println("The area of the triangle is "+ areat);
        System.out.println("The area of the circle is "+ areac);
    }

}
