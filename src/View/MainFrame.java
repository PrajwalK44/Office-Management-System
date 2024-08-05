package View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    JButton manageEmployee;
    JButton manageProject;
    JButton manageHandles;

    public JButton getManageEmployee() {
        return manageEmployee;
    }

    public JButton getManageHandles() {
        return manageHandles;
    }

    public JButton getManageProject() {
        return manageProject;
    }

    public MainFrame(){
        super("MAIN DASHBOARD");
        manageEmployee = new JButton("Manage Employees");
        manageEmployee.setFont( new Font("Manage Employees", Font.BOLD, 70));
        manageEmployee.setFocusable(false);
//        manageEmployee.setOpaque(false);
        manageEmployee.setBackground(new Color(0, 177, 253));
        manageEmployee.setForeground(Color.BLACK);
        manageProject = new JButton("Manage Projects");
        manageProject.setFont(new Font("Manage Project", Font.BOLD, 70));
        manageProject.setFocusable(false);
//        manageProject.setOpaque(false);
        manageProject.setBackground(new Color(0, 177, 253));
        manageProject.setForeground(Color.BLACK);
        manageHandles = new JButton("Manage Handles");
        manageHandles.setFont(new Font("Manage Handles", Font.BOLD, 70));
        manageHandles.setFocusable(false);
        manageHandles.setBackground(new Color(0, 177, 253));
        manageHandles.setForeground(Color.BLACK);
//        manageHandles.setOpaque(false);

        JPanel firstP = new JPanel();
        JLabel firstL = new JLabel();
        firstP.setOpaque(false);
        firstP.setLayout(new FlowLayout(FlowLayout.CENTER));
        firstL.setSize(500,600);
        firstP.setSize(500,600);
        firstL.setText("WELCOME TO OFFICE MANAGEMENT SYSTEM!!!");
        firstL.setForeground(Color.black);
        firstL.setFont(new Font("WELCOME TO OFFICE MANAGEMENT SYSTEM!!!", Font.BOLD, 60) );
        firstP.add(firstL);

        JPanel Panel1 = new JPanel();
        Panel1.setOpaque(false);
        Panel1.setSize(100, 300 );
        Panel1.setLayout(new GridLayout(3,0, 20,50));
        manageEmployee.setSize(100, 100);
        Panel1.add(manageEmployee);
        Panel1.add(manageProject);
        Panel1.add(manageHandles);

        ImageIcon im = new ImageIcon("src/360_F_579485091_aVxVKR8e2s886hee1j146OBeiJugJifG (1).jpeg");
        Image img = im.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        im.setImage(img);
        JPanel p = new JPanel();
        JLabel l = new JLabel(im);
        l.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        l.setMaximumSize(getMaximumSize());
        l.add(firstP);
        l.add(Panel1);
        p.add(l);


        JFrame mainFrame = new JFrame();
        mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainFrame.setSize(600,400);
//        mainFrame.add(firstP);
//        mainFrame.add(Panel1);
        mainFrame.add(p);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
