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
    
    private int userID; // = 0
    
    private Object[][] table;
    
    TaskCntl(Database taskModel, TaskView taskView)
    {
        this.taskModel = taskModel;
        this.taskView = taskView;
        
        taskView.getModel().setDataVector(taskModel.getTaskInfo(userID), taskView.getColNames()); 
        taskView.getTaskTable().setModel(taskView.getModel());
        
        System.out.println("Task: " + userID);
        
        
        
        taskView.addAddButtonListener(new AddButtonListener());
        taskView.addUpdateButtonListener(new UpdateButtonListener());
        taskView.addDeleteButtonListener(new DeleteButtonListener());
        taskView.getAddTask().addAddTaskButtonListener(new AddTaskButtonListener());  
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return the taskModel
     */
    public Database getTaskModel() {
        return taskModel;
    }

    /**
     * @return the taskView
     */
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
                getTaskView().getAddTask().setVisible(false);
                getTaskView().getModel().setDataVector(getTaskModel().getTaskInfo(userID), getTaskView().getColNames()); 
                getTaskView().getTaskTable().setModel(getTaskView().getModel());
          }          
        }
    }
    
    class UpdateButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
          
        }
    }
    
    class DeleteButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            
        }
    }
    
}
