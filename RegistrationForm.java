import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class RegistrationForm extends JFrame implements ActionListener {
    private JLabel firstNameLabel, middleNameLabel, lastNameLabel, genderLabel, phoneLabel, addressLabel, emailLabel, passwordLabel;
    private JTextField firstNameField, middleNameField, lastNameField, phoneField, emailField;
    private JTextArea addressArea;
    private JPasswordField passwordField;
    private JComboBox genderComboBox;
    private JButton submitButton;

    public RegistrationForm() {
        // Initialize GUI components
        firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(20);
        middleNameLabel = new JLabel("Middle Name:");
        middleNameField = new JTextField(20);
        lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(20);
        genderLabel = new JLabel("Gender:");
        String[] genders = {"Male", "Female", "Other"};
        genderComboBox = new JComboBox(genders);
        phoneLabel = new JLabel("Phone Number:");
        phoneField = new JTextField(20);
        addressLabel = new JLabel("Address:");
        addressArea = new JTextArea(5, 20);
        JScrollPane addressScrollPane = new JScrollPane(addressArea);
        emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        // Create and set layout for container
        Container container = getContentPane();
        container.setLayout(new GridLayout(9, 2));

        // Add components to container
        container.add(firstNameLabel);
        container.add(firstNameField);
        container.add(middleNameLabel);
        container.add(middleNameField);
        container.add(lastNameLabel);
        container.add(lastNameField);
        container.add(genderLabel);
        container.add(genderComboBox);
        container.add(phoneLabel);
        container.add(phoneField);
        container.add(addressLabel);
        container.add(addressScrollPane);
        container.add(emailLabel);
        container.add(emailField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(new JLabel(""));
        container.add(submitButton);

        // Set window properties
        setTitle("Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == submitButton) {
            // Retrieve user input
            String firstName = firstNameField.getText();
            String middleName = middleNameField.getText();
            String lastName = lastNameField.getText();
            String gender = (String)genderComboBox.getSelectedItem();
            String phone = phoneField.getText();
            String address = addressArea.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            // Write user information to file
            try {
                FileWriter writer = new FileWriter("users.txt", true);
                writer.write(firstName + "," + middleName + "," + lastName + "," + gender + "," + phone + "," + address + "," + email + "," + password + "\n");
                writer.close();
                JOptionPane.showMessageDialog(this, "Registration Successful!");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Registration Failed: " );
            }
        }
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
