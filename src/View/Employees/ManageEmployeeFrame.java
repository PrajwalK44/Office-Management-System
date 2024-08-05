package View.Employees;

import javax.swing.*;

public class ManageEmployeeFrame extends JFrame {
    InitialEmployeePanel ipe;

    public ManageEmployeeFrame(){
        super("Manage Employee");
        ipe = new InitialEmployeePanel();

        add(ipe);
        pack();
        setSize(500,600);

    }

    public void setIpe(InitialEmployeePanel ipe) {
        this.ipe = ipe;
    }

    public InitialEmployeePanel getIpe() {
        return ipe;
    }
}
