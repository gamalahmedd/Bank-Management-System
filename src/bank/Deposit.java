package bank;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import dao.ReceiptDao;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Receipt;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Client;

public class Deposit extends javax.swing.JFrame {

    public int ReceiptID = 1;
    public String userEmail;

    public Deposit() {
        initComponents();
    }

    public Deposit(String email) {
        initComponents();
        txtAddress.setEditable(false);
        txtName.setEditable(false);
        txtBalance.setEditable(false);
        btnSearch.setEnabled(false);
        spinDeposit.setEnabled(false);
        btnDeposit.setEnabled(false);
        spinWithdraw.setEnabled(false);
        btnWithdraw.setEnabled(false);
        txtToID.setEditable(false);
        spinTransfer.setEnabled(false);
        btnTransfer.setEnabled(false);
        btnGenerateReceipt.setEnabled(false);
        btnPrintReceipt.setEnabled(false);
        userEmail = email;
    }

    public void validateID() {
        String ID = txtSearch.getText();
        if (!ID.equals("")) {
            btnSearch.setEnabled(true);
        } else {
            btnSearch.setEnabled(false);
        }
    }

    public void GenerateReceipt() {
        String ID = txtReceiptID.getText();
        String clientID = txtID.getText();
        String name = txtName.getText();
        String balance = txtBalance.getText();
        String address = txtAddress.getText();
        int deposit1 = (int) spinDeposit.getValue();
        String deposit = String.valueOf(deposit1);
        int withdraw1 = (int) spinWithdraw.getValue();
        String withdraw = String.valueOf(withdraw1);
        int transfer1 = (int) spinTransfer.getValue();
        String transfer = String.valueOf(transfer1);
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String todaydate = dFormat.format(date);
        String CreatedBy = userEmail;
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        dtm.addRow(new Object[]{clientID, name, balance, address, deposit, withdraw, transfer});
        btnPrintReceipt.setEnabled(true);
        btnGenerateReceipt.setEnabled(false);
        Receipt receipt = new Receipt();
        receipt.setReceiptnumber(Integer.parseInt(ID));
        receipt.setClientId(Integer.parseInt(clientID));
        receipt.setName(name);
        receipt.setBalance(Integer.parseInt(balance));
        receipt.setAddress(address);
        receipt.setDeposit(deposit1);
        receipt.setWithdraw(withdraw1);
        receipt.setTransfer(transfer1);
        receipt.setRegisterdate(todaydate);
        receipt.setCreatedBy(CreatedBy);
        ReceiptDao.saveReceipt(receipt);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtReceiptID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        spinDeposit = new javax.swing.JSpinner();
        btnDeposit = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        spinWithdraw = new javax.swing.JSpinner();
        btnWithdraw = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtToID = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        spinTransfer = new javax.swing.JSpinner();
        btnTransfer = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnGenerateReceipt = new javax.swing.JButton();
        btnPrintReceipt = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();

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
        jLabel1.setText("Deposit/WithDraw/Transfer");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 13, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Receipt Number:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 115, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 142, 659, 10));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Client ID: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 197, -1, -1));

        txtID.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtID.setForeground(new java.awt.Color(255, 255, 255));
        txtID.setText("00");
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 198, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Name: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 296, -1, -1));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 293, 220, -1));

        txtReceiptID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtReceiptID.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtReceiptID, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 115, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Balance: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 296, -1, -1));

        txtBalance.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 293, 253, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Address:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 197, -1, -1));

        txtAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 194, 255, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Deposit");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 180, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 142, 643, 10));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Client ID:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 83, -1, -1));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(883, 80, 302, -1));

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1192, 79, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Deposit:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(789, 250, -1, -1));
        getContentPane().add(spinDeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(876, 250, 335, -1));

        btnDeposit.setBackground(new java.awt.Color(255, 255, 255));
        btnDeposit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeposit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tinywow_Deposit_6747359.png"))); // NOI18N
        btnDeposit.setText("Deposit");
        btnDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1223, 246, -1, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 323, 643, 10));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Withdraw");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 340, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Withdraw:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 408, -1, -1));
        getContentPane().add(spinWithdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(869, 408, 337, -1));

        btnWithdraw.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnWithdraw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tinywow_Withdraw_6747379.png"))); // NOI18N
        btnWithdraw.setText("Withdraw");
        btnWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawActionPerformed(evt);
            }
        });
        getContentPane().add(btnWithdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(1233, 404, -1, -1));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 468, 643, 10));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Transfer");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(991, 485, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("To ID:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(806, 535, -1, -1));

        txtToID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtToID, new org.netbeans.lib.awtextra.AbsoluteConstraints(872, 535, 343, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Amount: ");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(806, 594, -1, -1));
        getContentPane().add(spinTransfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(872, 594, 343, -1));

        btnTransfer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTransfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Deposit.png"))); // NOI18N
        btnTransfer.setText("Transfer");
        btnTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferActionPerformed(evt);
            }
        });
        getContentPane().add(btnTransfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1233, 590, -1, -1));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 648, 643, 21));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 387, 659, 10));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client ID", "Name", "Balance", "Address", "Deposit", "Withdraw", "Transfer"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 404, 638, 290));

        btnGenerateReceipt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerateReceipt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/generate bill & print.png"))); // NOI18N
        btnGenerateReceipt.setText("Generate Receipt");
        btnGenerateReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateReceiptActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerateReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 720, -1, -1));

        btnPrintReceipt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPrintReceipt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print.png"))); // NOI18N
        btnPrintReceipt.setText("Print Receipt");
        btnPrintReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintReceiptActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrintReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 720, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Search Client");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(972, 35, -1, -1));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 10, -1, 37));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clear.png"))); // NOI18N
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 700, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tinywow_SL-0212121-40670-68_7888141.jpg"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setVisible(false);
        new Home(userEmail).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        validateID();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        ReceiptID = Integer.parseInt(ReceiptDao.getID());
        txtReceiptID.setText(ReceiptDao.getID());
    }//GEN-LAST:event_formComponentShown

    private void btnGenerateReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateReceiptActionPerformed
        GenerateReceipt();
    }//GEN-LAST:event_btnGenerateReceiptActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        new Deposit(userEmail).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPrintReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintReceiptActionPerformed
        String clientID = txtID.getText();
        String name = txtName.getText();
        String balance = txtBalance.getText();
        int deposit1 = (int) spinDeposit.getValue();
        String deposit = String.valueOf(deposit1);
        int withdraw1 = (int) spinWithdraw.getValue();
        String withdraw = String.valueOf(withdraw1);
        String toID = txtToID.getText();
        int transfer1 = (int) spinTransfer.getValue();
        String transfer = String.valueOf(transfer1);
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String todaydate = dFormat.format(date);
        //Creating Doucment
        String path = "D:\\";
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "" + ReceiptID + ".pdf"));
            doc.open();
            Paragraph BankName = new Paragraph("                                 Bank Management System\n");
            doc.add(BankName);
            Paragraph starLine = new Paragraph("************************************************************************************\n");
            doc.add(starLine);
            Paragraph paragraph3 = new Paragraph("\tReceipt Number: " + ReceiptID + "                               " + "Client ID: " + clientID + "\n");
            doc.add(paragraph3);
            Paragraph paragraph4 = new Paragraph("\tClient Name: " + name + "             " + "Receipt Date: " + todaydate + "\n");
            doc.add(paragraph4);
            doc.add(starLine);
            Paragraph deposited = new Paragraph("	                                     Deposited\n");
            doc.add(deposited);
            Paragraph value = new Paragraph("\tAmount: " + deposit + "                       Your New Balance: " + balance + "\n");
            doc.add(value);
            doc.add(starLine);
            Paragraph Withdrawed = new Paragraph("                                     Withdrawed\n");
            doc.add(Withdrawed);
            Paragraph value2 = new Paragraph("\tAmount: " + withdraw + "                       Your New Balance: " + balance + "\n");
            doc.add(value2);
            doc.add(starLine);
            Paragraph transfered = new Paragraph("                                     Transfered\n");
            doc.add(transfered);
            Paragraph value3 = new Paragraph("Transfered to ClientID: " + toID + "              Amount: " + transfer + "                 Your New Balance: " + balance);
            doc.add(value3);
            doc.add(starLine);
            Paragraph thankmessage = new Paragraph("                            Thank you for using our Bank System");
            doc.add(thankmessage);
            OpenPdf.OpenByID(String.valueOf(ReceiptID));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        doc.close();
    }//GEN-LAST:event_btnPrintReceiptActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String clientID = txtSearch.getText();
        try {
            ResultSet rs = ReceiptDao.searchClient(clientID);
            if (rs.next()) {
                txtID.setText(rs.getString("clientId"));
                txtAddress.setText(rs.getString("address"));
                txtName.setText(rs.getString("name"));
                txtBalance.setText(String.valueOf(rs.getInt("cash")));
                int a = JOptionPane.showConfirmDialog(null, "Do you want to Deposit?", "Select", JOptionPane.YES_NO_OPTION);
                if (a == 0) {
                    spinDeposit.setEnabled(true);
                    btnDeposit.setEnabled(true);
                    txtSearch.setEditable(false);
                    btnSearch.setEnabled(false);
                } else {
                    int b = JOptionPane.showConfirmDialog(null, "Do you want to Withdraw?", "Select", JOptionPane.YES_NO_OPTION);
                    if (b == 0) {
                        spinWithdraw.setEnabled(true);
                        btnWithdraw.setEnabled(true);
                        txtSearch.setEditable(false);
                        btnSearch.setEnabled(false);
                    } else {
                        int c = JOptionPane.showConfirmDialog(null, "Do you want to Transfer?", "Select", JOptionPane.YES_NO_OPTION);
                        if (c == 0) {
                            txtToID.setEditable(true);
                            spinTransfer.setEnabled(true);
                            btnTransfer.setEnabled(true);
                            txtSearch.setEditable(false);
                            btnSearch.setEnabled(false);
                        } else {
                            setVisible(false);
                            new Deposit(userEmail).setVisible(true);
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Client ID does not exist");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositActionPerformed

        int balance = Integer.parseInt(txtBalance.getText());
        int deposit = (int) spinDeposit.getValue();
        balance = balance + deposit;
        txtBalance.setText(String.valueOf(balance));
        Client client = new Client();
        client.setClientId(txtID.getText());
        client.setCash(balance);
        ReceiptDao.Deposit(client);
        JOptionPane.showMessageDialog(null, "This account new balance is " + balance);
        btnGenerateReceipt.setEnabled(true);
    }//GEN-LAST:event_btnDepositActionPerformed

    private void btnWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawActionPerformed
        int balance = Integer.parseInt(txtBalance.getText());
        int withdraw = (int) spinWithdraw.getValue();
        if (withdraw > balance) {
            JOptionPane.showMessageDialog(null, "Your balance isn't enougth to withdraw this amount");
        } else {
            balance = balance - withdraw;
            txtBalance.setText(String.valueOf(balance));
            Client client = new Client();
            client.setClientId(txtID.getText());
            client.setCash(balance);
            ReceiptDao.Withdraw(client);
            JOptionPane.showMessageDialog(null, "This account new balance is " + balance);
            btnGenerateReceipt.setEnabled(true);
        }
    }//GEN-LAST:event_btnWithdrawActionPerformed

    private void btnTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferActionPerformed
        String ClientIDFrom = txtID.getText();
        String ClientIDTo = txtToID.getText();
        int balance = Integer.parseInt(txtBalance.getText());
        int moneytransfered = (int) spinTransfer.getValue();
        try {
            ResultSet rs = ReceiptDao.TransferToGet(ClientIDTo);
            if (balance > moneytransfered) {
                if (rs.next()) {
                    balance = balance - moneytransfered;
                    ReceiptDao.TransferFromSet(ClientIDFrom, balance);
                    txtBalance.setText(String.valueOf(balance));
                    int newBalance = rs.getInt("cash") + moneytransfered;
                    ReceiptDao.TransferToSet(ClientIDTo, newBalance);
                    JOptionPane.showMessageDialog(null, "The current balance of the account you transferred from = " + balance);
                    JOptionPane.showMessageDialog(null, "The current balance of the account you transferred to = " + newBalance);
                    btnGenerateReceipt.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Client ID you want transfer to does not exist");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Your balance is not enough to transfer this amount");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnTransferActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Deposit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeposit;
    private javax.swing.JButton btnGenerateReceipt;
    private javax.swing.JButton btnPrintReceipt;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTransfer;
    private javax.swing.JButton btnWithdraw;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner spinDeposit;
    private javax.swing.JSpinner spinTransfer;
    private javax.swing.JSpinner spinWithdraw;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JLabel txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JLabel txtReceiptID;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtToID;
    // End of variables declaration//GEN-END:variables
}
