/*
Name: Madilyn Carpenter
Date: 03/01/2026
Assignment 10
Purpose: Connects to a MySQL database to display and update fan information based on a provided ID. 
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FanDatabaseApp extends JFrame {

    private JTextField idField, firstField, lastField, teamField;
    private JButton displayButton, updateButton;

    private Connection con;
    private Statement stmt;

    public FanDatabaseApp() {
        setTitle("Fan Database App");
        setSize(400, 250);
        setLayout(new GridLayout(6, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels and text fields
        add(new JLabel("ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("First Name:"));
        firstField = new JTextField();
        add(firstField);

        add(new JLabel("Last Name:"));
        lastField = new JTextField();
        add(lastField);

        add(new JLabel("Favorite Team:"));
        teamField = new JTextField();
        add(teamField);

        // Buttons
        displayButton = new JButton("Display");
        updateButton = new JButton("Update");

        add(displayButton);
        add(updateButton);

        // Connect to database
        connectDatabase();

        // Button actions
        displayButton.addActionListener(e -> displayFan());
        updateButton.addActionListener(e -> updateFan());

        setVisible(true);
    }

    private void connectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/databasedb?";
            con = DriverManager.getConnection(url + "user=student1&password=pass");
            stmt = con.createStatement();

            System.out.println("Connected to database successfully.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database connection failed.");
            e.printStackTrace();
            System.exit(0);
        }
    }

    private void displayFan() {
        try {
            String query = "SELECT * FROM fans WHERE ID=" + idField.getText();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                firstField.setText(rs.getString("firstname"));
                lastField.setText(rs.getString("lastname"));
                teamField.setText(rs.getString("favoriteteam"));
            } else {
                JOptionPane.showMessageDialog(this, "Fan not found.");
            }

            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Display failed.");
            e.printStackTrace();
        }
    }

    private void updateFan() {
        try {
            String query = "UPDATE fans SET firstname='" + firstField.getText() +
                    "', lastname='" + lastField.getText() +
                    "', favoriteteam='" + teamField.getText() +
                    "' WHERE ID=" + idField.getText();

            int rows = stmt.executeUpdate(query);

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Record updated.");
            } else {
                JOptionPane.showMessageDialog(this, "Update failed.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Update failed.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FanDatabaseApp::new);
    }
}