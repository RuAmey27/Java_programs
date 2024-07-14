import java.util.Scanner;
public class grade
{
    public static void main(String[] args) {
        float Array[][]= new float[20][3];
        Scanner Sc = new Scanner(System.in);
        for(int i=0; i<20;i++)
        {
            for(int j=0;j<3;j++)
            {
                Array[i][j]=Sc.nextFloat();    
            }
        }
        for(int i=0;i<20;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(Array[i][j]+"  ");
            }
        System.out.println();
        }
    }
}
    

