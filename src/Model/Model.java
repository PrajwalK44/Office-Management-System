package Model;

import Model.Employee.manageEmployee;
import Model.Handles.manageHandles;
import Model.Project.manageProject;

public class Model {
    manageEmployee me;
    manageProject mp;
    manageHandles mh;

    public Model(){
        me = new manageEmployee();
        mp = new manageProject();
        mh = new manageHandles();
    }

    public manageEmployee getMe() {
        return me;
    }

    public manageHandles getMh() {
        return mh;
    }

    public manageProject getMp() {
        return mp;
    }
}
