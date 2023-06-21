package bank;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Client;
import dao.ClientDao;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class addNewClient extends javax.swing.JFrame {

    public static String emailPattern = "^[A-Za-z]{5}\\d+@[A-Za-z]+\\.[A-Za-z]{2,6}$"; //valid email -> gemyy555@gmail.com
    public String mobileNumberPattern = "^01[0125][0-9]{8}$"; //maximum 11 digit, must start with 01[0125]
    public static String namePattern = "^[A-Z][a-z]*(\\s+[A-Z][a-z]*)*$"; // valid name -> Gamal Ahmed
    public String NI = "^([1-9]{1})([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})[0-9]{3}([0-9]{1})[0-9]{1}$";
    public static String addressPattern = "^(\\d{1,}) [a-zA-Z0-9\\s]+(,)? [a-zA-Z]+(/s)?+[a-zA-Z]+(,)? [A-Z]{2} [0-9]{5,6}$";
    public static String IDPattern = "^[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89ab][a-f0-9]{3}-[a-f0-9]{12}$";
    public String userMail;
    boolean flag = true;

    public addNewClient() {
        initComponents();
    }

    public addNewClient(String useremail) {
        initComponents();
        btnSave.setEnabled(false);
        SpinCash.setEnabled(false);
        userMail = useremail;
    }

    public void validateFields() {
        String clientId = jLabel8.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String phoneno = txtPhoneNumber.getText();
        String nationalId = txtNationalID.getText();
        String email = txtEmail.getText();
        String nationality = txtNationality.getText();
        String city = txtCity.getText();
        String occupation = txtOccupation.getText();
        if (clientId.matches(IDPattern) && name.matches(namePattern) && address.matches(addressPattern) && phoneno.matches(mobileNumberPattern) && nationalId.matches(NI) && email.matches(emailPattern) && !nationality.equals("") && !city.equals("") && !occupation.equals("")) {
            btnSave.setEnabled(true);
        } else {
            btnSave.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        CombGender = new javax.swing.JComboBox<>();
        txtPhoneNumber = new javax.swing.JTextField();
        SpinCash = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnSave = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNationalID = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNationality = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtOccupation = new javax.swing.JTextField();
        txtDOB = new com.toedter.calendar.JDateChooser();
        txtRegister = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(600, 200));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel1.setText("Add New Client");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 15, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 69, 700, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Full Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Cash:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 188, 37, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("New Client ID:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 85, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Address");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 234, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Gender:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 282, 61, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Phone Number:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 334, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 153, 255));
        jLabel8.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jLabel8ComponentShown(evt);
            }
        });
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 85, 32, -1));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 137, 208, -1));

        txtAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddressKeyReleased(evt);
            }
        });
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 231, 208, -1));

        CombGender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CombGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        getContentPane().add(CombGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 279, 208, -1));

        txtPhoneNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumberActionPerformed(evt);
            }
        });
        txtPhoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneNumberKeyReleased(evt);
            }
        });
        getContentPane().add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 331, 205, -1));

        SpinCash.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(SpinCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 185, 208, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Date Of Birth:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 391, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 442, 688, 10));

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save_1.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 464, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Update details.png"))); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 464, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Exit application.png"))); // NOI18N
        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 464, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("National ID:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 140, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Email:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 188, 43, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Nationality:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 234, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("City:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 282, 43, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Occupation:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 334, 82, -1));

        txtNationalID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNationalID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNationalIDKeyReleased(evt);
            }
        });
        getContentPane().add(txtNationalID, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 137, 207, -1));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 185, 207, -1));

        txtNationality.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNationality.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNationalityKeyReleased(evt);
            }
        });
        getContentPane().add(txtNationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 231, 207, -1));

        txtCity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCityKeyReleased(evt);
            }
        });
        getContentPane().add(txtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 279, 207, -1));

        txtOccupation.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtOccupation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOccupationKeyReleased(evt);
            }
        });
        getContentPane().add(txtOccupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 331, 207, -1));
        getContentPane().add(txtDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 391, 205, -1));
        getContentPane().add(txtRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 389, 196, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Register Date:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 391, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/all page background image.png"))); // NOI18N
        jLabel17.setText("jLabel17");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    static Connection con;
    static Statement st;
    private void jLabel8ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel8ComponentShown

    }//GEN-LAST:event_jLabel8ComponentShown

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setVisible(false);
        new Home(userMail).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        new addNewClient(userMail).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Client client = new Client();
        client.setClientId(jLabel8.getText());
        client.setName(txtName.getText());
        client.setCash((int) SpinCash.getValue());
        client.setAddress(txtAddress.getText());
        client.setGender((String) CombGender.getSelectedItem());
        client.setPhoneno(txtPhoneNumber.getText());
        SimpleDateFormat Date = new SimpleDateFormat("yyyy-MM-dd");
        String dateofbirth = Date.format(txtDOB.getDate());
        client.setDateofbirth(dateofbirth);
        client.setNationalId(txtNationalID.getText());
        client.setEmail(txtEmail.getText());
        client.setNationality(txtNationality.getText());
        client.setCity(txtCity.getText());
        client.setOccupation(txtOccupation.getText());
        String register = Date.format(txtRegister.getDate());
        client.setRegisterdate(register);
        ClientDao.save(client);
        generateID();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        generateID();
    }//GEN-LAST:event_formComponentShown

    private void txtPhoneNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneNumberKeyReleased
        validateFields();
    }//GEN-LAST:event_txtPhoneNumberKeyReleased

    private void txtNationalIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNationalIDKeyReleased
        validateFields();
    }//GEN-LAST:event_txtNationalIDKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        validateFields();
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        validateFields();
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyReleased
        validateFields();
    }//GEN-LAST:event_txtAddressKeyReleased

    private void txtNationalityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNationalityKeyReleased
        validateFields();
    }//GEN-LAST:event_txtNationalityKeyReleased

    private void txtCityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCityKeyReleased
        validateFields();
    }//GEN-LAST:event_txtCityKeyReleased

    private void txtOccupationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOccupationKeyReleased
        validateFields();
    }//GEN-LAST:event_txtOccupationKeyReleased

    private void txtPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneNumberActionPerformed

    
    private void generateID()
    {
        UUID clientId;
        clientId = UUID.randomUUID();
        jLabel8.setText(clientId.toString());
    }
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addNewClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CombGender;
    private javax.swing.JSpinner SpinCash;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCity;
    private com.toedter.calendar.JDateChooser txtDOB;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNationalID;
    private javax.swing.JTextField txtNationality;
    private javax.swing.JTextField txtOccupation;
    private javax.swing.JTextField txtPhoneNumber;
    private com.toedter.calendar.JDateChooser txtRegister;
    // End of variables declaration//GEN-END:variables
}
