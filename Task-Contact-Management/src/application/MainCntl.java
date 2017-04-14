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
public class MainCntl
{
    private Database mainModel;
    private MainView mainView;
    
    MainCntl(Database mainModel, MainView mainView)
    {
        this.mainModel = mainModel;
        this.mainView = mainView;
        
        
        
//        mainView.getMonthDown().addActionListener(new MonthDownListener());
//        mainView.getMonthUp().addActionListener(new MonthUpListener());
    }
    
//    class MonthUpListener implements ActionListener
//    {
//        public void actionPerformed(ActionEvent e) 
//        {
//           //Changes Lable
//            int month = mainView.getMonth();
//            int year = mainView.getYear();
//            month = month + 1;
//        
//            if (month == 0)
//            {
//                month = 12;
//                year = year + 1;
//            }
//
//            mainView.setDate(month + "/" + mainView.getDay() + "/" + year);
//            mainView.getDateLabel().setText(mainView.getDate());
//            mainView.getCal().getMonthChooser().setMonth(mainView.getMonth() + 1);
//        }
//    }
//    
//    class MonthDownListener implements ActionListener
//    {
//        public void actionPerformed(ActionEvent e) 
//        {
//           //Changes Lable
//            int month = mainView.getMonth();
//            int year = mainView.getYear();
//            month = month - 1;
//        
//            if (month == 0)
//            {
//                month = 12;
//                year = year - 1;
//            }
//
//            mainView.setDate(month + "/" + mainView.getDay() + "/" + year);
//            mainView.getDateLabel().setText(mainView.getDate());
//            mainView.getCal().getMonthChooser().setMonth(mainView.getMonth() - 1);
//        }
//    }

    /**
     * @return the mainModel
     */
    public Database getMainModel() {
        return mainModel;
    }

    /**
     * @return the mainView
     */
    public MainView getMainView() {
        return mainView;
    }
}
