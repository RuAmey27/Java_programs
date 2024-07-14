class Employee{
    String name;
    String address;
    String phone;
    int Experience;
    void print()
    {
        System.out.println("name :" +name);
        System.out.println("address :" +address);
        System.out.println("phone :" +phone);
        System.out.println("Experienc:" +Experience);
       
    }
    public static void main(String args[]) {
        Employee obj_0=new Employee();
        obj_0.print();
        Programmer obj=new Programmer("Amey","Umarkhed","7773927352",15,"java") ;   
        Manager obj1=new Manager("Abhishek","Umarkhed","8530822967",15,10) ;
        obj.write_code();
        obj.print();
        obj1.report_project_status();
        obj1.print();
    }
}
class Programmer extends Employee{
    String project_lan;
    Programmer(String a,String b,String c , int i,String d)
    {
        name=a;
        address=b;
        phone=c;
        Experience=i;
        project_lan=d;

    }
    void print()
    {
        System.out.println("project_lan:" +project_lan);
    }

    public void write_code()
    {
        System.out.println("Programmer writing the code");
    }

}
class Manager extends Employee{
    int team_size;
    Manager(String a,String b,String c ,int i, int j)
    {
        name=a;
        address=b;
        phone=c;
        Experience=i;
        team_size=j;
    }
    public void report_project_status()
    {
        System.out.print("Status :-'Project is 50% completed and going on in better way' trust it is managers say");
    }
}
