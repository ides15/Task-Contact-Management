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
import javax.swing.JPanel;

/**
 *
 * @author reesmcdevitt
 */
public class NavView extends JFrame
{
    private NavModel navModel;
    private NavViewPanel navPanel;
    
    
    private MainView mainView;
    private Database mainModel;
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
        
        mainModel = new Database("tcm.db");
        mainView = new MainView(mainModel);
        
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
    
    public void addLogoffButtonListener(ActionListener al)
    {
        navPanel.getLogoffButton().addActionListener(al);
    }
    
    // polymorphism ftw
    public void removePanel(JPanel panel) {
        if(panel != null) {
            remove(panel);
        }
    }
    
    //Main Panel
    public void addMainPanel(MainView mainView)
    {
        this.mainView= mainView;
        add(mainView, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    //Contact Panel
    public void addContactPanel(ContactView conView)
    {
        this.conView = conView;
        add(conView, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    //Task Panel
    public void addTaskPanel(TaskView taskView)
    {
        this.taskView = taskView;
        add(taskView, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    //Settings Panel
    public void addSettingsPanel(SettingsView setView)
    {
        this.setView = setView;
        add(setView, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
     //Switch Meathods
    
    public void switchToMainPanel(MainView MainView)
    { 
        removePanel(conView);
        removePanel(taskView);
        removePanel(setView);
        addMainPanel(MainView);
    }
    
    public void switchToContactPanel(ContactView conView)
    {        
        removePanel(mainView);
        removePanel(taskView);
        removePanel(setView);
        addContactPanel(conView);
    }
    
    public void switchToTaskPanel(TaskView taskView)
    {
        removePanel(conView);
        removePanel(mainView);
        removePanel(setView);
        addTaskPanel(taskView);
    }
    
    public void switchToSettingsPanel(SettingsView setView)
    {
        removePanel(conView);
        removePanel(mainView);
        removePanel(taskView);
        addSettingsPanel(setView);
    }
    
    
}
