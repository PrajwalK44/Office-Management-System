package View.Handles;

import javax.swing.*;
import java.awt.*;

public class DeleteTHEHandles extends JFrame {
    JTextField id;
    JPanel label;
    JLabel l;
    JPanel text;
    JButton del;JPanel confirm;
    public DeleteTHEHandles(){
        id=new JTextField(5);
        label=new JPanel();
        l=new JLabel("Please enter the Index of the Handles to be deleted");
        text=new JPanel();
        del=new JButton("DELETE THE HANDLES");
        label.add(l);
        setLayout(new GridLayout(2,0,10,10));
        setSize(400,300);

        add(label);
        text.add(id);
        text.add(del);
        add(text);

        confirm = new JPanel();
        JLabel confirm1 = new JLabel("Handle Deleted Successfully.");
        confirm.add(confirm1);
        confirm.setVisible(false);
        add(confirm);

    }

    public JButton getDel() {
        return del;
    }

    public JLabel getL() {
        return l;
    }

    public JPanel getLabel() {
        return label;
    }

    public JPanel getText() {
        return text;
    }

    public JTextField getId() {
        return id;
    }

    public JPanel getConfirm() {
        return confirm;
    }
}
