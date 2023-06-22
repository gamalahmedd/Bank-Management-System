package bank;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DbOperations {
    static Connection con;
    static Statement st;
    public boolean setDataOrDelete(String Query, String msg){
        sec c1 = new sec();
        try{
            con = c1.connect();
            st = con.createStatement();
            st.executeUpdate(Query);
            if(!msg.equals(""))
                JOptionPane.showMessageDialog(null, msg);
            return true;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e,  "Message", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public ResultSet getData(String query){
        sec c2 = new sec();
        try{
            con = c2.connect();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(query);
            return rs;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e,  "Message", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
