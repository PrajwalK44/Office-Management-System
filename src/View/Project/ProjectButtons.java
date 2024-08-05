package View.Project;

import javax.swing.*;
import java.awt.*;

public class ProjectButtons extends JPanel {


    JButton addpro;
    JButton delpro;
    JButton uppro;


    public ProjectButtons(){
        setLayout(new GridLayout(3, 0, 10, 10));
        addpro = new JButton("ADD PROJECT");
        delpro = new JButton("DELETE PROJECT");
        uppro = new JButton("UPDATE PROJECT");

        addpro.setFocusable(false);
        delpro.setFocusable(false);
        uppro.setFocusable(false);

        add(addpro);
        add(delpro);
        add(uppro);

    }

    public JButton getAddpro() {
        return addpro;
    }

    public JButton getDelpro() {
        return delpro;
    }

    public JButton getUppro() {
        return uppro;
    }
}
