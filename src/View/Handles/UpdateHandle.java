package View.Handles;

import javax.swing.*;
import java.awt.*;

public class UpdateHandle extends JFrame {
    JTextField empId;
    JTextField proId;
    JTextField man_hrs;
    JTextField task;
    JPanel upp;

    JPanel label;
    JLabel l;
    JButton add1;
    JTextField index;
    JButton get;
    JPanel confirm;

    public UpdateHandle(){
        setSize(900, 400);

        label = new JPanel();
        l = new JLabel("Please edit the details of handles");
        l.setFont(new Font("Please edit the details of handles", Font.BOLD, 20));
        setLayout(new GridLayout(4, 0, 20,20));
        label.add(l);
        add(label);

        JPanel getDetails = new JPanel();
        index = new JTextField("Enter the index of the handle");
        get = new JButton("Get the handle");

        getDetails.add(index);
        getDetails.add(get);
        add(getDetails);
        upp = new JPanel();
        empId = new JTextField();
        proId = new JTextField();
        man_hrs = new JTextField();
        task = new JTextField();
        add1 = new JButton("EDIT THE HANDLE");

        upp.add(empId);
        upp.add(proId);
        upp.add(man_hrs);
        upp.add(task);
        upp.add(add1);
        upp.setVisible(false);
        add(upp);

        confirm = new JPanel();
        JLabel confirm1 = new JLabel("Handle Updated Successfully.");
        confirm.add(confirm1);
        confirm.setVisible(false);
        add(confirm);

    }

    public JTextField getProId() {
        return proId;
    }

    public JTextField getMan_hrs() {
        return man_hrs;
    }

    public JTextField getEmpId() {
        return empId;
    }

    public JTextField getTask() {
        return task;
    }

    public JButton getGet() {
        return get;
    }

    public JTextField getIndex() {
        return index;
    }

    public JPanel getUpp() {
        return upp;
    }

    public JButton getAdd1() {
        return add1;
    }

    public JPanel getConfirm() {
        return confirm;
    }
}
