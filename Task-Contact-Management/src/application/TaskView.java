/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author reesmcdevitt
 */
public class TaskView extends javax.swing.JPanel {

    /**
     * Creates new form TaskView
     */
    private Database taskModel;
    private AddTask addTask;
    private Object[] colNames;
    private DefaultTableModel model;
    private UpdateTask updateTask;
    
    
    public TaskView(Database taskModel) 
    {
        this.taskModel = taskModel;
        
        addTask = new AddTask();
        updateTask = new UpdateTask();
        
        initComponents();
        
        //Attempt to Populate JTable
        colNames = new Object[4];
        colNames[0] = "Task";
        colNames[1] = "Type";
        colNames[2] = "Due Date";
        colNames[3] = "Description";

       //Initilizes 
        model = new DefaultTableModel(taskModel.getTaskInfo(taskModel.getCurrentUserId()), getColNames())
        {
            public boolean isCellEditable(int row, int column)
            {
              return false;//This causes all cells to be not editable
            }
        };
        testTable.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        testTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(500, 500));
        setRequestFocusEnabled(false);

        testTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Task", "Due Date", "Type", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        testTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                testTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(testTable);
        if (testTable.getColumnModel().getColumnCount() > 0) {
            testTable.getColumnModel().getColumn(0).setMinWidth(1);
            testTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            testTable.getColumnModel().getColumn(0).setHeaderValue("Task");
            testTable.getColumnModel().getColumn(1).setMinWidth(1);
            testTable.getColumnModel().getColumn(1).setPreferredWidth(2);
            testTable.getColumnModel().getColumn(1).setHeaderValue("Due Date");
            testTable.getColumnModel().getColumn(2).setMinWidth(1);
            testTable.getColumnModel().getColumn(2).setPreferredWidth(2);
            testTable.getColumnModel().getColumn(2).setHeaderValue("Type");
            testTable.getColumnModel().getColumn(3).setMinWidth(1);
            testTable.getColumnModel().getColumn(3).setPreferredWidth(3);
            testTable.getColumnModel().getColumn(3).setHeaderValue("Description");
        }

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");

        updateButton.setText("Update");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed

    private void testTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_testTableMouseClicked
        int row = testTable.getSelectedRow();
        int col = 0;
        
        updateTask.taskNameField.setText(testTable.getValueAt(testTable.getSelectedRow(),0).toString());
        updateTask.dueDateField.setText(testTable.getValueAt(testTable.getSelectedRow(),2).toString());
        updateTask.TypeComboBox.setSelectedItem(testTable.getValueAt(testTable.getSelectedRow(),1).toString());
        updateTask.descriptionTextArea.setText(testTable.getValueAt(testTable.getSelectedRow(),3).toString());
    }//GEN-LAST:event_testTableMouseClicked

    public void addAddButtonListener(ActionListener al)
    {
        addButton.addActionListener(al);
    }
    
    public void addDeleteButtonListener(ActionListener al)
    {
        deleteButton.addActionListener(al);
       
    }
    public void addUpdateButtonListener(ActionListener al)
    {
        updateButton.addActionListener(al);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable testTable;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the addTask
     */
    public AddTask getAddTask() {
        return addTask;
    }

    /**
     * @return the TaskTabel
     */
    public javax.swing.JTable getTaskTable() {
        return testTable;
    }

    public UpdateTask getUpdateTask()
    {
        return updateTask;
    }
    /**
     * @param TaskTabel the TaskTabel to set
     */
    public void setTaskTabel(javax.swing.JTable TaskTabel) {
        this.testTable = TaskTabel;
    }

    /**
     * @return the colNames
     */
    public Object[] getColNames() {
        return colNames;
    }

    /**
     * @return the model
     */
    public DefaultTableModel getModel() {
        return model;
    }
}
