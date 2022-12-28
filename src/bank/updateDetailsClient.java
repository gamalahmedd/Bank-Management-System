package bank;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.ClientDao;
import model.Client;

public class updateDetailsClient extends javax.swing.JFrame {

    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobileNumberPattern = "^01[0125][0-9]{8}$";
    public String NI = "^([1-9]{1})([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})[0-9]{3}([0-9]{1})[0-9]{1}$";
    public String DOB = "^(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])-[0-9]{4}$";
    private String ID = null;
    public String userMail;
    
    public updateDetailsClient() {
        initComponents();
    }
    public updateDetailsClient(String useremail){
        initComponents();
        btnUpdate.setEnabled(false);
        btnSearch.setEnabled(false);
        txtName.setEditable(false);
        SpinCash.setEnabled(false);
        txtAddress.setEditable(false);
        txtGender.setEditable(false);
        txtPhoneNumber.setEditable(false);
        txtDOB.setEditable(false);
        txtNationalID.setEditable(false);
        txtEmail.setEditable(false);
        txtNationality.setEditable(false);
        txtCity.setEditable(false);
        txtOccupation.setEditable(false);
        txtRegister.setEditable(false);
        btnUpdate.setEnabled(false);
        btnSearch.setEnabled(false);
        txtName.setEditable(false);
        SpinCash.setEnabled(false);
        txtAddress.setEditable(false);
        txtGender.setEditable(false);
        txtPhoneNumber.setEditable(false);
        txtDOB.setEditable(false);
        txtNationalID.setEditable(false);
        txtEmail.setEditable(false);
        txtNationality.setEditable(false);
        txtCity.setEditable(false);
        txtOccupation.setEditable(false);
        txtRegister.setEditable(false);
        userMail = useremail;
    }

