import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CalculatorGUI extends JFrame implements ActionListener {
    private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private JButton btnAdd, btnSubtract, btnMultiply, btnDivide, btnEquals, btnClear;
    private JTextField txtInput;

    private double num1 = 0, num2 = 0, result = 0;
    private String operator = "";

    /**
     * 
     */
    public CalculatorGUI() {
        setTitle("Simple Calculator");

        // Create the input text field
        txtInput = new JTextField(20);
        txtInput.setEditable(false);
        txtInput.setHorizontalAlignment(JTextField.RIGHT);

        // Create the number buttons
        btn0 = new JButton("0");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");

        // Create the operator buttons
        btnAdd = new JButton("+");
        btnSubtract = new JButton("-");
        btnMultiply = new JButton("*");
        btnDivide = new JButton("/");
        btnEquals = new JButton("=");
        btnClear = new JButton("C");

        // Set the action commands for the buttons
        btn0.setActionCommand("0");
        btn1.setActionCommand("1");
        btn2.setActionCommand("2");
        btn3.setActionCommand("3");
        btn4.setActionCommand("4");
        btn5.setActionCommand("5");
        btn6.setActionCommand("6");
        btn7.setActionCommand("7");
        btn8.setActionCommand("8");
        btn9.setActionCommand("9");
        btnAdd.setActionCommand("+");
        btnSubtract.setActionCommand("-");
        btnMultiply.setActionCommand("*");
        btnDivide.setActionCommand("/");
        btnEquals.setActionCommand("=");
        btnClear.setActionCommand("C");

        // Add the action listeners to the buttons
        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btnAdd.addActionListener(this);
        btnSubtract.addActionListener(this);
        btnMultiply.addActionListener(this);
        btnDivide.addActionListener(this);
        btnEquals.addActionListener(this);
        btnClear.addActionListener(this);

        // Create the layout
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 4));
        panel1.add(btn7);
        panel1.add(btn8);
        panel1.add(btn9);
        panel1.add(btnDivide);
        panel1.add(btn4);
        panel1.add(btn5);
        panel1.add(btn6);
        panel1.add(btnMultiply);
        panel1.add(btn1);
        panel1.add(btn2);
        panel1.add(btn3);
        panel1.add(btnSubtract);
        panel1.add(btn0);
        panel1.add(btnClear);
        panel1.add(btnEquals);
        panel1.add(btnAdd);

        // Add the components to the frame
        add(txtInput, BorderLayout.NORTH);
        add(panel1, BorderLayout.CENTER);

        // Set frame properties
        setSize(300, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
String input = e.getActionCommand();

if (input.equals("C")) {
    // Clear the input field and reset variables
    txtInput.setText("");
    num1 = 0;
    num2 = 0;
    operator = "";
    result = 0;
} 
else if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
    // Set the operator
    operator = input;
    // Save the first number
    num1 = Double.parseDouble(txtInput.getText());
    // Clear the input field
    txtInput.setText("");
} else if (input.equals("=")) {
    // Calculate the result
    num2 = Double.parseDouble(txtInput.getText());}
    
        if (input.equals("C")) {
            // Clear the input field and reset variables
            txtInput.setText("");
            num1 = 0;
            num2 = 0;
            operator = "";
            result = 0;
        } else if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
            // Set the operator
            operator = input;
            // Save the first number
            num1 = Double.parseDouble(txtInput.getText());
            // Clear the input field
            txtInput.setText("");
        } 
        {
            // Append the number to the input field
            txtInput.setText(txtInput.getText() + input);
        }
        input.equals("="){
            // Calculate the result
            num2 = Double.parseDouble(txtInput.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            // Display the result
            txtInput.setText(String.valueOf(result));
            // Reset variables
            num1 = result;
            num2 = 0;
            operator = "";
            result = 0;
        } 
    
        
    }

    
    

    
    

public static void main(String[] args) {
CalculatorGUI calc = new CalculatorGUI();
}
}
