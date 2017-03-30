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
        taskView.addUpdateButtonListener(new UpdateButtonListener());
        taskView.addDeleteButtonListener(new DeleteButtonListener());
        taskView.getAddTask().addAddTaskButtonListener(new AddTaskButtonListener());  
    }
    
    //Listener Add Button on Task View
    class AddButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
           taskView.getAddTask().setVisible(true);
        }
    }
    
    //Listener on Add Task PopUp
    class AddTaskButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
          taskName = taskView.getAddTask().getTaskName().getText();
          dueDate = taskView.getAddTask().getDueDate().getText();
          taskType = taskView.getAddTask().getTypeComboBox().getSelectedItem().toString();
          description = taskView.getAddTask().getDescription().getText();
          
          if(taskName.equals("") || dueDate.equals(""))
          {
              System.out.println("Error Adding Task");
          }
          else
          {
              taskModel.addTask(taskName, description, dueDate, taskType);
              taskView.getAddTask().setVisible(false);
              taskView.getModel().setDataVector(taskModel.getTaskInfo(), taskView.getColNames()); 
              taskView.getTaskTable().setModel(taskView.getModel());
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
