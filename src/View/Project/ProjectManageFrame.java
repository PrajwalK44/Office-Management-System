package View.Project;

import javax.swing.*;

public class ProjectManageFrame extends JFrame {

    ProjectInitialPanel pip;

    public ProjectManageFrame (){

        super("Manage Project");
        pip = new ProjectInitialPanel();


        add(pip);
        pack();
        setSize(500,600);
    }

    public void setPip(ProjectInitialPanel pip) {
        this.pip = pip;
    }

    public ProjectInitialPanel getPip() {
        return pip;
    }
}
