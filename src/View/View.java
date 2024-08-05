package View;

import View.Employees.AddEmployeeData;
import View.Employees.DeleteEmployee;
import View.Employees.ManageEmployeeFrame;
import View.Employees.UpdateEmployee;
import View.Handles.AddHandlesData;
import View.Handles.DeleteTHEHandles;
import View.Handles.HandlesManageFrame;
import View.Handles.UpdateHandle;
import View.Project.AddProjectData;
import View.Project.DeleteTHEProject;
import View.Project.ProjectManageFrame;
import View.Project.UpdateProject;

import java.awt.*;
import java.util.ArrayList;

public class View {
    MainFrame mf;
    ManageEmployeeFrame mef;
    AddEmployeeData aed;
    HandlesManageFrame hmf;
    ProjectManageFrame pmf;
    DeleteEmployee dmd;
    UpdateEmployee ue;
    AddProjectData apd;
    DeleteTHEProject dtp;
    UpdateProject up;
    AddHandlesData ahd;
    DeleteTHEHandles dth;
    UpdateHandle uh;

    public View(){
        mf = new MainFrame();
        mef = new ManageEmployeeFrame();
        aed = new AddEmployeeData();
        pmf = new ProjectManageFrame();
        hmf = new HandlesManageFrame();
        dmd=new DeleteEmployee();
        ue = new UpdateEmployee();
        apd = new AddProjectData();
        dtp = new DeleteTHEProject();
        up = new UpdateProject();
        ahd = new AddHandlesData();
        dth = new DeleteTHEHandles();
        uh = new UpdateHandle();
    }

    public AddHandlesData getAhd() {
        return ahd;
    }

    public DeleteTHEHandles getDth() {
        return dth;
    }

    public UpdateHandle getUh() {
        return uh;
    }

    public UpdateProject getUp() {
        return up;
    }

    public DeleteTHEProject getDtp() {
        return dtp;
    }

    public DeleteEmployee getDmd() {
        return dmd;
    }

    public HandlesManageFrame getHmf() {
        return hmf;
    }

    public void setPmf(ProjectManageFrame pmf) {
        this.pmf = pmf;
    }

    public ProjectManageFrame getPmf() {
        return pmf;
    }

    public AddEmployeeData getAed() {
        return aed;
    }

    public void setMef(ManageEmployeeFrame mef) {
        this.mef = mef;
    }

    public void setMf(MainFrame mf) {
        this.mf = mf;
    }

    public MainFrame getMf() {
        return mf;
    }

    public ManageEmployeeFrame getMef() {
        return mef;
    }

    public UpdateEmployee getUe() {
        return ue;
    }

    public AddProjectData getApd() {
        return apd;
    }

    public void centerInitialSetup(int linesBeingDisplayed, int size){
        mef.getIpe().getCep().setLayout(new GridLayout(linesBeingDisplayed+1, size));

        mef.getIpe().getCep().createLabels((linesBeingDisplayed+1)*size);
    }

    public void projectCenterInitialSetup (int linesBeingDisplayed, int size){
        pmf.getPip().getPcp().setLayout(new GridLayout(linesBeingDisplayed+1, size));
        pmf.getPip().getPcp().createLabels((linesBeingDisplayed+1)*size);
    }

    public void handlesCenterInitialSetup(int linesBeingDisplayed, int size){
        hmf.getHip().getHcp().setLayout(new GridLayout(linesBeingDisplayed+1, size));
        hmf.getHip().getHcp().createLabels((linesBeingDisplayed+1)*size);
    }

    public void centerUpdateEmployee(ArrayList<ArrayList<String>> lines, ArrayList<String> headers){
        for (int i = 0; i < headers.size(); i++) {
            mef.getIpe().getCep().getAllLabels().get(i).setText(headers.get(i));
        }

        for (int emp_row_no = 0; emp_row_no<lines.size(); emp_row_no++){
            for(int emp_col_no = 0; emp_col_no<headers.size(); emp_col_no++){
                int label_no = emp_row_no * headers.size() + headers.size() + emp_col_no;
                String label_txt = lines.get(emp_row_no).get(emp_col_no);
                if(mef.getIpe().getCep().getAllLabels().size() == label_no){
                    break;
                }
                mef.getIpe().getCep().getAllLabels().get(label_no).setText("<html>" + label_txt + "</html>");
            }
        }
    }

    public void centerUpdateProject(ArrayList<ArrayList<String>> lines, ArrayList<String> headers){
        for (int i = 0; i < headers.size(); i++){
            pmf.getPip().getPcp().getAllLabels().get(i).setText(headers.get(i));
        }

        for (int pro_row_no = 0; pro_row_no< lines.size(); pro_row_no++){
            for(int pro_col_no = 0; pro_col_no < headers.size(); pro_col_no++){
                int label_no = pro_row_no * headers.size() + headers.size() + pro_col_no;
                String label_txt = lines.get(pro_row_no).get(pro_col_no);
                if(pmf.getPip().getPcp().getAllLabels().size() == label_no){
                    break;
                }
                pmf.getPip().getPcp().getAllLabels().get(label_no).setText("<html> <div style='text-align: center;'> "+ label_txt + "</html>");
            }
        }
    }

    public void centerUpdateHandles(ArrayList<ArrayList<String>> lines, ArrayList<String> headers){
        for (int i = 0; i < headers.size(); i++){
            hmf.getHip().getHcp().getAllLabels().get(i).setText(headers.get(i));
        }

        for (int han_row_no = 0; han_row_no< lines.size(); han_row_no++){
            for(int han_col_no = 0; han_col_no < headers.size(); han_col_no++){
                int label_no = han_row_no * headers.size() + headers.size() + han_col_no;
                String label_txt = lines.get(han_row_no).get(han_col_no);
                if(hmf.getHip().getHcp().getAllLabels().size() == label_no){
                    break;
                }
                hmf.getHip().getHcp().getAllLabels().get(label_no).setText("<html>" + label_txt + "</html>");
            }
        }
    }
}
