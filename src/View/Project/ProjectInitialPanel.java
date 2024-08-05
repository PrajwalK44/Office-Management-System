package View.Project;

import javax.swing.*;

public class ProjectInitialPanel extends JPanel {
    ProjectCentralPanel pcp;
    ProjectButtons butt;


    public ProjectInitialPanel(){
        pcp = new ProjectCentralPanel();
        butt = new ProjectButtons();
        add(pcp);
        add(butt);
    }

    public void setPcp(ProjectCentralPanel pcp) {
        this.pcp = pcp;
    }

    public ProjectCentralPanel getPcp() {
        return pcp;
    }

    public ProjectButtons getButt() {
        return butt;
    }
}
