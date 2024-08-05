package View.Project;

import javax.swing.*;
import java.awt.*;

public class UpdateProject extends JFrame {
    JTextField id;
    JTextField name;
    JTextField start;
    JTextField bud;
    JTextField res;
    JTextField hrs;
    JPanel upp;

    JPanel label;
    JLabel l;
    JButton add1;
    JTextField index;
    JButton get;
    JPanel confirm;
    public UpdateProject(){
        setSize(900, 400);

        label = new JPanel();
        l = new JLabel("Please edit the details of project");
        l.setFont(new Font("Please edit the details of project", Font.BOLD, 20));
        setLayout(new GridLayout(4, 0, 20,20));
        label.add(l);
        add(label);

        JPanel getDetails = new JPanel();
        index = new JTextField("ID",5);
        get = new JButton("Get the project");

        getDetails.add(index);
        getDetails.add(get);
        add(getDetails);
        upp = new JPanel();
        id = new JTextField(5);
        name = new JTextField(10);
        start = new JTextField(10);
        bud = new JTextField(10);
        res = new JTextField(10);
        hrs = new JTextField(5);
        add1 = new JButton("EDIT THE PROJECT");

        upp.add(id);
        upp.add(name);
        upp.add(start);
        upp.add(bud);
        upp.add(res);
        upp.add(hrs);
        upp.add(add1);
        upp.setVisible(false);
        add(upp);

        confirm = new JPanel();
        JLabel confirm1 = new JLabel("Project Updated Successfully.");
        confirm.add(confirm1);
        confirm.setVisible(false);
        add(confirm);
    }



    public JTextField getId() {
        return id;
    }


    public JTextField getname() {
        return name;
    }

    public JButton getAdd1() {
        return add1;
    }

    public JTextField getBud() {
        return bud;
    }

    public JTextField getHrs() {
        return hrs;
    }

    public JTextField getRes() {
        return res;
    }

    public JTextField getStart() {
        return start;
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

    public JPanel getConfirm() {
        return confirm;
    }
}
