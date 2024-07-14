class classwork_2
{
    int a,b;
    classwork_2(int p, int q)
    {
        a=p;
        b=q;
    }
    void add()
    {
        
        System.out.println(a+b);
    }
    public static void main(String args[])
    {
        classwork_2 obj=new classwork_2(10,20);
        obj.add();
    }
}