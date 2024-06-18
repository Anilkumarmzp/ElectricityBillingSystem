package electricity.billing.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class AdminPanel extends JFrame {
    private JTable table;

    public AdminPanel() {
        setTitle("Admin Panel - View Data");
        setSize(600, 400);

        String[] columnNames = {"ID", "Name", "Father's Name", "Address", "Aadhar", "Mobile", "Email"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        fetchData(model);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);


    }

    private void fetchData(DefaultTableModel model) {
        String url = "jdbc:mysql://localhost:3306/bill_system";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM electricity_registration";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String fatherName = resultSet.getString("father_name");
                String address = resultSet.getString("address");
                String aadhar = resultSet.getString("aadhar");
                String mobile = resultSet.getString("mobile");
                String email = resultSet.getString("email");

                model.addRow(new Object[]{id, name, fatherName, address, aadhar, mobile, email});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
