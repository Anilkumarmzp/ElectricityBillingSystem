package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactPage extends JFrame {


        private JTextField nameField, emailField, subjectField;
        private JTextArea messageArea;

        public ContactPage() {
            setTitle("Contact");
            setSize(400, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Create a panel to hold all components
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Name field
            JLabel nameLabel = new JLabel("Name:");
            nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            nameField = new JTextField();
            nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, nameField.getPreferredSize().height));
            nameField.setAlignmentX(Component.LEFT_ALIGNMENT);

            // Email field
            JLabel emailLabel = new JLabel("Email:");
            emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            emailField = new JTextField();
            emailField.setMaximumSize(new Dimension(Integer.MAX_VALUE, emailField.getPreferredSize().height));
            emailField.setAlignmentX(Component.LEFT_ALIGNMENT);

            // Subject field
            JLabel subjectLabel = new JLabel("Subject:");
            subjectLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            subjectField = new JTextField();
            subjectField.setMaximumSize(new Dimension(Integer.MAX_VALUE, subjectField.getPreferredSize().height));
            subjectField.setAlignmentX(Component.LEFT_ALIGNMENT);

            // Message area
            JLabel messageLabel = new JLabel("Message:");
            messageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            messageArea = new JTextArea(10, 20);
            messageArea.setLineWrap(true);
            messageArea.setWrapStyleWord(true);
            JScrollPane messageScrollPane = new JScrollPane(messageArea);
            messageScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);

            // Submit button
            JButton submitButton = new JButton("Submit");
            submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    submitForm();
                }
            });

            // Add components to panel
            panel.add(nameLabel);
            panel.add(nameField);
            panel.add(emailLabel);
            panel.add(emailField);
            panel.add(subjectLabel);
            panel.add(subjectField);
            panel.add(messageLabel);
            panel.add(messageScrollPane);
            panel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
            panel.add(submitButton);

            // Add panel to frame
            add(panel);
        }

        private void submitForm() {
            String name = nameField.getText();
            String email = emailField.getText();
            String subject = subjectField.getText();
            String message = messageArea.getText();

            // Perform validation
            if (name.isEmpty() || email.isEmpty() || subject.isEmpty() || message.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Save to database
            try {
                saveToDatabase(name, email, subject, message);
                JOptionPane.showMessageDialog(this, "Message sent successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error saving to database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void saveToDatabase(String name, String email, String subject, String message) throws SQLException {
            String url = "jdbc:mysql://localhost:3306/bill_system";
            String user = "root";  // Change to your database username
            String password = "root";  // Change to your database password

            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO Contacts (name, email, subject, message) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, subject);
            pstmt.setString(4, message);
            pstmt.executeUpdate();
            setLocation(500,200);
            setLayout(null);
            setVisible(true);
            pstmt.close();
            conn.close();


        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                ContactPage contactPage = new ContactPage();
                contactPage.setVisible(true);
            });
            new ContactPage();
        }
    }


