package View.Handles;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class HandlesCentralPanel extends JPanel {
    ArrayList<JLabel> labels = new ArrayList<>();



    public HandlesCentralPanel(){
        super();
        setSize(300,300);
        setMaximumSize(new Dimension(300,300));
    }

    public void createLabels (int count){

        for(int i = 1; i <= count; i++){
            JLabel label = new JLabel();
//            label.setSize(500,50);
            label.setLayout(new BorderLayout());
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setBorder(new LineBorder(Color.black));
            label.setPreferredSize(new Dimension(200,30));
            label.setMaximumSize(new Dimension(200,30));
            labels.add(label);
            this.add(label, BorderLayout.CENTER);
            validate();
            repaint();
        }

    }




    public void setLabels(ArrayList<JLabel> labels) {
        this.labels = labels;
    }

    public ArrayList<JLabel> getAllLabels() {
        return labels;
    }
}
