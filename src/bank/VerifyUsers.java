package bank;

import javax.swing.JOptionPane;
import model.User;
import dao.UserDao;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.TableModel;
import java.sql.*;
import pagination.style.PaginationItemRenderStyle1;
import javax.swing.table.DefaultTableModel;
import swing.EventCallBack;
import swing.EventTextField;

public class VerifyUsers extends javax.swing.JFrame {

    public String userMail;
    DbOperations db;

    public VerifyUsers() {
        initComponents();
        pagination1.setPaginationItemRender(new PaginationItemRenderStyle1());
        pagination1.addEventPagination((int page) -> {
            getAllRecords("", page);
        });
    }

    public VerifyUsers(String useremail) {
        initComponents();
        userMail = useremail;
        pagination1.setPaginationItemRender(new PaginationItemRenderStyle1());
        pagination1.addEventPagination((int page) -> {
            getAllRecords("", page);
        });
        txtSearch.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                String email = txtSearch.getText();
                getAllRecords(email, 1);
            }

            @Override
            public void onCancel() {
                getAllRecords("", 1);
                txtSearch.setText("");
            }
        });
    }

    public void getAllRecords(String email, int page) {
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            int limit = 10;
            String sqlCount = "select count(*) from user";
            int count = 0;
            ResultSet r = db.getData(sqlCount);
            if(r.first()){
                count = r.getInt(1);
            }
            int totalPage = (int) Math.ceil(count/limit);
            pagination1.setPagegination(page, totalPage);
            ArrayList<User> list = new ArrayList<>();
            ResultSet rs = db.getData("select *from user where email like '%"+email+"%' limit "+(page-1)*limit+" ," + limit);
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setAddress(rs.getString("address"));
                user.setPassword(rs.getString("password"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
                user.setStatus(rs.getString("status"));
                list.add(user);
            }
            Iterator<User> itr = list.iterator();
            while (itr.hasNext()) {
                User userObj = itr.next();
                if (!userObj.getEmail().equals("admin@gmail.com")) {
                    dtm.addRow(new Object[]{userObj.getId(), userObj.getName(), userObj.getEmail(), userObj.getMobileNumber(), userObj.getAddress(), userObj.getPassword(), userObj.getSecurityQuestion(), userObj.getAnswer(), userObj.getStatus()});
                }
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        pagination1 = new pagination.Pagination();
        txtSearch = new swing.TextFieldAnimation();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/verify users.png"))); // NOI18N
        jLabel1.setText("Verify Users");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 26, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 13, 44, 43));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Email", "Mobile Number", "Address", "Password", "Security Question", "Answer", "Status"
            }
        ));
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 161, 1342, 488));

        jLabel3.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("*Click on row to change status");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 660, -1, -1));

        pagination1.setBackground(new java.awt.Color(0, 0, 255));
        pagination1.setForeground(new java.awt.Color(0, 0, 255));
        getContentPane().add(pagination1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 720, -1, -1));

        txtSearch.setAnimationColor(new java.awt.Color(0, 0, 255));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 476, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tinywow_SL-0212121-40670-68_7888141_1.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        new Home(userMail).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        UserDao operations = new UserDao();
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String email = model.getValueAt(index, 2).toString();
        String status = model.getValueAt(index, 8).toString();
        if (status.equals("true")) {
            status = "false";
        } else {
            status = "true";
        }
        int a = JOptionPane.showConfirmDialog(null, "Do you want to change status?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            operations.changeStatus(email, status);
            setVisible(false);
            new VerifyUsers(userMail).setVisible(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        getAllRecords("", 1);
    }//GEN-LAST:event_formComponentShown

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerifyUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private pagination.Pagination pagination1;
    private swing.TextFieldAnimation txtSearch;
    // End of variables declaration//GEN-END:variables
}
