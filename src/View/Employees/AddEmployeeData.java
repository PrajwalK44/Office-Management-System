package View.Employees;

import javax.swing.*;
import java.awt.*;

public class AddEmployeeData extends JFrame {
    JTextField emp_id;
    JTextField emp_name;
    JTextField emp_pos;
    JTextField emp_dept;
    JTextField emp_salary;
    JTextField emp_contact_num;
    JTextField emp_lang;
    JPanel label;
    JButton autob;
    JLabel l;
    JPanel generate;
    JButton add1;
    JPanel confirm;
    JLabel error;
    JLabel confirm1;

    public AddEmployeeData(){
        label = new JPanel();
        l = new JLabel("Please select how do you want to add employee");
        l.setFont(new Font("Please select how do you want to add employee", Font.BOLD, 20));
        setLayout(new GridLayout(4, 0, 20,20));
        label.add(l);
        add(label);
        setSize(900,400);

        generate=new JPanel();
        generate.setLayout(new GridLayout(2, 7));

        JLabel idl = new JLabel("ID");
        JLabel namel = new JLabel("Name");
        JLabel positionl = new JLabel("Position");
        JLabel deptl = new JLabel("Department");
        JLabel sall = new JLabel("Salary");
        JLabel conl = new JLabel("Contact Number");
        JLabel langl = new JLabel("Language");

        idl.setHorizontalAlignment(SwingConstants.CENTER);
        namel.setHorizontalAlignment(SwingConstants.CENTER);
        positionl.setHorizontalAlignment(SwingConstants.CENTER);
        deptl.setHorizontalAlignment(SwingConstants.CENTER);
        sall.setHorizontalAlignment(SwingConstants.CENTER);
        conl.setHorizontalAlignment(SwingConstants.CENTER);
        langl.setHorizontalAlignment(SwingConstants.CENTER);

        emp_id = new JTextField(10);
        emp_name = new JTextField(10);
        emp_pos = new JTextField(10);
        emp_dept = new JTextField(10);
        emp_salary = new JTextField(10);
        emp_contact_num = new JTextField(10);
        emp_lang = new JTextField(10);

        generate.add(idl);
        generate.add(namel);
        generate.add(positionl);
        generate.add(deptl);
        generate.add(sall);
        generate.add(conl);
        generate.add(langl);

        generate.add(emp_id);
        generate.add(emp_name);
        generate.add(emp_pos);
        generate.add(emp_dept);
        generate.add(emp_salary);
        generate.add(emp_contact_num);
        generate.add(emp_lang);
        add(generate);
        JPanel Add = new JPanel();
        add1=new JButton("Add Employee");
        add1.setFocusable(false);
        Add.add(add1);
        add(Add);

        confirm = new JPanel();
        confirm1 = new JLabel("Employee Added Successfully.");
        confirm1.setVisible(false);
        confirm.add(confirm1);
        error = new JLabel("Employee Id already exists.");
        error.setVisible(false);
        confirm.add(error);
        add(confirm);
    }

    public JTextField getEmp_contact_num() {
        return emp_contact_num;
    }

    public JTextField getEmp_dept() {
        return emp_dept;
    }

    public JTextField getEmp_id() {
        return emp_id;
    }

    public JTextField getEmp_lang() {
        return emp_lang;
    }

    public JTextField getEmp_name() {
        return emp_name;
    }

    public JTextField getEmp_pos() {
        return emp_pos;
    }

    public JTextField getEmp_salary() {
        return emp_salary;
    }

    public JButton getAdd1() {
        return add1;
    }

    public JPanel getConfirm() {
        return confirm;
    }

    public JLabel getConfirm1() {
        return confirm1;
    }

    public JLabel getError() {
        return error;
    }
}
