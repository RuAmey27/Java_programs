import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Amey {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        int t, iniamt, needy, need;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t != 0) {
            needy = sc.nextInt();
            iniamt = sc.nextInt();
            while (needy != 0) {
                need = sc.nextInt();
                if (iniamt >= need) {
                    iniamt = iniamt - need;
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
                needy--;
            }
            t--;
        }
    }

    pr
}
