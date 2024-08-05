package Controller;

import Model.Model;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

public class Controller {
    Model model;
    View view;
    // Constructor
    public Controller (Model m, View v){
        view = v;
        model = m;
        // ActionListener for managing employees
        view.getMf().getManageEmployee().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hide main frame, show manage employee frame
                view.getMf().setVisible(false);
                view.getMef().setVisible(true);
            }
        });
        // ActionListener for adding employee
        view.getAed().getAdd1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve employee information from the view
                String eid=view.getAed().getEmp_id().getText();
                String ename=view.getAed().getEmp_name().getText();
                String eposition=view.getAed().getEmp_pos().getText();
                String edept=view.getAed().getEmp_dept().getText();
                String esal=view.getAed().getEmp_salary().getText();
                String econt=view.getAed().getEmp_contact_num().getText();
                String elang=view.getAed().getEmp_lang().getText();
                view.getAed().getConfirm().setVisible(true);
                // Generate and validate employee
                if ((model.getMe().GenerateEmployee(Integer.parseInt(eid), ename, eposition,edept,esal,econt,elang)) == 1){
                    view.getAed().getConfirm1().setVisible(true);
                    view.getAed().getError().setVisible(false);
                } else if ((model.getMe().GenerateEmployee(Integer.parseInt(eid), ename, eposition,edept,esal,econt,elang)) == 0){
                    view.getAed().getError().setVisible(true);
                    view.getAed().getConfirm1().setVisible(false);
                }


            }
        });
        // ActionListener for deleting employee
        view.getDmd().getDel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve employee id to delete
                String eid=view.getDmd().getId().getText();
                // Delete employee and update relevant models
                model.getMe().DeleteEmployee(Integer.parseInt(eid));
                model.getMh().deleteIfEmployeeGetsDeleted(Integer.parseInt(eid));
                view.getDmd().getConfirm().setVisible(true);
            }
        });
        view.getMef().getIpe().getButt().getDelemp().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getDmd().setVisible(true);
                view.getDmd().getConfirm().setVisible(false);
            }
        });

        view.getMef().getIpe().getButt().getAddemp().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getAed().getConfirm().setVisible(false);
                view.getAed().setVisible(true);
            }
        });

        view.getMef().getIpe().getButt().getUpemp().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getUe().getConfirm().setVisible(false);
                view.getUe().setVisible(true);
            }
        });

        view.getMf().getManageProject().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getMf().setVisible(false);
                view.getPmf().setVisible(true);
            }
        });

        view.getMf().getManageHandles().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getMf().setVisible(false);
                view.getHmf().setVisible(true);
            }
        });
        // ActionListener for getting employee information
        view.getUe().getGet().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getUe().getUpp().setVisible(true);
                ArrayList<String> tp;
                tp = model.getMe().employeeGetter(Integer.parseInt(view.getUe().getIndex().getText()));
                view.getUe().getEmp_id().setText(tp.get(0));
                view.getUe().getEmp_name().setText(tp.get(1));
                view.getUe().getEmp_pos().setText(tp.get(2));
                view.getUe().getEmp_dept().setText(tp.get(3));
                view.getUe().getEmp_salary().setText(tp.get(4));
                view.getUe().getEmp_contact_num().setText(tp.get(5));
                view.getUe().getEmp_lang().setText(tp.get(6));
            }
        });
        // ActionListener for updating employee information
        view.getUe().getAdd1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eid=view.getUe().getEmp_id().getText();
                String ename=view.getUe().getEmp_name().getText();
                String eposition=view.getUe().getEmp_pos().getText();
                String edept=view.getUe().getEmp_dept().getText();
                String esal=view.getUe().getEmp_salary().getText();
                String econt=view.getUe().getEmp_contact_num().getText();
                String elang=view.getUe().getEmp_lang().getText();

                model.getMe().UpdateEmployee(Integer.parseInt(view.getUe().getIndex().getText()), Integer.parseInt(eid), ename, eposition, edept, esal, econt, elang);
                view.getUe().getConfirm().setVisible(true);
            }
        });
        // ActionListener for adding a new project
        view.getPmf().getPip().getButt().getAddpro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show add project frame
                view.getApd().setVisible(true);
            }
        });
        // ActionListener for deleting a project
        view.getPmf().getPip().getButt().getDelpro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show delete project frame
                view.getDtp().getConfirm().setVisible(false);
                view.getDtp().setVisible(true);
            }
        });
        // ActionListener for updating a project
        view.getPmf().getPip().getButt().getUppro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show update project frame
                view.getUp().getConfirm().setVisible(false);
                view.getUp().setVisible(true);
            }
        });

        // ActionListener for adding a new project
        view.getApd().getAdd1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve project information from the view
                int project_id = Integer.parseInt(view.getApd().getId().getText());
                String name = view.getApd().getname().getText();
                String start = view.getApd().getStart().getText();
                String bud = view.getApd().getBud().getText();
                String res = view.getApd().getRes().getText();
                String hrs = view.getApd().getHrs().getText();

                // Generate and validate project
                if (model.getMp().GenerateProject(project_id, name, start, Integer.parseInt(bud), res, Integer.parseInt(hrs)) == 1) {
                    // Show confirmation and hide error message if successful
                    view.getApd().getConfirm1().setVisible(true);
                    view.getApd().getError().setVisible(false);
                } else if (model.getMp().GenerateProject(project_id, name, start, Integer.parseInt(bud), res, Integer.parseInt(hrs)) == 0) {
                    // Show error message and hide confirmation if unsuccessful
                    view.getApd().getError().setVisible(true);
                    view.getApd().getConfirm1().setVisible(false);
                }
            }
        });

        // ActionListener for deleting a project
        view.getDtp().getDel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve project ID to delete and delete project
                model.getMp().DeleteProject(Integer.parseInt(view.getDtp().getId().getText()));
                // Delete handles associated with the project
                model.getMh().deleteIfProjectGetsDeleted(Integer.parseInt(view.getDtp().getId().getText()));
                // Show confirmation message
                view.getDtp().getConfirm().setVisible(true);
            }
        });

        // ActionListener for retrieving project information for update
        view.getUp().getGet().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show update project frame
                view.getUp().getUpp().setVisible(true);
                // Retrieve project information based on index
                ArrayList<String> tp;
                tp = model.getMp().projectGetter(Integer.parseInt(view.getUp().getIndex().getText()));
                // Populate update project frame with retrieved information
                view.getUp().getId().setText(String.valueOf(tp.get(0)));
                view.getUp().getname().setText(tp.get(1));
                view.getUp().getStart().setText(tp.get(2));
                view.getUp().getBud().setText(String.valueOf(tp.get(3)));
                view.getUp().getRes().setText(tp.get(4));
                view.getUp().getHrs().setText(String.valueOf(tp.get(5)));
            }
        });

        // ActionListener for updating project information
        view.getUp().getAdd1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve updated project information from the view
                int project_id = Integer.parseInt(view.getUp().getId().getText());
                String name =  view.getUp().getname().getText();
                String start = view.getUp().getStart().getText();
                String bud = view.getUp().getBud().getText();
                String res = view.getUp().getRes().getText();
                String hrs = view.getUp().getHrs().getText();

                // Update project information in the model
                model.getMp().UpdateProject(Integer.parseInt(view.getUp().getIndex().getText()), project_id, name, start, Integer.parseInt(bud), res, Integer.parseInt(hrs) ) ;

                // Show confirmation message
                view.getUp().getConfirm().setVisible(true);
            }
        });

        // ActionListener for adding a handle
        view.getHmf().getHip().getHb().getAddhan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show add handle frame
                view.getAhd().setVisible(true);
            }
        });

        // ActionListener for deleting a handle
        view.getHmf().getHip().getHb().getDelhan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show delete handle frame
                view.getDth().setVisible(true);
            }
        });

        // ActionListener for updating a handle
        view.getHmf().getHip().getHb().getUphan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show update handle frame
                view.getUh().setVisible(true);
            }
        });

        // ActionListener for adding a handle
        view.getAhd().getAdd1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve handle information from the view
                String e_id = view.getAhd().getEmpId().getText();
                String p_id = view.getAhd().getProId().getText();
                String man_hrs = view.getAhd().getMan_hrs().getText();
                String task = view.getAhd().getTask().getText();

                // Generate handle in the model
                model.getMh().GenerateHandles(Integer.parseInt(e_id), Integer.parseInt(p_id), Integer.parseInt(man_hrs), task);

                // Show confirmation message
                view.getAhd().getConfirm().setVisible(true);
            }
        });

        // ActionListener for deleting a handle
        view.getDth().getDel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Delete handle from the model
                model.getMh().DeleteHandles(Integer.parseInt(view.getDth().getId().getText()));

                // Show confirmation message
                view.getDth().getConfirm().setVisible(true);
            }
        });

        // ActionListener for retrieving handle information for update
        view.getUh().getGet().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show update handle frame
                view.getUh().getUpp().setVisible(true);

                // Retrieve handle information based on index
                int e_id = model.getMh().getTable().get(Integer.parseInt(view.getUp().getIndex().getText())).getE_temp().getEmployee_id();
                int p_id = model.getMh().getTable().get(Integer.parseInt(view.getUp().getIndex().getText())).getT_temp().getProject_ID();
                int man_hrs = model.getMh().getTable().get(Integer.parseInt(view.getUp().getIndex().getText())).getMan_hours_completed();
                String task = model.getMh().getTable().get(Integer.parseInt(view.getUp().getIndex().getText())).getTask_assigned();

                // Populate update handle frame with retrieved information
                view.getUh().getEmpId().setText(String.valueOf(e_id));
                view.getUh().getProId().setText(String.valueOf(p_id));
                view.getUh().getMan_hrs().setText(String.valueOf(man_hrs));
                view.getUh().getTask().setText(task);
            }
        });
        // ActionListener for updating a handle
        view.getUh().getAdd1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve updated handle information from the view
                String e_id = view.getUh().getEmpId().getText();
                String p_id = view.getUh().getProId().getText();
                String man_hrs = view.getUh().getMan_hrs().getText();
                String task = view.getUh().getTask().getText();

                // Update handle information in the model
                model.getMh().UpdateHandles(Integer.parseInt(view.getUp().getIndex().getText()), Integer.parseInt(e_id), Integer.parseInt(p_id), Integer.parseInt(man_hrs), task);

                // Show confirmation message
                view.getUh().getConfirm().setVisible(true);
            }
        });

        view.getMef().getIpe().getCep().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMe().getFirstLineToDisplay();
                int current_last_line = model.getMe().getLastLineToDisplay();
                int no_of_courses = model.getMe().getTable().size();
                int no_of_display_lines = model.getMe().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMe().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMe().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMe().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_courses-1)
                {
                    model.getMe().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_courses-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_courses - no_of_display_lines)
                    {
                        new_first_line = no_of_courses-no_of_display_lines;
                        model.getMe().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMe().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateEmployee(model.getMe().getLines(model.getMe().getFirstLineToDisplay(), model.getMe().getLastLineToDisplay()), model.getMe().getHeaders());
            }
        });
        view.getPmf().getPip().getPcp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMp().getFirstLineToDisplay();
                int current_last_line = model.getMp().getLastLineToDisplay();
                int no_of_courses = model.getMp().getTable().size();
                int no_of_display_lines = model.getMp().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMp().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMp().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMp().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_courses-1)
                {
                    model.getMp().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_courses-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_courses - no_of_display_lines)
                    {
                        new_first_line = no_of_courses-no_of_display_lines;
                        model.getMp().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMp().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateProject(model.getMp().getLines(model.getMp().getFirstLineToDisplay(), model.getMp().getLastLineToDisplay()), model.getMp().getHeaders());
            }
        });
        view.getHmf().getHip().getHcp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMh().getFirstLineToDisplay();
                int current_last_line = model.getMh().getLastLineToDisplay();
                int no_of_courses = model.getMh().getTable().size();
                int no_of_display_lines = model.getMh().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMh().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMh().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMh().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_courses-1)
                {
                    model.getMh().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_courses-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_courses - no_of_display_lines)
                    {
                        new_first_line = no_of_courses-no_of_display_lines;
                        model.getMh().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMh().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateHandles(model.getMh().getLines(model.getMh().getFirstLineToDisplay(), model.getMh().getLastLineToDisplay()), model.getMh().getHeaders());
            }
        });


        // Set up the employee view
        model.getMe().setLinesBeingDisplayed(20);
        view.centerInitialSetup(model.getMe().getLinesBeingDisplayed(), model.getMe().getHeaders().size());
        model.getMe().setFirstLineToDisplay(0);
        view.centerUpdateEmployee(model.getMe().getLines(model.getMe().getFirstLineToDisplay(), model.getMe().getLinesBeingDisplayed()), model.getMe().getHeaders());

        // Set up the project view
        model.getMp().setLinesBeingDisplayed(20);
        view.projectCenterInitialSetup(model.getMp().getLinesBeingDisplayed(), model.getMp().getHeaders().size());
        model.getMp().setFirstLineToDisplay(0);
        view.centerUpdateProject(model.getMp().getLines(model.getMp().getFirstLineToDisplay(), model.getMp().getLastLineToDisplay()), model.getMp().getHeaders());

        // Set up the handles view
        model.getMh().setLinesBeingDisplayed(20);
        view.handlesCenterInitialSetup(model.getMh().getLinesBeingDisplayed(), model.getMh().getHeaders().size());
        model.getMh().setFirstLineToDisplay(0);
        view.centerUpdateHandles(model.getMh().getLines(model.getMh().getFirstLineToDisplay(), model.getMh().getLastLineToDisplay()), model.getMh().getHeaders());

    }



}
