import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DollarToRupeeConverter extends JFrame implements ActionListener {
    private JLabel dollarLabel, rupeeLabel;
    private JTextField dollarField, rupeeField;
    private JButton convertButton;

    public DollarToRupeeConverter() {
        super("Dollar to Rupee Converter");

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
        float dollars = Float.parseFloat(dollarField.getText());
        float rupees = dollars * 73; // 1 dollar = 73.57 rupees (as of 20 Feb 2023)
        rupeeField.setText(String.format("%f", rupees));
    }

    public static void main(String[] args) {
        DollarToRupeeConverter converter = new DollarToRupeeConverter();
        converter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        converter.setSize(300, 150);
        converter.setVisible(true);
    }
}
