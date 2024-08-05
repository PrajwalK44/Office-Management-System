package View.Handles;

import javax.swing.*;
import java.awt.*;

public class HandleButtons extends JPanel {


    JButton addhan;
    JButton delhan;
    JButton uphan;


    public HandleButtons(){
        setLayout(new GridLayout(3, 0, 10, 10));
        addhan = new JButton("ADD HANDLE");
        delhan = new JButton("DELETE HANDLE");
        uphan = new JButton("UPDATE HANDLE");

        addhan.setFocusable(false);
        delhan.setFocusable(false);
        uphan.setFocusable(false);

        add(addhan);
        add(delhan);
        add(uphan);

    }

    public JButton getAddhan() {
        return addhan;
    }

    public JButton getDelhan() {
        return delhan;
    }

    public JButton getUphan() {
        return uphan;
    }
}
