
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Myframe extends JFrame implements ActionListener{
JLabel I1,I2,I3;
JTextField tf1, tf2, tf3;
JButton b1, b2;
private JTextField txtInput;

public Myframe()
{
    setTitle("Simple Calculator");

    JTextField txtInput = new JTextField(20);
   
    txtInput.setEditable(false);
    txtInput.setHorizontalAlignment(JTextField.RIGHT);
I1= new JLabel("Enter First Integer Number");

I2= new JLabel("Enter Second Integer Number");

I3 = new JLabel("Result");

tf1 = new JTextField(20);

tf2 = new JTextField(20);

tf3= new JTextField(20);

b1 = new JButton("Add");

b2 = new JButton("Clear");
b1.addActionListener(this);
b2.addActionListener(this);
JPanel panel1 = new JPanel();
panel1.setLayout(new GridLayout(4, 2));
panel1.add(I1);
panel1.add(tf1);
panel1.add(I2);
panel1.add(tf2);
panel1.add(I3);
panel1.add(tf3);
panel1.add(b1);
panel1.add(b2);
add(txtInput, BorderLayout.NORTH);
        add(panel1, BorderLayout.CENTER);

        // Set frame properties
        setSize(300, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setVisible(true);

//setting Frame object properties setTitle("Addition window"); setSize(500,500); setLayout(new FlowLayout());
System.out.println("Frame object is created");
}

/**
 * @param ae
 */
public void actionPerformed(ActionEvent ae)
{
//returns button name that has been clicked by end-user 
String buttonName =ae.getActionCommand();
String s1 = tf1.getText();
String s2 = tf2.getText();
int n1= Integer.parseInt(s1); int n2 = Integer.parseInt(s2);
if(ae.getSource()==b2){
    buttonName.equals("add");

int n3 = n1+n2;
tf3.setText("+n3");
}
else{
    buttonName.equals("Clear");
//setting text fields with empty strings
tf1.setText("");
tf2.setText("");
tf3.setText("");
}



}
public static void main(String[] args) {
   new Myframe();
}
}
