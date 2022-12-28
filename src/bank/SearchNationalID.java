package bank;

import javax.swing.JOptionPane;
import model.Client;
import dao.ClientDao;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SearchNationalID extends javax.swing.JFrame {

    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobileNumberPattern = "^01[0125][0-9]{8}$";
    public String DOB = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$";
    public String userMail;

    public SearchNationalID() {
        initComponents();
    }
    public SearchNationalID(String useremail){
        initComponents();
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        SpinCash.setEnabled(false);
        txtName.setEditable(false);
        txtAddress.setEditable(false);
        txtGender.setEditable(false);
        txtPhoneNumber.setEditable(false);
        txtDOB.setEditable(false);
        txtEmail.setEditable(false);
        txtNationality.setEditable(false);
        txtCity.setEditable(false);
        txtOccupation.setEditable(false);
        txtRegister.setEditable(false);
        userMail = useremail;
    }

    public void validateFields() {
        String name = txtName.getText();
        String address = txtAddress.getText();
        String gender = txtGender.getText();
        String phoneno = txtPhoneNumber.getText();
        String dateofbirth = txtDOB.getText();
        String email = txtEmail.getText();
        String nationality = txtNationality.getText();
        String city = txtCity.getText();
        String occupation = txtOccupation.getText();
        String registerdate = txtRegister.getText();
        if (!name.equals("") && !address.equals("") && !gender.equals("") && phoneno.matches(mobileNumberPattern) && dateofbirth.matches(DOB) && email.matches(emailPattern) && !nationality.equals("") && !city.equals("") && !occupation.equals("") && registerdate.matches(DOB)) {
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
        } else {
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
        }
    }
    public void getAllRecords(String nationalID){
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Client> list = ClientDao.getAllRecords(nationalID);
        Iterator<Client> itr = list.iterator();
        while(itr.hasNext()){
            Client clientObj = itr.next();
            dtm.addRow(new Object[]{clientObj.getClientId(),clientObj.getName(),clientObj.getCash(),clientObj.getAddress(),clientObj.getGender(),clientObj.getPhoneno(),clientObj.getDateofbirth(),clientObj.getNationalId(),clientObj.getEmail(),clientObj.getNationality(),clientObj.getCity(),clientObj.getOccupation(),clientObj.getRegisterdate()});
        }
    }
    public void EnableFields(){
        txtName.setEditable(true);
        txtAddress.setEditable(true);
        txtGender.setEditable(true);
        txtPhoneNumber.setEditable(true);
        txtDOB.setEditable(true);
        txtEmail.setEditable(true);
        txtNationality.setEditable(true);
        txtCity.setEditable(true);
        txtOccupation.setEditable(true);
        txtRegister.setEditable(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtGender = new javax.swing.JTextField();
        SpinCash = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        txtDOB = new javax.swing.JTextField();
        txtNationalID = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNationality = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        txtOccupation = new javax.swing.JTextField();
        txtRegister = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtClientID = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tinywow_684833_6764756.png"))); // NOI18N
        jLabel1.setText("Search Client by (National ID):");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 216, -1));

        txtAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddressKeyReleased(evt);
            }
        });
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 216, -1));

        txtGender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGenderKeyReleased(evt);
            }
        });
        getContentPane().add(txtGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 216, -1));

        SpinCash.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(SpinCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 216, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cash");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 37, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Gender:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 58, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Phone Number:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Date of Birth:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        txtPhoneNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPhoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneNumberKeyReleased(evt);
            }
        });
        getContentPane().add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 214, -1));

        txtDOB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDOB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDOBKeyReleased(evt);
            }
        });
        getContentPane().add(txtDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 214, -1));

        txtNationalID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNationalID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNationalIDKeyReleased(evt);
            }
        });
        getContentPane().add(txtNationalID, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 230, 30));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 234, 230, 30));

        txtNationality.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNationality.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNationalityKeyReleased(evt);
            }
        });
        getContentPane().add(txtNationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 230, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Email:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 43, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("National ID:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nationality:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("City:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 43, -1));

        txtCity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCityKeyReleased(evt);
            }
        });
        getContentPane().add(txtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 230, -1));

        txtOccupation.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtOccupation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOccupationKeyReleased(evt);
            }
        });
        getContentPane().add(txtOccupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 390, 230, -1));

        txtRegister.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, 218, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Occupation:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, -1, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Register Date:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 95, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Full Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 684, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Client ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 80, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ClientID", "Name", "Cash", "Address", "Gender", "PhoneNumber", "DateOfBirth", "NationalID", "Email", "Nationality", "City", "Occupation", "RegisterDate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 121, 635, 533));

        txtClientID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtClientID.setForeground(new java.awt.Color(255, 255, 255));
        txtClientID.setText("00");
        getContentPane().add(txtClientID, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, -1, 20));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 506, 676, 10));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save_1.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 550, -1, -1));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 550, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 550, -1, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Update details.png"))); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 620, 100, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tinywow_SL-0212121-40670-68_7888141_1.jpg"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtDOBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDOBKeyReleased
        validateFields();
    }//GEN-LAST:event_txtDOBKeyReleased

    private void txtNationalIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNationalIDKeyReleased
        String nationalID = txtNationalID.getText();
        getAllRecords(nationalID);
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

    private void txtOccupationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOccupationKeyReleased
        validateFields();
    }//GEN-LAST:event_txtOccupationKeyReleased

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Client client = new Client();
        client.setClientId(txtClientID.getText());
        client.setName(txtName.getText());
        client.setCash((int) SpinCash.getValue());
        client.setAddress(txtAddress.getText());
        client.setGender(txtGender.getText());
        client.setPhoneno(txtPhoneNumber.getText());
        client.setDateofbirth(txtDOB.getText());
        client.setEmail(txtEmail.getText());
        client.setNationality(txtNationality.getText());
        client.setCity(txtCity.getText());
        client.setOccupation(txtOccupation.getText());
        client.setRegisterdate(txtRegister.getText());
        ClientDao.updateWithoutNationalID(client);
        setVisible(false);
        new SearchNationalID(userMail).setVisible(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String clientID = model.getValueAt(index, 0).toString();
        txtClientID.setText(clientID);
        String name = model.getValueAt(index, 1).toString();
        txtName.setText(name);
        String sCash = model.getValueAt(index, 2).toString();
        int cash = Integer.parseInt(sCash);
        SpinCash.setValue(cash);
        String address = model.getValueAt(index, 3).toString();
        txtAddress.setText(address);
        String gender = model.getValueAt(index, 4).toString();
        txtGender.setText(gender);
        String phoneno = model.getValueAt(index, 5).toString();
        txtPhoneNumber.setText(phoneno);
        String dob = model.getValueAt(index, 6).toString();
        txtDOB.setText(dob);
        String email = model.getValueAt(index, 8).toString();
        txtEmail.setText(email);
        String nationality = model.getValueAt(index, 9).toString();
        txtNationality.setText(nationality);
        String city = model.getValueAt(index, 10).toString();
        txtCity.setText(city);
        String occupation = model.getValueAt(index, 11).toString();
        txtOccupation.setText(occupation);
        String registerdate = model.getValueAt(index, 12).toString();
        txtRegister.setText(registerdate);
        EnableFields();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Client client = new Client();
        client.setClientId(txtClientID.getText());
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to delete this client", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            ClientDao.delete(client);
            setVisible(false);
            new SearchNationalID(userMail).setVisible(true);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setVisible(false);
        new SearchNationalID(userMail).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setVisible(false);
        new Home(userMail).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        getAllRecords("");
    }//GEN-LAST:event_formComponentShown

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchNationalID().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SpinCash;
    private javax.swing.JButton btnDelete;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCity;
    private javax.swing.JLabel txtClientID;
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
