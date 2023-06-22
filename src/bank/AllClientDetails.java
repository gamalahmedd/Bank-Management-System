package bank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Client;
import pagination.style.PaginationItemRenderStyle1;
import swing.EventCallBack;
import swing.EventTextField;

public class AllClientDetails extends javax.swing.JFrame {

    private String usermail;
    DbOperations db;

    public AllClientDetails() {
        initComponents();
    }

    public AllClientDetails(String userMail) {
        initComponents();
        usermail = userMail;
        txtRegisterDate.setText("");
        pagination1.setPaginationItemRender(new PaginationItemRenderStyle1());
        pagination1.addEventPagination((int page) -> {
            getAllRecords("", page);
        });
        txtRegisterDate.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                String register = txtRegisterDate.getText();
                getAllRecords(register, 1);
            }

            @Override
            public void onCancel() {
                getAllRecords("", 1);
            }
        });
    }

    public void getAllRecords(String registerDate, int page) {
        db = new DbOperations();
        try {
            int limit = 10;
            String sqlCount = "select count(*) from client";
            int count = 0;
            ResultSet r = db.getData(sqlCount);
            if (r.first()) {
                count = r.getInt(1);
            }
            int totalPage = (int) Math.ceil(count / limit);
            pagination1.setPagegination(page, totalPage);
            ArrayList<Client> list = new ArrayList<>();
            ResultSet rs = db.getData("select *from client where registerdate like '%" + registerDate + "%' limit " + (page - 1) * limit + " ," + limit);
            while (rs.next()) {
                Client client = new Client();
                client.setClientId(String.valueOf(rs.getInt("clientId")));
                client.setName(rs.getString("name"));
                client.setCash(rs.getInt("cash"));
                client.setAddress(rs.getString("address"));
                client.setGender(rs.getString("gender"));
                client.setPhoneno(rs.getString("phoneno"));
                client.setDateofbirth(rs.getString("dateofbirth"));
                client.setNationalId(rs.getString("nationalId"));
                client.setEmail(rs.getString("email"));
                client.setNationality(rs.getString("nationality"));
                client.setCity(rs.getString("city"));
                client.setOccupation(rs.getString("occupation"));
                client.setRegisterdate(rs.getString("registerdate"));
                list.add(client);
            }
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            Iterator<Client> itr = list.iterator();
            while (itr.hasNext()) {
                Client clientObj = itr.next();
                dtm.addRow(new Object[] {clientObj.getClientId(),clientObj.getName(),clientObj.getCash(),clientObj.getAddress(),clientObj.getGender(),clientObj.getPhoneno(),clientObj.getDateofbirth(),clientObj.getNationalId(),clientObj.getEmail(),clientObj.getNationality(),clientObj.getCity(),clientObj.getOccupation(),clientObj.getRegisterdate()});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRegisterDate = new swing.TextFieldAnimation();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pagination1 = new pagination.Pagination();
        btnExit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("All Client Details");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Register Date:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("YYYY-MM-DD");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 160, -1, -1));

        txtRegisterDate.setAnimationColor(new java.awt.Color(0, 0, 255));
        getContentPane().add(txtRegisterDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 474, -1));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Cash", "Address", "Gender", "Phone Number", "Date Of Birth", "National ID", "Email", "Nationality", "City", "Occupation", "Register Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 215, 1342, 451));

        pagination1.setBackground(new java.awt.Color(0, 0, 255));
        pagination1.setForeground(new java.awt.Color(0, 0, 255));
        getContentPane().add(pagination1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 720, -1, -1));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, 50, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tinywow_SL-0212121-40670-68_7888141_1.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        setVisible(false);
        new Home(usermail).setVisible(true);
    }//GEN-LAST:event_btnExitActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        getAllRecords("", 1);
    }//GEN-LAST:event_formComponentShown

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllClientDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private pagination.Pagination pagination1;
    private swing.TextFieldAnimation txtRegisterDate;
    // End of variables declaration//GEN-END:variables
}
