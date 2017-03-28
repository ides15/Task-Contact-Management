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
    
    private AddTask addTask;
    
    
    TaskCntl(Database taskModel, TaskView taskView)
    {
        this.taskModel = taskModel;
        this.taskView = taskView;
        
        addTask = new AddTask();
        addTask.setVisible(false);
        
        
        taskView.addAddButtonListener(new AddButtonListener());
        taskView.addUpdateButtonListener(new UpdateButtonListener());
        taskView.addDeleteButtonListener(new DeleteButtonListener());
    }
    
    class AddButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
           addTask.setVisible(true);
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
