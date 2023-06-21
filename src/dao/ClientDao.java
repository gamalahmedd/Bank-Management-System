package dao;

import bank.DbOperations;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Client;

public class ClientDao {

    public static String emailPattern = "^[A-Za-z]{5}\\d+@[A-Za-z]+\\.[A-Za-z]{2,6}$"; //valid email -> gemyy555@gmail.com
    public static String mobileNumberPattern = "^01[0125][0-9]{8}$"; //maximum 11 digit, must start with 01[0125]
    public static String namePattern = "^[A-Z][a-z]*(\\s+[A-Z][a-z]*)*$"; // valid name -> Gamal Ahmed
    public static String NI = "^([1-9]{1})([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})[0-9]{3}([0-9]{1})[0-9]{1}$";
    public static String addressPattern = "^(\\d{1,}) [a-zA-Z0-9\\s]+(,)? [a-zA-Z]+(/s)?+[a-zA-Z]+(,)? [A-Z]{2} [0-9]{5,6}$";
    public static String IDPattern = "^[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89ab][a-f0-9]{3}-[a-f0-9]{12}$";

    public static void save(Client client) {
        String query = "insert into client(clientId,name,cash,address,gender,phoneno,dateofbirth,nationalId,email,nationality,city,occupation,registerdate) values('" + client.getClientId() + "','" + client.getName() + "','" + client.getCash() + "','" + client.getAddress() + "','" + client.getGender() + "','" + client.getPhoneno() + "','" + client.getDateofbirth() + "','" + client.getNationalId() + "','" + client.getEmail() + "','" + client.getNationality() + "','" + client.getCity() + "','" + client.getOccupation() + "','" + client.getRegisterdate() + "')";
        if (client.getClientId().matches(IDPattern) && client.getName().matches(namePattern) && client.getAddress().matches(addressPattern) && client.getPhoneno().matches(mobileNumberPattern) && client.getEmail().matches(emailPattern) && client.getNationalId().matches(NI))
        {
            if(checkDuplicateEmail(client.getEmail()))
            {
                JOptionPane.showMessageDialog(null, "This email already in use");
            }
            else
            {
                DbOperations.setDataOrDelete(query, "<html><b style =\"color:blue\">Inserted Successfully</b</html>");
            }
        } 
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid Data");
        }
    }

    public static void update(Client client) {
        String query = "update client set name='" + client.getName() + "',cash='" + client.getCash() + "',address='" + client.getAddress() + "',gender='" + client.getGender() + "',phoneno='" + client.getPhoneno() + "',dateofbirth='" + client.getDateofbirth() + "',nationalId='" + client.getNationalId() + "',email='" + client.getEmail() + "',nationality='" + client.getNationality() + "',city='" + client.getCity() + "',occupation='" + client.getOccupation() + "',registerdate='" + client.getRegisterdate() + "' where clientId='" + client.getClientId() + "'";
        if (client.getClientId().matches(IDPattern) && client.getName().matches(namePattern) && client.getAddress().matches(addressPattern) && client.getPhoneno().matches(mobileNumberPattern) && client.getEmail().matches(emailPattern) && client.getNationalId().matches(NI))
        {
            String check = "select *from client where clientId = '"+client.getClientId()+"'";
            ResultSet rs = DbOperations.getData(check);
            try
            {
                if(rs.next())
                {
                    DbOperations.setDataOrDelete(query, "<html><b style =\"color:blue\">Updated Successfully</b</html>");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "User not found");
                }
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Invalid data");
        }
    }

    public static void updateWithNationalID(Client client) {
        String query = "update client set name='" + client.getName() + "',cash='" + client.getCash() + "',address='" + client.getAddress() + "',gender='" + client.getGender() + "',phoneno='" + client.getPhoneno() + "',dateofbirth='" + client.getDateofbirth() + "',email='" + client.getEmail() + "',nationality='" + client.getNationality() + "',city='" + client.getCity() + "',occupation='" + client.getOccupation() + "',registerdate='" + client.getRegisterdate() + "' where clientId='" + client.getClientId() + "' and nationalId = '" + client.getNationalId() + "'";
        if (client.getClientId().matches(IDPattern) && client.getName().matches(namePattern) && client.getAddress().matches(addressPattern) && client.getPhoneno().matches(mobileNumberPattern) && client.getEmail().matches(emailPattern) && client.getNationalId().matches(NI)) 
        {
            String check = "select *from client where clientId = '"+client.getClientId()+"' and nationalId = '"+client.getNationalId()+"'";
            ResultSet rs = DbOperations.getData(check);
            try
            {
                if(rs.next())
                {
                    DbOperations.setDataOrDelete(query, "<html><b style =\"color:blue\">Updated Successfully</b</html>");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "User not found");
                }
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Invalid data");
        }
    }

    public static void delete(Client client) {
        String query = "delete from client where clientId = '" + client.getClientId() + "'";
        if (client.getClientId().matches(IDPattern))
        {
            String check = "select *from client where clientId = '"+client.getClientId()+"'";
            ResultSet rs = DbOperations.getData(check);
            try
            {
                if(rs.next())
                {
                    DbOperations.setDataOrDelete(query, "<html><b style =\"color:blue\">Deleted Successfully</b</html>");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "User not found");
                }
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } 
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid ID");
        }
    }

    public static void deleteWithNationalId(Client client) {
        String query = "delete from client where clientId = '" + client.getClientId() + "' and nationalId = '" + client.getNationalId() + "'";
        if (client.getClientId().matches(IDPattern) && client.getNationalId().matches(NI)) 
        {
            String check = "select *from client where clientId = '"+client.getClientId()+"' and nationalId = '"+client.getNationalId()+"'";
            ResultSet rs = DbOperations.getData(check);
            try
            {
                if(rs.next())
                {
                    DbOperations.setDataOrDelete(query, "<html><b style =\"color:blue\">Deleted Successfully</b</html>");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "User not found");
                }
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } 
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid ID");
        }
    }

    public static ResultSet searchUpdate(String flag) {
        String query = "select *from client where clientId = '" + flag + "'";
        if (flag.matches(IDPattern)) {
            ResultSet rs = DbOperations.getData(query);
            JOptionPane.showMessageDialog(null, "Found Successfully");
            return rs;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid ID");
            return null;
        }
    }

    public static ResultSet searchDelete(String flag) {
        String query = "select *from client where clientId = '" + flag + "'";
        if (flag.matches(IDPattern)) {
            ResultSet rs = DbOperations.getData(query);
            JOptionPane.showMessageDialog(null, "Found Successfully");
            return rs;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid ID");
            return null;
        }
    }

    public static ArrayList<Client> getAllRecords(String nationalID) {
        if (nationalID.matches(NI)) {
            ArrayList<Client> arrayList = new ArrayList<>();
            try {
                ResultSet rs = DbOperations.getData("select *from client where nationalId like '%" + nationalID + "%'");
                while (rs.next()) {
                    Client client = new Client();
                    client.setClientId(rs.getString("clientId"));
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
                    arrayList.add(client);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            JOptionPane.showMessageDialog(null, "Get All Records");
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid National ID");
            return null;
        }

    }

    private static boolean checkDuplicateEmail(String email) 
    {
        String query = "select *from client where email = '"+email+"'";
        ResultSet rs = DbOperations.getData(query);
        try
        {
            if(rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(SQLException E)
        {
            JOptionPane.showMessageDialog(null, E.getMessage());
        }
        return false;
    }
    
}
