import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class java_8 extends JFrame implements ActionListener {
    private JLabel dollarLabel, rupeeLabel;
    private JTextField dollarField, rupeeField;
    private JButton convertButton;

     public java_8() {
        super("java_8");

        // Create Swing components
        dollarLabel = new JLabel("Enter dollars:");
        rupeeLabel = new JLabel("Converted rupees:");
        dollarField = new JTextField(10);
        rupeeField = new JTextField(10);
        rupeeField.setEditable(false);
        convertButton = new JButton("Convert");

        // Add components to content pane
        Container c = getContentPane();
        c.setLayout(new GridLayout(3, 2));
        c.add(dollarLabel);
        c.add(dollarField);
        c.add(rupeeLabel);
        c.add(rupeeField);
        c.add(convertButton);

        // Add action listener to convert button
        convertButton.addActionListener(this);
    }

    // Action performed when convert button is pressed
    public void actionPerformed(ActionEvent event) {
        // Convert dollars to rupees and display result in rupeeField
        double dollars = Double.parseDouble(dollarField.getText());
        double rupees = dollars * 73.57; // 1 dollar = 73.57 rupees (as of 20 Feb 2023)
        rupeeField.setText(String.format("%.2f", rupees));
    }

    public static void main(String[] args) {
        java_8 converter = new java_8();
        converter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        converter.setSize(300, 150);
        converter.setVisible(true);
    }
}
