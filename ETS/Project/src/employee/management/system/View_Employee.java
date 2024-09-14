package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Employee extends JFrame implements ActionListener {

    JTable table;
    Choice choiceEMP;
    JButton searchbtn, print, update, back;

    View_Employee() {
        // Set the background color of the frame to GitHub dark mode
        getContentPane().setBackground(new Color(13, 17, 23)); // #0D1117

        // Set up the label
        JLabel search = new JLabel("Search by employee ID");
        search.setBounds(20, 20, 180, 20);
        search.setForeground(Color.WHITE); // Set text color to white for contrast
        search.setFont(new Font("SansSerif", Font.BOLD, 14)); // Optional: make the font bold
        add(search);

        // Set up the choice component
        choiceEMP = new Choice();
        choiceEMP.setBounds(210, 20, 150, 20);
        add(choiceEMP);

        // Populate the choice component with employee IDs from the database
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()) {
                choiceEMP.add(resultSet.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set up the table and populate it with data from the database
        table = new JTable();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set up the table in a scroll pane
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 100, 900, 600);
        add(jp);

        // Set up buttons with dark theme styling
        searchbtn = new JButton("Search");
        searchbtn.setBounds(20, 70, 80, 20);
        searchbtn.setBackground(Color.BLACK); // Dark background
        searchbtn.setForeground(Color.WHITE); // White text
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.setBackground(Color.BLACK); // Dark background
        print.setForeground(Color.WHITE); // White text
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.setBackground(Color.BLACK); // Dark background
        update.setForeground(Color.WHITE); // White text
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.setBackground(Color.BLACK); // Dark background
        back.setForeground(Color.WHITE); // White text
        back.addActionListener(this);
        add(back);

        // Frame settings
        setSize(900, 700);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn) {
            String query = "select * from employee where empId = '" + choiceEMP.getSelectedItem() + "'";
            try {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == update) {
            // Open the UpdateEmployee window with the selected employee ID
            String empId = choiceEMP.getSelectedItem();
            setVisible(false); // Hide current window
            new UpdateEmployee(empId); // Pass the selected employee ID to the UpdateEmployee constructor
        } else if (e.getSource() == back) {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new View_Employee();
    }
}
