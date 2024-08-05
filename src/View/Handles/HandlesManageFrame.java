package View.Handles;

import javax.swing.*;

public class HandlesManageFrame extends JFrame {
    HandlesInitialPanel hip;


    public HandlesManageFrame(){
        super("Manage Handles");
        hip = new HandlesInitialPanel();
        add(hip);


        pack();
        setSize(800,600);
    }

    public HandlesInitialPanel getHip() {
        return hip;
    }


}
