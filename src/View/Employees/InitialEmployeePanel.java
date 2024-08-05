package View.Employees;



import javax.swing.*;

public class InitialEmployeePanel extends JPanel {

    CentralEmployeePanel cep;
    EmployeeButtons butt;

    public InitialEmployeePanel(){
        cep = new CentralEmployeePanel();
        add(cep);
        butt = new EmployeeButtons();
        add(butt);
    }

    public CentralEmployeePanel getCep() {
        return cep;
    }

    public EmployeeButtons getButt() {
        return butt;
    }
}
