import java.util.Scanner;

class Employee {
    protected String name;
    protected String address;
    protected String phoneNumber;
    protected int experience;

    public Employee(String name, String address, String phoneNumber, int experience) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
    }
}

class Programmer extends Employee {
    protected String programmingLanguage;

    public Programmer(String name, String address, String phoneNumber, int experience, String programmingLanguage) {
        super(name, address, phoneNumber, experience);
        this.programmingLanguage = programmingLanguage;
    }

    public void writeCode() {
        System.out.println("Writing code in " + programmingLanguage);
    }
}

class Manager extends Employee {
    protected int teamSize;
    protected String reportProjectStatus;

    public Manager(String name, String address, String phoneNumber, int experience, int teamSize, String reportProjectStatus) {
        super(name, address, phoneNumber, experience);
        this.teamSize = teamSize;
        this.reportProjectStatus = reportProjectStatus;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("Experience: " + experience);
        System.out.println("Team size: " + teamSize);
        System.out.println("Report project status: " + reportProjectStatus);
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = input.nextLine();

        System.out.print("Enter employee address: ");
        String address = input.nextLine();

        System.out.print("Enter employee phone number: ");
        String phoneNumber = input.nextLine();

        System.out.print("Enter employee experience: ");
        int experience = input.nextInt();

        Programmer programmer = new Programmer(name, address, phoneNumber, experience, "Java");
        programmer.writeCode();

        System.out.print("Enter manager team size: ");
        int teamSize = input.nextInt();

        input.nextLine(); // consume the remaining newline character

        System.out.print("Enter manager report project status: ");
        String reportProjectStatus = input.nextLine();

        Manager manager = new Manager(name, address, phoneNumber, experience, teamSize, reportProjectStatus);
        manager.displayInfo();

        input.close();
    }
}
