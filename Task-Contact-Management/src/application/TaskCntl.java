/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author reesmcdevitt
 */
public class TaskCntl 
{
    private Database taskModel;
    private TaskView taskView;
    
    private String taskName;
    private String dueDate;
    private String taskType;
    private String description;
    
    
    private Object[][] table;
    
    TaskCntl(Database taskModel, TaskView taskView)
    {
        this.taskModel = taskModel;
        this.taskView = taskView;
 
        taskView.addAddButtonListener(new AddButtonListener());
        taskView.addDeleteButtonListener(new DeleteButtonListener());
        taskView.addUpdateButtonListener(new TaskCntl.UpdateButtonListener());
        taskView.getAddTask().addAddTaskButtonListener(new AddTaskButtonListener());  
        taskView.getUpdateTask().addUpdateTaskButtonListener(new UpdateTaskButtonListener());
    }

    public Database getTaskModel() {
        return taskModel;
    }

    public TaskView getTaskView() {
        return taskView;
    }
    
    //Listener Add Button on Task View
    class AddButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            getTaskView().getAddTask().setVisible(true);
        }
    }
    
    public void updateTable() {
        getTaskView().getModel().setDataVector(getTaskModel()
                .getTaskInfo(getTaskModel().getCurrentUserId()), getTaskView().getColNames());
        getTaskView().getTaskTable().setModel(getTaskView().getModel());
    }
    
    //Listener on Add Task PopUp
    class AddTaskButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            taskName = getTaskView().getAddTask().getTaskName().getText();
            dueDate = getTaskView().getAddTask().getDueDate().getText();
            taskType = getTaskView().getAddTask().getTypeComboBox().getSelectedItem().toString();
            description = getTaskView().getAddTask().getDescription().getText();

            if(taskName.equals("") || dueDate.equals(""))
            {
                System.out.println("Error Adding Task");
            }
            else
            {
                  getTaskModel().addTask(taskName, description, dueDate, taskType);
                  getTaskView().getAddTask().getTaskName().setText("");
                  getTaskView().getAddTask().getDueDate().setText("");
                  getTaskView().getAddTask().getDescription().setText("");
                  getTaskView().getAddTask().dispose();
                  updateTable();

            }          
        }
    }
    
    class DeleteButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            taskModel.deleteTask((String) getTaskView().getTaskTable()
                    .getModel().getValueAt(getTaskView().getTaskTable().getSelectedRow(), 0));
            updateTable();
        }
    }
    class UpdateButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
           getTaskView().getUpdateTask().setVisible(true);
        }
    }
    
    class UpdateTaskButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = getTaskView().getUpdateTask().getTaskName().getText();
            String date = getTaskView().getUpdateTask().getDueDate().getText();
            String type = getTaskView().getUpdateTask().getTypeComboBox().getModel().getSelectedItem().toString();
            String description = getTaskView().getUpdateTask().getDescription().getText();
            int userId = getTaskModel().getCurrentUserId();
            
            getTaskModel().updateTask(name, type, date, date, userId);
            getTaskView().getUpdateTask().dispose();
            getTaskView().getUpdateTask().getTaskName().setText("");
            getTaskView().getUpdateTask().getDueDate().setText("");
            getTaskView().getUpdateTask().getTypeComboBox().setSelectedIndex(0);
            getTaskView().getUpdateTask().getDescription().setText("");
            updateTable();
        }
    }
}
