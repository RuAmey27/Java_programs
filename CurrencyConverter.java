import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CurrencyConverter extends JFrame implements ActionListener {
    private JTextField dollarsTextField, rupeesTextField;
    private JButton convertButton;

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);

        JLabel dollarsLabel = new JLabel("American Dollars:");
        JLabel rupeesLabel = new JLabel("Indian Rupees:");
        dollarsTextField = new JTextField(10);
        rupeesTextField = new JTextField(10);
        rupeesTextField.setEditable(false);
        convertButton = new JButton("Convert");

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(dollarsLabel);
        panel.add(dollarsTextField);
        panel.add(rupeesLabel);
        panel.add(rupeesTextField);
        panel.add(new JLabel());
        panel.add(convertButton);

        add(panel);

        convertButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        double dollars = Double.parseDouble(dollarsTextField.getText());
        double rupees = dollars * 90; // Current exchange rate as of Feb 2023
        rupeesTextField.setText(String.format("%.2f", rupees));
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        converter.setVisible(true);
    }
}
