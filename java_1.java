import java.util.Scanner;
class calculator{
    public static void main (String args[])
    {
        int a, b;
        float f;
        char c;
        System.out.println("Entre the first number");
        Scanner sc= new Scanner(System.in);
        a=sc.nextInt();
        System.out.println("Entre the second number");
        b=sc.nextInt();
        System.out.println("Entre the operator required to perform the operation");
        c=sc.next().charAt(0);
        switch (c) {
            case '+':f=a+b;
                System.out.println("The addition is "+ f);
                break;
            case '-':f=a-b;
                System.out.println("The subtraction is "+ f);
                break;
            case '*':f=a*b;
                System.out.println("The multiplication is "+ f);
                break;
            case '/':f=a/b;
                System.out.println("The division is "+ f);
                break;
            case '%':f=a%b;
                System.out.println("The modolus is "+ f);
                break;
            default:
                System.out.println("Please Entre the valid operator");
                break;
        }
    }
}