package View.Project;

import javax.swing.*;
import java.awt.*;


public class AddProjectData extends JFrame {
    JTextField id;
    JTextField name;
    JTextField start;
    JTextField bud;
    JTextField res;
    JTextField hrs;
    JPanel label;
    JPanel generate;
    JButton add1;
    JLabel l;
    JPanel confirm;
    JLabel error;
    JLabel confirm1;

    public AddProjectData(){
        label = new JPanel();
        l = new JLabel("Please add the details of project");
        l.setFont(new Font("Please add the details of project", Font.BOLD, 20));
        setLayout(new GridLayout(4, 0, 20,20));
        label.add(l);
        add(label);
        setSize(900,400);

        generate=new JPanel();
        generate.setLayout(new GridLayout(2,6, 10,10));

        JLabel idl = new JLabel("ID");
        JLabel namel = new JLabel("Name");
        JLabel startl = new JLabel("Start Date");
        JLabel budl = new JLabel("Budget");
        JLabel resl = new JLabel("Resources");
        JLabel hrsl = new JLabel("Hours Completed");

        idl.setHorizontalAlignment(SwingConstants.CENTER);
        namel.setHorizontalAlignment(SwingConstants.CENTER);
        startl.setHorizontalAlignment(SwingConstants.CENTER);
        budl.setHorizontalAlignment(SwingConstants.CENTER);
        resl.setHorizontalAlignment(SwingConstants.CENTER);
        hrsl.setHorizontalAlignment(SwingConstants.CENTER);

        id = new JTextField(10);
        name = new JTextField(10);
        start = new JTextField(10);
        bud = new JTextField(10);
        res = new JTextField(10);
        hrs = new JTextField(10);

        generate.add(idl);
        generate.add(namel);
        generate.add(startl);
        generate.add(budl);
        generate.add(resl);
        generate.add(hrsl);

        generate.add(id);
        generate.add(name);
        generate.add(start);
        generate.add(bud);
        generate.add(res);
        generate.add(hrs);

        add(generate);
        JPanel Add = new JPanel();
        add1=new JButton("Add PROJECT");
        add1.setFocusable(false);
        Add.add(add1);
        add(Add);

        confirm = new JPanel();
        confirm1 = new JLabel("Project Added Successfully.");
        confirm.add(confirm1);
        confirm1.setVisible(false);
        error = new JLabel("Project Id already exists.");
        error.setVisible(false);
        confirm.add(error);
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
