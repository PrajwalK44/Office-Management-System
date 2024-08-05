package View.Employees;

import javax.swing.*;
import java.awt.*;

public class EmployeeButtons extends JPanel {

    JButton addemp;
    JButton delemp;
    JButton upemp;
    JButton addpro;
    JButton delpro;
    JButton uppro;
    JButton addHandle;
    JButton delHan;
    JButton upHan;

    public EmployeeButtons(){
        setLayout(new GridLayout(3, 0, 10, 10));
        addemp = new JButton("ADD EMPLOYEE");
        delemp = new JButton("DELETE EMPLOYEE");
        upemp = new JButton("UPDATE EMPLOYEE");

        addemp.setFocusable(false);
        delemp.setFocusable(false);
        upemp.setFocusable(false);

        add(addemp);
        add(delemp);
        add(upemp);

    }

    public JButton getAddemp() {
        return addemp;
    }

    public JButton getDelemp() {
        return delemp;
    }

    public JButton getUpemp() {
        return upemp;
    }
}
