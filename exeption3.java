import java.io.*;   
class FileNotFoundExceptionExample2   
{  
    //  main() method start  
    public static void main(String[] args)   
    {  
        try {  
           
            File fileObj = new File("Test.txt");  
            // creating an instance of the PrintWriter class by initiating FileWriter class instance  
            PrintWriter printWriter1 = new PrintWriter(new FileWriter(fileObj), true);  
            // print simple text hello world  
            printWriter1.println("Hello world");  
            printWriter1.close();  
            // making Test file read only  
            fileObj.setReadOnly();  
            // try to write data into Test.txt file  
            PrintWriter printWriter2 = new PrintWriter(new FileWriter("Test.txt"), true);  
            printWriter2.println("Hello World");  
            printWriter2.close();  
        }  
        // catching exception thrown by the try block  
        catch(Exception ex) {  
            ex.printStackTrace();  
            System.out.println("Exception handled");
            
        }  
    }  
}  
