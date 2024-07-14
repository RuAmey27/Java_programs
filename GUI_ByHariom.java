/* Ise 1 B) */
// import java.awt*;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.util.Scanner;
class CalculatorGUI extends Frame implements ActionListener, WindowListener {
    Scanner sc = new Scanner(System.in);
    Frame obj;
    float n1;
    float n2;

    public CalculatorGUI() {
        obj = new Frame("Calculator");

        Label l1 = new Label("1st num: ");
        l1.setBounds(30, 40, 60, 30);
        Label l2 = new Label("2nd num");
        l2.setBounds(30, 80, 50, 30);
        Label result = new Label("Result");
        result.setBounds(20, 120, 50, 30);

        TextField t1 = new TextField();
        t1.setBounds(100, 40, 60, 30);

        TextField t2 = new TextField();
        t2.setBounds(100, 80, 60, 30);

        TextField result1 = new TextField();
        result1.setBounds(100, 120, 60, 30);
        result1.setEditable(false);

        Button add = new Button("Addition");
        add.setBounds(250, 50, 60, 30);
        Button subtract = new Button("Substract");
        subtract.setBounds(250, 80, 60, 30);
        Button multiply = new Button("Multiply");
        multiply.setBounds(250, 110, 60, 30);
        Button divide = new Button("Divide");
        divide.setBounds(250, 140, 60, 30);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n1 = Float.parseFloat(t1.getText());
                n2 = Float.parseFloat(t2.getText());
                result1.setText(String.valueOf(n1 + n2));
            }
        });
        subtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n1 = Float.parseFloat(t1.getText());
                n2 = Float.parseFloat(t2.getText());
                result1.setText(String.valueOf(n1 - n2));
            }
        });
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n1 = Float.parseFloat(t1.getText());
                n2 = Float.parseFloat(t2.getText());
                result1.setText(String.valueOf(n1 * n2));
            }
        });
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n1 = Float.parseFloat(t1.getText());
                n2 = Float.parseFloat(t2.getText());
                result1.setText(String.valueOf(n1 / n2));
            }
        });

        obj.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                obj.dispose();
            }
        });

        obj.add(l1);
        obj.add(l2);
        obj.add(result);
        obj.add(t1);
        obj.add(t2);
        obj.add(result1);
        obj.add(add);
        obj.add(subtract);
        obj.add(multiply);
        obj.add(divide);

        obj.setLayout(null);
        obj.setSize(500, 250);
        obj.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window Opened");

    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Window Closed");

    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Window Iconified");

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Window Deiconified");

    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Window Activated");

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Window Deactivated");

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window Closing");

    }
};

public class Calculator {
    public static void main(String[] args) {
        new CalculatorGUI();
    }
};

/*
 * Event Source - Button
 * When Clicked - Event object is thrown at the call back method
 * Call back method - actionPerformed(ActionEvent e) inside ActionListener.
 */