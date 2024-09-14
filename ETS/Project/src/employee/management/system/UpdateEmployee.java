package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {
    JTextField tfname, taddress, tphone, temail, tsalary, tdesignation;
    JLabel tempid, tname, tdob, taadhar;
    JButton update, back;
    String number;
    JComboBox<String> Boxeducation;

    UpdateEmployee(String number) {

        this.number = number;

        // Set background same as AddEmployee
        getContentPane().setBackground(new Color(13, 17, 23)); // #0D1117
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        heading.setForeground(Color.WHITE);
        add(heading);

        // Name Label
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        name.setForeground(Color.WHITE);
        add(name);

        // Name TextField (non-editable)
        tname = new JLabel();
        tname.setBounds(200, 150, 150, 30);
        tname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tname.setBackground(new Color(255, 255, 255));
        tname.setForeground(Color.WHITE);
        add(tname);

        // Father's Name
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        fname.setForeground(Color.WHITE);
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(255, 255, 255));
        add(tfname);

        // Date Of Birth (non-editable)
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        dob.setForeground(Color.WHITE);
        add(dob);

        tdob = new JLabel();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tdob.setForeground(Color.WHITE);
        add(tdob);

        // Salary
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        salary.setForeground(Color.WHITE);
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setBackground(new Color(255, 255, 255));
        add(tsalary);

        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        address.setForeground(Color.WHITE);
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(new Color(255, 255, 255));
        add(taddress);

        // Phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        phone.setForeground(Color.WHITE);
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(new Color(255, 255, 255));
        add(tphone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        email.setForeground(Color.WHITE);
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(new Color(255, 255, 255));
        add(temail);

        // Education
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        education.setForeground(Color.WHITE);
        add(education);

        String[] items = {"BBA", "B.Tech", "BCA", "BA", "BSC", "B.COM", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        Boxeducation = new JComboBox<>(items);
        Boxeducation.setBounds(600, 300, 150, 30);
        Boxeducation.setBackground(Color.WHITE); // Ensure the background color of the combo box
        add(Boxeducation);

        // Aadhar (non-editable)
        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        aadhar.setForeground(Color.WHITE);
        add(aadhar);

        taadhar = new JLabel();
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        taadhar.setForeground(Color.WHITE);
        add(taadhar);

        // Employee ID (non-editable)
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        empid.setForeground(Color.WHITE);
        add(empid);

        tempid = new JLabel();
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tempid.setForeground(Color.RED);
        add(tempid);

        // Designation
        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        designation.setForeground(Color.WHITE);
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(new Color(255, 255, 255));
        add(tdesignation);

        // Fetch employee details from DB
        try {
            conn c = new conn();
            String query = "select * from employee where empId = '" + number + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                Boxeducation.setSelectedItem(resultSet.getString("education")); // Set JComboBox value
                taadhar.setText(resultSet.getString("aadhar"));
                tempid.setText(resultSet.getString("empId"));
                tdesignation.setText(resultSet.getString("designation"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Update Button
        update = new JButton("UPDATE");
        update.setBounds(450, 550, 150, 40);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        // Back Button
        back = new JButton("BACK");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Frame properties
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) Boxeducation.getSelectedItem(); // Get education from JComboBox
            String designation = tdesignation.getText();

            try {
                conn c = new conn();
                String query = "update employee set fname = '" + fname + "', salary = '" + salary + "', address = '" + address +
                        "', phone = '" + phone + "', email = '" + email + "', education = '" + education + "', designation = '" + designation +
                        "' where empId = '" + tempid.getText() + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Main_class();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
            new View_Employee();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
