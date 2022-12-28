package dao;
import bank.sec;
import bank.DbOperations;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import model.Receipt;
import model.Client;

public class ReceiptDao {
    
    public static String getID(){
        int id = 0;
        try{
            ResultSet rs = DbOperations.getData("select max(receiptNumber) from receipt");
            if(rs.first()){
                id = rs.getInt(1);
                id = id + 1;
            }
            else{
                id = 1;
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }
    
    public static void saveReceipt(Receipt receipt){
        String query = "insert into receipt(receiptNumber,clientId,name,balance,address,deposit,withdraw,transfer,receiptregister,createdBy) values('"+receipt.getReceiptnumber()+"','"+receipt.getClientId()+"','"+receipt.getName()+"','"+receipt.getBalance()+"','"+receipt.getAddress()+"','"+receipt.getDeposit()+"','"+receipt.getWithdraw()+"','"+receipt.getTransfer()+"','"+receipt.getRegisterdate()+"','"+receipt.getCreatedBy()+"')";
        DbOperations.setDataOrDelete(query, "Receipt Details Added Succesfully");
    }
    public static ResultSet searchClient(String flag){
        String query = "select *from client where clientId = '"+flag+"'";
        ResultSet rs = DbOperations.getData(query);
        return rs;
    }
    public static void Deposit(Client client){
        String query = "update client set cash ='"+client.getCash()+"' where clientId = '"+client.getClientId()+"'";
        DbOperations.setDataOrDelete(query, "Deposited Succesfully");
    }
    public static void Withdraw(Client client){
        String query = "update client set cash ='"+client.getCash()+"' where clientId = '"+client.getClientId()+"'";
        DbOperations.setDataOrDelete(query, "Withdrawed Succesfully");
    }
    public static ResultSet TransferToGet(String id){
        String query = "select *from client where clientId = '"+id+"'";
        ResultSet rs = DbOperations.getData(query);
        return rs;
    }
    public static void TransferToSet(String id, int ammount){
        String query = "update client set cash = '"+ammount+"' where clientId = '"+id+"'";
        DbOperations.setDataOrDelete(query, "Money Transferred Successfully");
    }
    public static void TransferFromSet(String id, int ammount){
        String query = "update client set cash = '"+ammount+"' where clientId = '"+id+"'";
        sec c5 = new sec();
        try{
            Connection con = c5.connect();
            Statement st = con.createStatement();
            st.executeUpdate(query);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
