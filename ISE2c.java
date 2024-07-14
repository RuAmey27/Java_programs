import java.util.Scanner;

public class ISE2c {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int m,n;
        m=sc.nextInt();
        n=sc.nextInt();

        int[][]A=new int[m][n];
        int[][]B=new int[m][n];
        int[][]C=new int[m][n];
        
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j]= sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j]= sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j]=A[i][j]+B[i][j];
                System.out.println(C[i][j]+"    ");
            }
            System.out.println("\n");
        }

    }

}