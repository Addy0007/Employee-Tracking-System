package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back, addUser;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/employeemanagement"; // Update with your database URL
    private static final String DB_USER = "root"; // Update with your database username
    private static final String DB_PASSWORD = "L8h8BN@1"; // Update with your database password

    login() {
        // Initialize UI components
        setTitle("Employee Management System - Login");
        setLayout(new BorderLayout());

        // Create a panel with background image
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null);

        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 30);
        username.setForeground(Color.WHITE);
        backgroundPanel.add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 20, 150, 30);
        backgroundPanel.add(tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        password.setForeground(Color.WHITE);
        backgroundPanel.add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150, 70, 150, 30);
        backgroundPanel.add(tpassword);

        login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        backgroundPanel.add(login);

        back = new JButton("BACK");
        back.setBounds(150, 180, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        backgroundPanel.add(back);

        addUser = new JButton("ADD USER");
        addUser.setBounds(150, 220, 150, 30);
        addUser.setBackground(Color.BLACK);
        addUser.setForeground(Color.WHITE);
        addUser.addActionListener(this);
        backgroundPanel.add(addUser);

        // Add background panel to the frame
        add(backgroundPanel, BorderLayout.CENTER);

        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            handleLogin();
        } else if (e.getSource() == back) {
            System.exit(0);
        } else if (e.getSource() == addUser) {
            showAddUserDialog();
        }
    }

    private void handleLogin() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String username = tusername.getText();
            String password = new String(tpassword.getPassword());

            String query = "SELECT * FROM login WHERE username=? AND password=?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, username);
                pst.setString(2, password);
                ResultSet resultSet = pst.executeQuery();

                if (resultSet.next()) {
                    setVisible(false);
                    new Main_class();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showAddUserDialog() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.add(new JLabel("Username:"));
        JTextField newUsernameField = new JTextField();
        panel.add(newUsernameField);
        panel.add(new JLabel("Password:"));
        JPasswordField newPasswordField = new JPasswordField();
        panel.add(newPasswordField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add New User", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String newUsername = newUsernameField.getText();
            String newPassword = new String(newPasswordField.getPassword());

            if (newUsername != null && !newUsername.isEmpty() && newPassword != null && !newPassword.isEmpty()) {
                addUserToDatabase(newUsername, newPassword);
            } else {
                JOptionPane.showMessageDialog(null, "Username and Password cannot be empty.");
            }
        }
    }

    private void addUserToDatabase(String username, String password) {
        String checkQuery = "SELECT COUNT(*) FROM login WHERE username = ?";
        String insertQuery = "INSERT INTO login (username, password) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {

            // Check if username already exists
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Username already exists. Please choose a different username.");
            } else {
                // Insert new user if username does not exist
                try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                    insertStmt.setString(1, username);
                    insertStmt.setString(2, password);
                    insertStmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "User added successfully!");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error adding user.");
        }
    }

    public static void main(String[] args) {
        new login();
    }
}

// Custom JPanel to handle background image scaling
class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel() {
        try {
            backgroundImage = new ImageIcon("C:\\Desktop\\MajorP\\Project\\src\\icons\\background.jpg").getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // Scale the image to fit the panel size
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
