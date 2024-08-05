package View.Handles;

import javax.swing.*;
import java.awt.*;


public class AddHandlesData extends JFrame {
    JTextField empId;
    JTextField proId;
    JTextField man_hrs;
    JTextField task;
    JPanel label;
    JPanel generate;
    JButton add1;
    JLabel l;
    JPanel confirm;

    public AddHandlesData(){
        label = new JPanel();
        l = new JLabel("Please add the details of handles");
        l.setFont(new Font("Please add the details of handles", Font.BOLD, 20));
        setLayout(new GridLayout(4, 0, 20,20));
        label.add(l);
        add(label);
        setSize(900,400);

        generate=new JPanel();
        generate.setLayout(new GridLayout(2,4, 10,10));

        JLabel idl = new JLabel("Employee ID");
        JLabel namel = new JLabel("Project ID");
        JLabel startl = new JLabel("Man Hours Completed");
        JLabel budl = new JLabel("Task Assigned");

        idl.setHorizontalAlignment(SwingConstants.CENTER);
        namel.setHorizontalAlignment(SwingConstants.CENTER);
        startl.setHorizontalAlignment(SwingConstants.CENTER);
        budl.setHorizontalAlignment(SwingConstants.CENTER);

        empId = new JTextField(10);
        proId = new JTextField(10);
        man_hrs = new JTextField(10);
        task = new JTextField(10);

        generate.add(idl);
        generate.add(namel);
        generate.add(startl);
        generate.add(budl);

        generate.add(empId);
        generate.add(proId);
        generate.add(man_hrs);
        generate.add(task);

        add(generate);
        JPanel Add = new JPanel();
        add1=new JButton("Add Handle");
        add1.setFocusable(false);
        Add.add(add1);
        add(Add);

        confirm = new JPanel();
        JLabel confirm1 = new JLabel("Handle Added Successfully.");
        confirm.add(confirm1);
        confirm.setVisible(false);
        add(confirm);
    }

    public JButton getAdd1() {
        return add1;
    }

    public JTextField getEmpId() {
        return empId;
    }

    public JTextField getMan_hrs() {
        return man_hrs;
    }

    public JTextField getProId() {
        return proId;
    }

    public JTextField getTask() {
        return task;
    }

    public JPanel getConfirm() {
        return confirm;
    }
}
