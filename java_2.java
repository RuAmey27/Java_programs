class javacl{
    int a;
    int b;
    javacl()
    {
        System.out.println("Executing the default constructor");
    }
    javacl(int i, int j)
    {
        a=i;
        b=j;
        System.out.println("Executing the parameterized constructor");
    }
    javacl(javacl object)
    {
        a=object.a;
        b=object.b;
        System.out.println("Executing the copy constructor");
    }
    void print()
    {
        System.out.println("a="+a);
        System.out.println("b="+b);
    }
    public static void main(String args[])
    {
        javacl sc= new javacl();
        sc.print();// default constructor call
        javacl obj= new javacl(15,16);//parameterized constructor call
        System.out.println("The value of a & b of object obj" );
        obj.print();//output data
        javacl nobj= new javacl(obj);//copy constructor call
        System.out.println("The value of a & b after copy constructor use value of a & b in object nobj" );
        nobj.print();

    }
}
/*"C:\Users\hp\Pictures\Screenshots\Screenshot_20230203_173631.png"*/
