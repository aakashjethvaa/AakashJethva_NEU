/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.ProfessorRole;

import Business.Assignment.Assignment;
import Business.Assignment.AssignmentDirectory;
import Business.AssignmentSubmission.Submission;
import Business.AssignmentSubmission.SubmissionDirectory;
import Business.College.Program;
import Business.Courses.Courses;
import Business.Marks.Marks;
import Business.Marks.MarksDirectory;
import Business.Organization.CollegeOrganization;
import Business.Role.StudentRole;
import Business.Role.TARequest;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karan
 */
public class GradeJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AssignTAJPanel
     */
    JPanel userProcessContainer;
    CollegeOrganization organization;
    UserAccount userAccount;
    Program program;
    String uname;

    GradeJPanel(JPanel userProcessContainer, Program program, UserAccount userAccount, CollegeOrganization organization, String username) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.program = program;
        this.userAccount = userAccount;
        this.organization = (CollegeOrganization) organization;
        this.uname = username;
        populateCourses();
        populateGrade();
        // populateStudents();
        //populateTable();
        //populateRequest();

        tblTA.getTableHeader().setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));

        tblTARequest.getTableHeader().setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));

    }

    public void populateGrade() {
        cmbGrade.removeAllItems();
        cmbGrade.addItem(new String("A"));
        cmbGrade.addItem(new String("A-"));
        cmbGrade.addItem(new String("B+"));
        cmbGrade.addItem(new String("B"));
        cmbGrade.addItem(new String("C"));
        cmbGrade.addItem(new String("F"));

    }

    public void populateTable(UserAccount stu) {
        DefaultTableModel model = (DefaultTableModel) tblTA.getModel();
        model.setRowCount(0);

        //for (Program pd : .getPD().getDirectory()) {
        Courses cr = (Courses) cmbCousreName.getSelectedItem();

        AssignmentDirectory adir = cr.getAssignment();
        for (Assignment ad : adir.getAssignmentDirectory()) {
            SubmissionDirectory sd = ad.getSubmissionDirectory();
            Boolean flag = false;
            Object[] row = new Object[4];
            row[0] = ad.getTitle();
            row[3] = ad.getMaxScore();
            for (Submission ss : sd.getSubmission()) {
                if (ss.getStudent().getId() == stu.getId()) {
                    row[1] = ss.getPath();
                    row[2] = ss.getMarks();

                    flag = true;
                }
            }
            if (!flag) {
                row[1] = "NA";
                row[2] = "NA";
            }

            model.addRow(row);
        }

        /* Object[] row = new Object[3];
        for (UserAccount ua : cr.getTeachingAssistant()) {

            row[0] = ua;
            row[1] = cr.getCourseName();
            row[2] = cr.getProgram().getName();
            model.addRow(row);
        }*/
    }

    public void populateRequest() {
        DefaultTableModel model = (DefaultTableModel) tblTARequest.getModel();
        model.setRowCount(0);

        //for (Program pd : .getPD().getDirectory()) {
        Courses cr = (Courses) cmbCousreName.getSelectedItem();
        Object[] row = new Object[4];
        for (TARequest tt : cr.getRequests()) {

            row[0] = tt.getUa().getEmployee().getName();
            row[1] = tt.getCourse().getCourseName();
            row[2] = tt.getProgram().getName();
            row[3] = tt.getStatus();
            model.addRow(row);
        }
    }

    public void populateCourses() {
        cmbCousreName.removeAllItems();
        //CourseDirectory cd = program.getCourses();
        for (Program pd : organization.getPD().getDirectory()) {
            for (Courses c : pd.getCourses().getCourseList()) {
                if (c.getProfessor().getUsername().equals(uname) && c.getApprovalStatus().equals("Approved")) {
                    cmbCousreName.addItem(c);
                }
            }
        }

    }

    public void populateStudents() {

        DefaultTableModel dtm = (DefaultTableModel) tblTARequest.getModel();
        dtm.setRowCount(0);
        Courses cr = (Courses) cmbCousreName.getSelectedItem();
        MarksDirectory mdir = cr.getMarks();
        for (UserAccount ua : cr.getStudents()) {

            if (ua.getRole() instanceof StudentRole) {

                Object[] row = new Object[2];
                row[0] = ua;
                Boolean flag = false;
                for (Marks m : mdir.getMarksList()) {
                    if (m.getStudent().getId() == ua.getId()) {
                        flag = true;
                        row[1] = m.getMarks();
                    }
                }
                if (!flag) {
                    row[1] = "Not graded";
                }

                dtm.addRow(row);

            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAssignTA = new javax.swing.JButton();
        cmbCousreName = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTA = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTARequest = new javax.swing.JTable();
        backbtn = new javax.swing.JButton();
        cmbGrade = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        btnGrade = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Grade Students");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Course Name:");

        btnAssignTA.setBackground(new java.awt.Color(51, 153, 255));
        btnAssignTA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAssignTA.setForeground(new java.awt.Color(255, 255, 255));
        btnAssignTA.setText("View Course Work");
        btnAssignTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignTAActionPerformed(evt);
            }
        });

        cmbCousreName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCousreNameActionPerformed(evt);
            }
        });
        cmbCousreName.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbCousreNamePropertyChange(evt);
            }
        });

        tblTA.setAutoCreateRowSorter(true);
        tblTA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblTA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Assignment", "Submission", "Marks", "Total Marks"
            }
        ));
        tblTA.setRowHeight(20);
        jScrollPane1.setViewportView(tblTA);

        tblTARequest.setAutoCreateRowSorter(true);
        tblTARequest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblTARequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Student", "Graded"
            }
        ));
        tblTARequest.setRowHeight(20);
        jScrollPane2.setViewportView(tblTARequest);

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

        cmbGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGradeActionPerformed(evt);
            }
        });
        cmbGrade.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbGradePropertyChange(evt);
            }
        });

        jLabel3.setText("Grade :");

        btnGrade.setBackground(new java.awt.Color(51, 153, 255));
        btnGrade.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGrade.setForeground(new java.awt.Color(255, 255, 255));
        btnGrade.setText("Grade Student");
        btnGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGradeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cmbCousreName, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAssignTA))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGrade)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbCousreName, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAssignTA, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGrade)
                    .addComponent(jLabel3)
                    .addComponent(btnGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(backbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCousreNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCousreNameActionPerformed
        // TODO add your handling code here:

        populateStudents();

    }//GEN-LAST:event_cmbCousreNameActionPerformed

    private void cmbCousreNamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbCousreNamePropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbCousreNamePropertyChange

    private void btnAssignTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignTAActionPerformed
        // TODO add your handling code here:
        //CourseDirectory cd = program.getCourses();
        int selected = tblTARequest.getSelectedRow();
        if (selected >= 0) {
            UserAccount ua = (UserAccount) tblTARequest.getValueAt(selected, 0);
            populateTable(ua);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a student");
        }

    }//GEN-LAST:event_btnAssignTAActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backbtnActionPerformed

    private void cmbGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGradeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbGradeActionPerformed

    private void cmbGradePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbGradePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGradePropertyChange

    private void btnGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGradeActionPerformed
        // TODO add your handling code here:
        int selected = tblTARequest.getSelectedRow();
        if (selected >= 0) {

            Courses cr = (Courses) cmbCousreName.getSelectedItem();
            UserAccount ua = (UserAccount) tblTARequest.getValueAt(selected, 0);
            String grade = (String) cmbGrade.getSelectedItem();
            MarksDirectory mdir = cr.getMarks();
            if (mdir.checkStudent(ua) instanceof Marks) {
                Marks mm = mdir.checkStudent(ua);
                mm.setMarks(grade);
            } else {
                Marks m = mdir.addMarks(ua, grade);
            }
            JOptionPane.showMessageDialog(null, "Graded Successfully");
            populateStudents();
            ua.createFeeds("You have been graded by the professor for course " + cr.getCourseName());
        } else {

            JOptionPane.showMessageDialog(null, "Please select a student");
        }
    }//GEN-LAST:event_btnGradeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JButton btnAssignTA;
    private javax.swing.JButton btnGrade;
    private javax.swing.JComboBox cmbCousreName;
    private javax.swing.JComboBox cmbGrade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblTA;
    private javax.swing.JTable tblTARequest;
    // End of variables declaration//GEN-END:variables
}
