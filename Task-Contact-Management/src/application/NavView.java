/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author reesmcdevitt
 */
public class NavView extends JFrame
{
    private NavModel navModel;
    private NavViewPanel navPanel;
    
    
    private MainView mainView;
    private ContactView conView;
    private TaskView taskView;
    private SettingsView setView;
    
    
    NavView(NavModel navModel) 
    {
        super("Manager");
        this.navModel = navModel;
        
        BorderLayout border = new BorderLayout();
        setLayout(border);
        navPanel = new NavViewPanel();
        mainView = new MainView();
        
        
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(navPanel, BorderLayout.NORTH);
        add(mainView, BorderLayout.CENTER);
    }
    
    public void addMainButtonListener(ActionListener al)
    {
        navPanel.getMainButton().addActionListener(al);
    }
    
    public void addContactButtonListener(ActionListener al)
    {
        navPanel.getContactButton().addActionListener(al);
    }
    
    public void addTaskButtonListener(ActionListener al)
    {
        navPanel.getTaskButton().addActionListener(al);
    }
     
    public void addSettingsButtonListener(ActionListener al)
    {
        navPanel.getSettingsButton().addActionListener(al);
    }
    
    //Main Panel
    public void addMainPanel(MainView mainView)
    {
        this.mainView= mainView;
        add(mainView, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    public void removeMainPanel()
    {
        if(this.mainView != null)
        {
            remove(this.mainView);
        }
    }
    
    //Contact Panel
    public void addContactPanel(ContactView conView)
    {
        this.conView = conView;
        add(conView, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    public void removeContactPanel()
    {
        if(this.conView != null)
        {
            remove(this.conView);
        }
    }
    
    //Task Panel
    public void addTaskPanel(TaskView taskView)
    {
        this.taskView = taskView;
        add(taskView, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    public void removeTaskPanel()
    {
        if(this.taskView != null)
        {
            remove(this.taskView);
        }
    }
    
    //Settings Panel
    public void addSettingsPanel(SettingsView setView)
    {
        this.setView = setView;
        add(setView, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    public void removeSettingsPanel()
    {
        if(this.setView != null)
        {
            remove(this.setView);
        }
    }
    
     //Switch Meathods
    
    public void switchToMainPanel(MainView MainView)
    { 
        removeContactPanel();
        removeTaskPanel();
        removeSettingsPanel();
        addMainPanel(MainView);
    }
    
    public void switchToContactPanel(ContactView conView)
    {        
        removeMainPanel();
        removeTaskPanel();
        removeSettingsPanel();
        addContactPanel(conView);
    }
    
    public void switchToTaskPanel(TaskView taskView)
    {
        removeContactPanel();
        removeMainPanel();
        removeSettingsPanel();
        addTaskPanel(taskView);
    }
    
    public void switchToSettingsPanel(SettingsView setView)
    {
        removeContactPanel();
        removeMainPanel();
        removeTaskPanel();
        addSettingsPanel(setView);
    }
    
    
}