    public void EnableFields(){
        btnSearch.setEnabled(false);
        txtName.setEditable(true);
        txtAddress.setEditable(true);
        txtGender.setEditable(true);
        txtPhoneNumber.setEditable(true);
        txtDOB.setEditable(true);
        txtNationalID.setEditable(true);
        txtEmail.setEditable(true);
        txtNationality.setEditable(true);
        txtCity.setEditable(true);
        txtOccupation.setEditable(true);
        txtRegister.setEditable(true);
    }
    public void validateID(){
        ID = txtClientID.getText();
        if(!ID.equals("")){
            btnSearch.setEnabled(true);
        }
        else
            btnSearch.setEnabled(false);
    }
    public void validateFields(){
        String name = txtName.getText();
        String address = txtAddress.getText();
        String gender = txtGender.getText();
        String phoneno = txtPhoneNumber.getText();
        String dateofbirth = txtDOB.getText();
        String nationalId = txtNationalID.getText();
        String email = txtEmail.getText();
        String nationality = txtNationality.getText();
        String city = txtCity.getText();
        String occupation = txtOccupation.getText();
        String registerdate = txtRegister.getText();
        if(!name.equals("") && !address.equals("") && !gender.equals("") && phoneno.matches(mobileNumberPattern) && dateofbirth.matches(DOB) && nationalId.matches(NI) && email.matches(emailPattern) && !nationality.equals("") && !city.equals("") && !occupation.equals("") && registerdate.matches(DOB)){
            btnUpdate.setEnabled(true);
        }
        else
            btnUpdate.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtClientID = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        SpinCash = new javax.swing.JSpinner();
        txtAddress = new javax.swing.JTextField();
        txtGender = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        txtDOB = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNationalID = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNationality = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtOccupation = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        btnUpdate = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtRegister = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(600, 200));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel1.setText("Update Client Details");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 75, 700, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Client ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 100, 80, -1));

        txtClientID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtClientID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClientIDKeyReleased(evt);
            }
        });
        getContentPane().add(txtClientID, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 97, 178, -1));

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search1.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 97, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 136, 700, 9));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Full Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 166, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Cash");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 214, 37, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Address:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 262, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Gender:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 314, 58, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Phone Number:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 368, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Date of Birth:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 417, -1, -1));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 163, 216, -1));

        SpinCash.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(SpinCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 211, 216, -1));

        txtAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddressKeyReleased(evt);
            }
        });
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 259, 216, -1));

        txtGender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGenderKeyReleased(evt);
            }
        });
        getContentPane().add(txtGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 311, 216, -1));

        txtPhoneNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPhoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneNumberKeyReleased(evt);
            }
        });
        getContentPane().add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 365, 214, -1));

        txtDOB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDOB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDOBKeyReleased(evt);
            }
        });
        getContentPane().add(txtDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 414, 214, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("National ID:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Email");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 43, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Nationality:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("City:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 43, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Occupation:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, -1, 20));

        txtNationalID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNationalID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNationalIDKeyReleased(evt);
            }
        });
        getContentPane().add(txtNationalID, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 230, 30));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 230, -1));

        txtNationality.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNationality.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNationalityKeyReleased(evt);
            }
        });
        getContentPane().add(txtNationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 258, 230, -1));

        txtCity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCityKeyReleased(evt);
            }
        });
        getContentPane().add(txtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 230, -1));

        txtOccupation.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtOccupation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOccupationKeyReleased(evt);
            }
        });
        getContentPane().add(txtOccupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 366, 235, 30));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 452, 700, 10));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save_1.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Update details.png"))); // NOI18N
        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, -1, -1));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Exit application.png"))); // NOI18N
        jButton4.setText("Close");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Register Date:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 417, 95, -1));

        txtRegister.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 417, 218, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/all page background image.png"))); // NOI18N
        jLabel14.setText("jLabel14");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    static Connection con;
    static Statement st;
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setVisible(false);
        new Home(userMail).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setVisible(false);
        new updateDetailsClient(userMail).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Client client = new Client();
        client.setClientId(txtClientID.getText());
        client.setName(txtName.getText());
        client.setCash((int)SpinCash.getValue());
        client.setAddress(txtAddress.getText());
        client.setGender(txtGender.getText());
        client.setPhoneno(txtPhoneNumber.getText());
        client.setDateofbirth(txtDOB.getText());
        client.setNationalId(txtNationalID.getText());
        client.setEmail(txtEmail.getText());
        client.setNationality(txtNationality.getText());
        client.setCity(txtCity.getText());
        client.setOccupation(txtOccupation.getText());
        client.setRegisterdate(txtRegister.getText());
        ClientDao.update(client);
        setVisible(false);
        new updateDetailsClient(userMail).setVisible(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String clientId = txtClientID.getText();
        try{
            ResultSet rs = ClientDao.searchUpdate(clientId);
            if(rs.next())
            {
                txtName.setText(rs.getString("name"));
                SpinCash.setValue(rs.getInt("cash"));
                txtAddress.setText(rs.getString("address"));
                txtGender.setText(rs.getString("gender"));
                txtPhoneNumber.setText(rs.getString("phoneno"));
                txtDOB.setText(rs.getString("dateofbirth"));
                txtNationalID.setText(rs.getString("nationalId"));
                txtEmail.setText(rs.getString("email"));
                txtNationality.setText(rs.getString("nationality"));
                txtCity.setText(rs.getString("city"));
                txtOccupation.setText(rs.getString("occupation"));
                txtRegister.setText(rs.getString("registerdate"));
                txtClientID.setEditable(false);
                EnableFields();
            }
            else
                JOptionPane.showMessageDialog(null, "Client ID does not exist");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        validateFields();
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyReleased
        validateFields();
    }//GEN-LAST:event_txtAddressKeyReleased

    private void txtGenderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGenderKeyReleased
        validateFields();
    }//GEN-LAST:event_txtGenderKeyReleased

    private void txtPhoneNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneNumberKeyReleased
        validateFields();
    }//GEN-LAST:event_txtPhoneNumberKeyReleased

    private void txtNationalIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNationalIDKeyReleased
        validateFields();
    }//GEN-LAST:event_txtNationalIDKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        validateFields();
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtNationalityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNationalityKeyReleased
        validateFields();
    }//GEN-LAST:event_txtNationalityKeyReleased

    private void txtCityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCityKeyReleased
        validateFields();
    }//GEN-LAST:event_txtCityKeyReleased

    private void txtClientIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClientIDKeyReleased
        validateID();
    }//GEN-LAST:event_txtClientIDKeyReleased

    private void txtDOBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDOBKeyReleased
        validateFields();
    }//GEN-LAST:event_txtDOBKeyReleased

    private void txtOccupationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOccupationKeyReleased
        validateFields();
    }//GEN-LAST:event_txtOccupationKeyReleased

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateDetailsClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SpinCash;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtClientID;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNationalID;
    private javax.swing.JTextField txtNationality;
    private javax.swing.JTextField txtOccupation;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtRegister;
    // End of variables declaration//GEN-END:variables
}
