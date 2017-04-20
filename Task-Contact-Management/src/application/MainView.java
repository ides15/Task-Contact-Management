/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractButton;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
/**
 *
 * @author reesmcdevitt
 */
public class MainView extends javax.swing.JPanel {

    private Database mainModel;
    private String date;
    private int rawMonth;
    private String month;
    private String day;
    private int rawDay;
    private int year;
    private String selectedDate;
    private DefaultTableModel model;
    private Object[] colNames;
    
    public MainView(Database mainModel) 
    {
        this.mainModel = mainModel;
        initComponents();
        
        //Calender 
        cal.getMonthChooser().removeAll();
        cal.getYearChooser().removeAll();
 
        rawMonth = cal.getMonthChooser().getMonth() + 1;
        
        if (rawMonth < 10)
           month = String.format("%02d", rawMonth);
        else
           month = String.valueOf(rawMonth);
        
        rawDay = cal.getDayChooser().getDay();
        
        if (rawDay < 10)
           day = String.format("%02d", rawDay);
        else
           day = String.valueOf(rawDay);
        
        
        
        year = cal.getYearChooser().getYear();
        date = month + "/" + day + "/" + year;
       
        
        dateLabel.setText(date);
        selectedDate = date;
        
        colNames = new Object[2];
        colNames[0] = "Task";
        colNames[1] = "Date";
        
        model = new DefaultTableModel()
        {
            public boolean isCellEditable(int row, int column)
            {
              return false;//This causes all cells to be not editable
            }
        };
              
       cal.getDayChooser().addPropertyChangeListener("day", new SelectedDate());
        

        //Search Bar
        searchBar.removeAllItems();
        searchBar.addItem("");     
        searchBar.setEditable(true);
        AutoCompleteDecorator.decorate(searchBar);
        removeButton(searchBar);
        searchBar.addActionListener(new SelectedTask());
        //searchBar.addMouseListener(new ClearText());

        
    }

//    class ClearText extends MouseAdapter
//    {
//        @Override
//                public void mouseClicked(MouseEvent e)
//                {
//                    searchBar.setSelectedIndex(0);
//                }
//    }
    
    class SelectedTask implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            setModel(new DefaultTableModel(mainModel.getTasks(mainModel.getCurrentUserId(), (String) searchBar.getSelectedItem()), colNames) //Change to Current USER
                    {
                        public boolean isCellEditable(int row, int column)
                        {
                            return false;//This causes all cells to be not editable
                        }
                    });

