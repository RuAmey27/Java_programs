// Java program to create a simple calculator
// with basic +, -, /, * using java swing elements

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class Calculator_GUI extends JFrame implements ActionListener {
	// create a frame
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;
	// create a textfield
	private JTextField l;

	// store operator and operands
	String s0, s1, s2;

	// default constructor
	public Calculator_GUI()
	{
		super("Calculator");
		// create number buttons
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");

		// equals button
		beq1 = new JButton("=");

		// create operator buttons
		ba = new JButton("+");
		bs = new JButton("-");
		bd = new JButton("/");
		bm = new JButton("*");
		beq = new JButton("C");

		//create.button
		be = new JButton(".");

		// create a panel
		Container p = getContentPane();
		// add elements to panel
		p.add(l);
		p.add(ba);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(bs);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(bm);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(bd);
		p.add(be);
		p.add(b0);
		p.add(beq);
		p.add(beq1);

		// set Background of panel
		p.setBackground(Color.blue);

		// add panel to frame
		// add action listeners
		bm.addActionListener(this);
		bd.addActionListener(this);
		bs.addActionListener(this);
		ba.addActionListener(this);
		b9.addActionListener(this);
		b8.addActionListener(this);
		b7.addActionListener(this);
		b6.addActionListener(this);
		b5.addActionListener(this);
		b4.addActionListener(this);
		b3.addActionListener(this);
		b2.addActionListener(this);
		b1.addActionListener(this);
		b0.addActionListener(this);
		be.addActionListener(this);
		beq.addActionListener(this);
		beq1.addActionListener(this);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);	
	}


    public void actionPerformed(ActionEvent event)
	{
		event.getSource();
		String s = event.getActionCommand();
        s0 = s1 = s2 = ""; 
		// set the textfield to non editable
		// create number buttons and some operators
		// if the value is a number
		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
			// if operand is present then add to second no
			if (!s1.equals(""))
				s2 = s2 + s;
			else
				s0 = s0 + s;

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == 'C') {
			// clear the one letter
			s0 = s1 = s2 = "";

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == '=') {

			double te;

			// store the value in 1st
			if (s1.equals("+"))
				te = (Double.parseDouble(s0) + Double.parseDouble(s2));
			else if (s1.equals("-"))
				te = (Double.parseDouble(s0) - Double.parseDouble(s2));
			else if (s1.equals("/"))
				te = (Double.parseDouble(s0) / Double.parseDouble(s2));
			else
				te = (Double.parseDouble(s0) * Double.parseDouble(s2));

			// set the value of text
			l.setText(s0 + s1 + s2 + "=" + te);

			// convert it to string
			s0 = Double.toString(te);

			s1 = s2 = "";
		}
		else {
			// if there was no operand
			if (s1.equals("")||s2.equals(""))
				s1 = s;
			// else evaluate
			else {
				double te;

				// store the value in 1st
				if (s1.equals("+"))
					te = (Double.parseDouble(s0) + Double.parseDouble(s2));
				else if (s1.equals("-"))
					te = (Double.parseDouble(s0) - Double.parseDouble(s2));
				else if (s1.equals("/"))
					te = (Double.parseDouble(s0) / Double.parseDouble(s2));
				else
					te = (Double.parseDouble(s0) * Double.parseDouble(s2));

				// convert it to string
				s0 = Double.toString(te);

				// place the operator
				s1 = s;

				// make the operand blank
				s2 = "";
				l.setText(s0 + s1 + s2);
			}


			// set the value of text
			
		}
	// main function
	
}
public static void main(String args[])
	{	
		new Calculator_GUI();
		
	}
}