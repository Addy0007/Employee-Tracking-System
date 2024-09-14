package employee.management.system;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation;
    JLabel tempid;
    JDateChooser tdob;

    JButton add, back;

    JComboBox<String> Boxeducation;

    AddEmployee() {
        // Set GitHub dark mode background color
        getContentPane().setBackground(new Color(13, 17, 23));// #0D1117

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        heading.setForeground(Color.WHITE);
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        name.setForeground(Color.WHITE);
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(Color.WHITE); // Lighter blue-green for contrast
        tname.setForeground(new Color(66, 135, 245)); // Tech-inspired blue
        tname.setFont(new Font("SansSerif", Font.BOLD, 14)); // Bold text
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        fname.setForeground(Color.WHITE);
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(Color.WHITE);
        tfname.setForeground(new Color(66, 135, 245)); // Tech-inspired blue
        tfname.setFont(new Font("SansSerif", Font.BOLD, 14)); // Bold text
        add(tfname);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        dob.setForeground(Color.WHITE);
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setBackground(Color.WHITE); // Ensure the background color of the date chooser
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        salary.setForeground(Color.WHITE);
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setBackground(Color.WHITE);
        tsalary.setForeground(new Color(66, 135, 245)); // Tech-inspired blue
        tsalary.setFont(new Font("SansSerif", Font.BOLD, 14)); // Bold text
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        address.setForeground(Color.WHITE);
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(Color.WHITE);
        taddress.setForeground(new Color(66, 135, 245)); // Tech-inspired blue
        taddress.setFont(new Font("SansSerif", Font.BOLD, 14)); // Bold text
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        phone.setForeground(Color.WHITE);
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(Color.WHITE);
        tphone.setForeground(new Color(66, 135, 245)); // Tech-inspired blue
        tphone.setFont(new Font("SansSerif", Font.BOLD, 14)); // Bold text
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        email.setForeground(Color.WHITE);
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(Color.WHITE);
        temail.setForeground(new Color(66, 135, 245)); // Tech-inspired blue
        temail.setFont(new Font("SansSerif", Font.BOLD, 14)); // Bold text
        add(temail);

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

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        aadhar.setForeground(Color.WHITE);
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setBackground(Color.WHITE);
        taadhar.setForeground(new Color(66, 135, 245)); // Tech-inspired blue
        taadhar.setFont(new Font("SansSerif", Font.BOLD, 14)); // Bold text
        add(taadhar);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        empid.setForeground(Color.WHITE);
        add(empid);

        tempid = new JLabel("" + number);
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempid.setForeground(Color.WHITE);
        add(tempid);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        designation.setForeground(Color.WHITE);
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(Color.WHITE);
        tdesignation.setForeground(new Color(66, 135, 245)); // Tech-inspired blue
        tdesignation.setFont(new Font("SansSerif", Font.BOLD, 14)); // Bold text
        add(tdesignation);

        add = new JButton("ADD");
        add.setBounds(450, 550, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String aadhar = taadhar.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) Boxeducation.getSelectedItem();
            String designation = tdesignation.getText();
            String empID = tempid.getText();

            try {
                conn c = new conn();
                String query = "insert into employee values('" + name + "', '" + fname + "', '" + dob + "', '" + salary + "','" + address + "', '" + phone + "', '" + email + "', '" + education + "', '" + designation + "','" + aadhar + "', '" + empID + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Main_class();

            } catch (Exception E) {
                E.printStackTrace();
            }

        } else {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