            taskTable.setModel(model);
        }
    }
    
    class SelectedDate implements PropertyChangeListener
    {

        @Override
        public void propertyChange(PropertyChangeEvent evt) 
        {
                int i = (Integer) evt.getNewValue();
                String monthPicked;
                String dayPicked;
                String datePicked;
                Object[][] noTasks = new Object[1][1];
                noTasks[0][0] = "No Tasks";
                
                if(i < 10)
                    dayPicked = "0" + String.valueOf(i);
                else
                    dayPicked = String.valueOf(i);
                
                if(rawMonth < 10)
                    monthPicked = "0" + String.valueOf(rawMonth);
                else
                    monthPicked = String.valueOf(rawMonth);
                
                datePicked = monthPicked + "/" + dayPicked + "/" + year;
                
                
                selectedDate = datePicked;
                dateLabel.setText(selectedDate);
                
                if(mainModel.getTaskDate(mainModel.getCurrentUserId(), getSelectedDate()).length != 0)
                {
                    setModel(new DefaultTableModel(mainModel.getTaskDate(mainModel.getCurrentUserId(), getSelectedDate()), getColNames()) //Change to Current USER
                    {
                        public boolean isCellEditable(int row, int column)
                        {
                            return false;//This causes all cells to be not editable
                        }
                    });
                }
                else
                {
                    setModel(new DefaultTableModel(noTasks, getColNames()) //Change to Current USER
                    {
                        public boolean isCellEditable(int row, int column)
                        {
                            return false;//This causes all cells to be not editable
                        }
                    });
                }

                getTaskTable().setModel(getModel());
        }
    
    
    }
    
    //Removes Button from JComboBox
    private void removeButton(Container container) {
      Component[] components = container.getComponents();
      for (Component component : components) {
         if (component instanceof AbstractButton) {
            container.remove(component);
         }
      }
   }
    
    
    /**
     * @return the model
     */
    public DefaultTableModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    /**
     * @return the selectedDate
     */
    public String getSelectedDate() {
        return selectedDate;
    }

    /**
     * @return the colNames
     */
    public Object[] getColNames() {
        return colNames;
    }

    /**
     * @return the taskTable
     */
    public javax.swing.JTable getTaskTable() {
        return taskTable;
    }

    /**
     * @param taskTable the taskTable to set
     */
    public void setTaskTable(javax.swing.JTable taskTable) {
        this.taskTable = taskTable;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cal = new com.toedter.calendar.JCalendar();
        dateLabel = new javax.swing.JLabel();
        monthUp = new javax.swing.JButton();
        monthDown = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taskTable = new javax.swing.JTable();
        searchBar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        dateLabel.setText("DATE");

        monthUp.setText(">");
        monthUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthUpActionPerformed(evt);
            }
        });

        monthDown.setText("<");
        monthDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthDownActionPerformed(evt);
            }
        });

        taskTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Test", "Test"
            }
        ));
        jScrollPane2.setViewportView(taskTable);

        searchBar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-icon.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(monthDown)
                .addGap(25, 25, 25)
                .addComponent(dateLabel)
                .addGap(25, 25, 25)
                .addComponent(monthUp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cal, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchBar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthDown)
                    .addComponent(dateLabel)
                    .addComponent(monthUp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cal, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(256, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void monthDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthDownActionPerformed
        //Changes Lable
        rawMonth = getMonth() - 1;
        if (getMonth() == 0)
        {
            rawMonth = 12;
            year = getYear() - 1;
        }
        
        if(rawMonth < 10)
            setDate("0" + getMonth() + "/01/" + getYear());
        else
            setDate(getMonth() + "/01/" + getYear());
      
        getDateLabel().setText(getDate());
        
        getCal().getMonthChooser().setMonth(getMonth() - 1);
        
    }//GEN-LAST:event_monthDownActionPerformed

    private void monthUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthUpActionPerformed
       ////Changes Lable
        rawMonth = getMonth() + 1;
        if (getMonth() == 13)
        {
            rawMonth = 1;
            year = getYear() + 1;
        }
        
        if(rawMonth < 10)
            setDate("0" + getMonth() + "/01" + "/" + getYear());
        else
            setDate(getMonth() + "/01/" + getYear());
      
        getDateLabel().setText(getDate());
        getCal().getMonthChooser().setMonth(getMonth() - 1);
    }//GEN-LAST:event_monthUpActionPerformed

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar cal;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton monthDown;
    private javax.swing.JButton monthUp;
    private javax.swing.JComboBox<String> searchBar;
    private javax.swing.JTable taskTable;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the mainModel
     */
    public Database getMainModel() {
        return mainModel;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return rawMonth;
    }

    /**
     * @return the day
     */
    public int getDay() {
        return rawDay;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @return the cal
     */
    public com.toedter.calendar.JCalendar getCal() {
        return cal;
    }

    /**
     * @return the monthDown
     */
    public javax.swing.JButton getMonthDown() {
        return monthDown;
    }

    /**
     * @return the monthUp
     */
    public javax.swing.JButton getMonthUp() {
        return monthUp;
    }

    /**
     * @return the searchBar
     */
    public javax.swing.JComboBox<String> getSearchBar() {
        return searchBar;
    }

    /**
     * @return the dateLabel
     */
    public javax.swing.JLabel getDateLabel() {
        return dateLabel;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @param dateLabel the dateLabel to set
     */
    public void setDateLabel(javax.swing.JLabel dateLabel) {
        this.dateLabel = dateLabel;
    }
}
