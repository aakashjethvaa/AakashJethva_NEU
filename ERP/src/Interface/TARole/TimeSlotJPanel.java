/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.TARole;

import Business.Assignment.Assignment;
import Business.College.Program;
import Business.Courses.Courses;
import Business.Organization.CollegeOrganization;
import Business.TimeSlots.TimeSlots;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author krunal
 */
public class TimeSlotJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AnouncementJPanel
     */
    JPanel userProcessContainer;
    CollegeOrganization organization;
    UserAccount userAccount;
    Program program;
    Courses course;

    public TimeSlotJPanel(JPanel userProcessContainer, Program program, UserAccount userAccount, CollegeOrganization organization, Courses course) {

        this.userProcessContainer = userProcessContainer;
        this.organization = (CollegeOrganization) organization;
        this.userAccount = userAccount;
        this.program = program;
        this.course = course;
        initComponents();

        populateCombo();

        tblSlots.getTableHeader().setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));

        populateCmbStart();
        populatecmbEnd();
    }

    public void populateCombo() {
        cmbAssignment.removeAllItems();
        System.out.println(course.getCourseName());
        for (Assignment as : course.getAssignment().getAssignmentDirectory()) {
            cmbAssignment.addItem(as);
        }
    }

    public void populateTable(Assignment as) {
        DefaultTableModel dtm = (DefaultTableModel) tblSlots.getModel();
        dtm.setRowCount(0);

        for (TimeSlots ts : as.getSlots().getSlots()) {
            Object[] row = new Object[6];
            row[0] = as.getTitle();
            row[1] = ts.getDate();
            row[2] = ts.getStart();
            row[3] = ts.getEnd();
            row[4] = ts.getStatus();
            if (ts.getStudent() instanceof UserAccount) {
                row[5] = ts.getStudent();

            } else {
                row[5] = "NA";
            }
            dtm.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSlots = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cmbAssignment = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        cmbStartTime = new javax.swing.JComboBox<>();
        cmbEndTime = new javax.swing.JComboBox<>();
        jDate = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Time Slots");

        btnSubmit.setBackground(new java.awt.Color(51, 153, 255));
        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        tblSlots.setAutoCreateRowSorter(true);
        tblSlots.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblSlots.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Assignment", "Date", "Start Time", "End Time", "Status", "Student"
            }
        ));
        tblSlots.setRowHeight(20);
        jScrollPane2.setViewportView(tblSlots);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Assignment :");

        cmbAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAssignmentActionPerformed(evt);
            }
        });
        cmbAssignment.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbAssignmentPropertyChange(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Start Time :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Date :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("End Time :");

        btnDelete.setBackground(new java.awt.Color(51, 153, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Remove");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        backbtn.setBackground(new java.awt.Color(51, 153, 255));
        backbtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backbtn.setForeground(new java.awt.Color(255, 255, 255));
        backbtn.setText("<<Back");
        backbtn.setToolTipText("");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        cmbStartTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbEndTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSubmit)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cmbEndTime, javax.swing.GroupLayout.Alignment.LEADING, 0, 96, Short.MAX_VALUE)
                                        .addComponent(cmbStartTime, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnDelete)
                            .addGap(36, 36, 36))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cmbAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnSubmit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:

        /*if (txtStart.getText().isEmpty() || txtEnd.getText().isEmpty() || txtDate.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the details");
            return;
        }
         */
        if (cmbAssignment.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Please select Assignment");
            return;
        }

        String s = (String) cmbStartTime.getSelectedItem();
        s = s.replace(":", "");
        int st = Integer.parseInt(s);

        String e = (String) cmbEndTime.getSelectedItem();
        e = e.replace(":", "");
        int et = Integer.parseInt(e);
        if (et < st) {
            JOptionPane.showMessageDialog(null, "End time cannot be less then start time");
            return;
        }

        Assignment as = (Assignment) cmbAssignment.getSelectedItem();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date departDate = jDate.getDate();
        String dd = df.format(departDate);
        if (dd.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select date");
            return;
        }

        TimeSlots ts = as.getSlots().addTimeSlot(String.valueOf(cmbStartTime.getSelectedItem()), String.valueOf(cmbEndTime.getSelectedItem()), dd, "Empty", userAccount);
        ts.setAssignment(as);
        JOptionPane.showMessageDialog(null, "Submitted Successfully");
        populateTable(as);

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void cmbAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAssignmentActionPerformed
        // TODO add your handling code here:

        Assignment as = (Assignment) cmbAssignment.getSelectedItem();
        populateTable(as);
        /*        Object obj = evt.getSource();
        if (obj == cmbCousreName) {
            cmbStudentsName.removeAllItems();
            for(Program pd : organization.getPD().getDirectory()){
                for (Courses c : pd.getCourses().getCourseList()) {
                    for (UserAccount ua : c.getStudents()) {
                        String courseName = String.valueOf(cmbCousreName.getSelectedItem());
                        if (c.getCourseName().equals(courseName)) {
                            cmbStudentsName.addItem(ua);
                        }
                    }
                }
            }
        }
         */
    }//GEN-LAST:event_cmbAssignmentActionPerformed

    private void cmbAssignmentPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbAssignmentPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAssignmentPropertyChange

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selected = tblSlots.getSelectedRow();
        if (selected >= 0) {
            Assignment as = (Assignment) cmbAssignment.getSelectedItem();
            TimeSlots ts = (TimeSlots) tblSlots.getValueAt(selected, 0);
            as.getSlots().removeTimeSlots(ts);

            populateTable(as);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        TAWorkAreaJPanel panel = (TAWorkAreaJPanel) component;
        panel.populateTable();
        panel.populateFeeds();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backbtnActionPerformed

    public void populateCmbStart() {
        cmbStartTime.removeAllItems();
        cmbStartTime.addItem("10:00");
        cmbStartTime.addItem("10:15");
        cmbStartTime.addItem("10:30");
        cmbStartTime.addItem("10:45");
        cmbStartTime.addItem("11:00");
        cmbStartTime.addItem("11:15");
        cmbStartTime.addItem("11:30");
        cmbStartTime.addItem("11:45");
        cmbStartTime.addItem("12:00");
        cmbStartTime.addItem("12:15");
        cmbStartTime.addItem("12:30");
        cmbStartTime.addItem("12:45");
        cmbStartTime.addItem("13:00");
        cmbStartTime.addItem("13:15");
        cmbStartTime.addItem("13:30");
        cmbStartTime.addItem("13:45");
        cmbStartTime.addItem("14:00");
        cmbStartTime.addItem("14:15");
        cmbStartTime.addItem("14:30");
        cmbStartTime.addItem("14:45");
        cmbStartTime.addItem("15:00");
        cmbStartTime.addItem("15:15");
        cmbStartTime.addItem("15:30");
        cmbStartTime.addItem("15:45");
        cmbStartTime.addItem("16:00");
        cmbStartTime.addItem("16:15");
        cmbStartTime.addItem("16:30");
        cmbStartTime.addItem("16:45");
        cmbStartTime.addItem("17:00");
        cmbStartTime.addItem("17:15");
        cmbStartTime.addItem("17:30");
        cmbStartTime.addItem("17:45");
        cmbStartTime.addItem("18:00");
    }

    public void populatecmbEnd() {
        cmbEndTime.removeAllItems();
        cmbEndTime.addItem("10:00");
        cmbEndTime.addItem("10:15");
        cmbEndTime.addItem("10:30");
        cmbEndTime.addItem("10:45");
        cmbEndTime.addItem("11:00");
        cmbEndTime.addItem("11:15");
        cmbEndTime.addItem("11:30");
        cmbEndTime.addItem("11:45");
        cmbEndTime.addItem("12:00");
        cmbEndTime.addItem("12:15");
        cmbEndTime.addItem("12:30");
        cmbEndTime.addItem("12:45");
        cmbEndTime.addItem("13:00");
        cmbEndTime.addItem("13:15");
        cmbEndTime.addItem("13:30");
        cmbEndTime.addItem("13:45");
        cmbEndTime.addItem("14:00");
        cmbEndTime.addItem("14:15");
        cmbEndTime.addItem("14:30");
        cmbEndTime.addItem("14:45");
        cmbEndTime.addItem("15:00");
        cmbEndTime.addItem("15:15");
        cmbEndTime.addItem("15:30");
        cmbEndTime.addItem("15:45");
        cmbEndTime.addItem("16:00");
        cmbEndTime.addItem("16:15");
        cmbEndTime.addItem("16:30");
        cmbEndTime.addItem("16:45");
        cmbEndTime.addItem("17:00");
        cmbEndTime.addItem("17:15");
        cmbEndTime.addItem("17:30");
        cmbEndTime.addItem("17:45");
        cmbEndTime.addItem("18:00");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox cmbAssignment;
    private javax.swing.JComboBox<String> cmbEndTime;
    private javax.swing.JComboBox<String> cmbStartTime;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblSlots;
    // End of variables declaration//GEN-END:variables
}
