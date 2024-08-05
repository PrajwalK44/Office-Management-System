package View.Handles;

import javax.swing.*;

public class HandlesInitialPanel extends JPanel {
    HandlesCentralPanel hcp;
    HandleButtons hb;

    public HandlesInitialPanel(){
        hcp = new HandlesCentralPanel();
        add(hcp);
        hb = new HandleButtons();
        add(hb);
    }

    public HandlesCentralPanel getHcp() {
        return hcp;
    }
    public HandleButtons getHb() {
        return hb;
    }
}
