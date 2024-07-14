import java.awt.";
{
public class MyFrame extends Frame
Label 11, 12, 13;
TextField tf1, tf2, tf3; Button b1, b2;
MyFrame()
{11= new Label("Enter First Integer Number");

12= new Label("Enter Second Integer Number");

13 = new Label("Result");

tf1 = new TextField(20);

tf2 = new TextField(20);

tf3= new TextField(20);

b1 = new Button("Add");

b2 = new Button("Clear");

//setting Frame object properties setTitle("Addition window"); setSize(500,500); setLayout(new FlowLayout());


}
public void actionPerformed(ActionEvent ae){

//reading textfields data

String $1 = tf1.getText();

String $2= tf2.getText();

//converting string form to int form int n1= Integer.parseInt(s1); int n2 = Integer.parseInt(s2);

//adding given two numbers int n3 = n1+n2;

//converting int form to string form, and setting result to Result textfield tf3.setText("+n3);

}

public static void main(String[] args) { MyFrame f = new MyFrame();
}
System.out.println("Frame object is created");
}