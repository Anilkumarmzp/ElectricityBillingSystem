package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ElectricityRegistrationForm extends JFrame implements ActionListener {
    private JTextField nameField, fatherNameField, addressField, aadharField, mobileField, emailField;
    private JButton submitButton;

    public ElectricityRegistrationForm() {
        setTitle("Electricity Registration Form");
        setSize(400, 400);
        setLayout(new GridLayout(7, 2));

        // Create labels and text fields
        JLabel nameLabel = new JLabel("Name*:");
        nameField = new JTextField();

        JLabel fatherNameLabel = new JLabel("Father's Name*:");
        fatherNameField = new JTextField();

        JLabel addressLabel = new JLabel("Full Address*:");
        addressField = new JTextField();

        JLabel aadharLabel = new JLabel("Aadhar Number*:");
        aadharField = new JTextField();

        JLabel mobileLabel = new JLabel("Mobile Number*:");
        mobileField = new JTextField();

        JLabel emailLabel = new JLabel("Email*:");
        emailField = new JTextField();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        // Add components to frame
        add(nameLabel);
        add(nameField);
        add(fatherNameLabel);
        add(fatherNameField);
        add(addressLabel);
        add(addressField);
        add(aadharLabel);
        add(aadharField);
        add(mobileLabel);
        add(mobileField);
        add(emailLabel);
        add(emailField);
        add(submitButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // Get the input values
            String name = nameField.getText();
            String fatherName = fatherNameField.getText();
            String address = addressField.getText();
            String aadhar = aadharField.getText();
            String mobile = mobileField.getText();
            String email = emailField.getText();

            // Validate the input fields
            if (!validateInput(name, aadhar, mobile, email)) {
                return;
            }

            // Insert data into database
            insertData(name, fatherName, address, aadhar, mobile, email);
        }
    }

    private boolean validateInput(String name, String aadhar, String mobile, String email) {
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name is mandatory", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (aadhar.length() != 12) {
            JOptionPane.showMessageDialog(this, "Aadhar number must be 12 characters", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (mobile.length() != 10 || !mobile.matches("^[6789]\\d{9}$")) {
            JOptionPane.showMessageDialog(this, "Mobile number must start with 6, 7, 8, or 9 and be 10 characters long", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!email.matches("^[a-zA-Z0-9._%+-]+@(gmail|yahoo|outlook|hotmail)\\.com$")) {
            JOptionPane.showMessageDialog(this, "Email must be a valid gmail, yahoo, outlook, or hotmail address", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void insertData(String name, String fatherName, String address, String aadhar, String mobile, String email) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/bill_system";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO electricity_registration (name, father_name, address, aadhar, mobile, email) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, fatherName);
            statement.setString(3, address);
            statement.setString(4, aadhar);
            statement.setString(5, mobile);
            statement.setString(6, email);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Data inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error inserting data", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String[] args) {
        new ElectricityRegistrationForm();
    }
}
