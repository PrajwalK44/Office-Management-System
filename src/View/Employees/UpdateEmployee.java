package View.Employees;

import javax.swing.*;
import java.awt.*;

public class UpdateEmployee extends JFrame {
    JTextField emp_id;
    JTextField emp_name;
    JTextField emp_pos;
    JTextField emp_dept;
    JTextField emp_salary;
    JTextField emp_contact_num;
    JTextField emp_lang;

    JPanel upp;

    JPanel label;
    JLabel l;
    JButton add1;
    JTextField index;
    JButton get;
    JPanel confirm;

    public UpdateEmployee(){
        setSize(900, 400);

        label = new JPanel();
        l = new JLabel("Please edit the details of employee");
        l.setFont(new Font("Please edit the details of employee", Font.BOLD, 20));
        setLayout(new GridLayout(4, 0, 20,20));
        label.add(l);
        add(label);

        JPanel getDetails = new JPanel();
        index = new JTextField("ID",5);
        get = new JButton("Get the employee");

        getDetails.add(index);
        getDetails.add(get);
        add(getDetails);
        upp = new JPanel();
        emp_id = new JTextField(5);
        emp_name = new JTextField(10);
        emp_pos = new JTextField(10);
        emp_dept = new JTextField(10);
        emp_salary = new JTextField(10);
        emp_contact_num = new JTextField(10);
        emp_lang = new JTextField(10);
        add1 = new JButton("EDIT THE EMPLOYEE");

        upp.add(emp_id);
        upp.add(emp_name);
        upp.add(emp_pos);
        upp.add(emp_dept);
        upp.add(emp_salary);
        upp.add(emp_contact_num);
        upp.add(emp_lang);

        upp.add(add1);
        upp.setVisible(false);
        add(upp);

        confirm = new JPanel();
        JLabel confirm1 = new JLabel("Employee Updated Successfully.");
        confirm.add(confirm1);
        confirm.setVisible(false);
        add(confirm);


    }

    public JButton getAdd1() {
        return add1;
    }

    public JTextField getIndex() {
        return index;
    }

    public JPanel getUpp() {
        return upp;
    }

    public JButton getGet() {
        return get;
    }

    public JTextField getEmp_salary() {
        return emp_salary;
    }

    public JTextField getEmp_pos() {
        return emp_pos;
    }

    public JTextField getEmp_name() {
        return emp_name;
    }

    public JTextField getEmp_lang() {
        return emp_lang;
    }

    public JTextField getEmp_id() {
        return emp_id;
    }

    public JTextField getEmp_dept() {
        return emp_dept;
    }

    public JTextField getEmp_contact_num() {
        return emp_contact_num;
    }

    public JPanel getConfirm() {
        return confirm;
    }
}
