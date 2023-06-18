package dao;

import bank.DbOperations;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.User;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDao {

    public static String emailPattern = "^[A-Za-z]{5}\\d+@[A-Za-z]+\\.[A-Za-z]{2,6}$"; //valid email -> gemyy555@gmail.com
    public static String mobileNumberPattern = "^1[0125][0-9]{8}$"; //-> Valid Number 01153212712
    public static String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"; // at least one digit, at least 8 characters, at least one lowercase, at least uppercase, at least one special character
    public static String namePattern = "^[A-Z][a-z]*(\\s+[A-Z][a-z]*)*$"; // valid name -> Gamal Ahmed
    public static String addressPattern = "^(\\d{1,}) [a-zA-Z0-9\\s]+(,)? [a-zA-Z]+(/s)?+[a-zA-Z]+(,)? [A-Z]{2} [0-9]{5,6}$";

    public static void save(User user) {
        String query = "insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('" + user.getName() + "','" + user.getEmail() + "','" + user.getMobileNumber() + "','" + user.getAddress() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','" + user.getAnswer() + "','" + user.getStatus() + "')";
        if (checkDuplicatedEmail(user.getEmail())) {
            JOptionPane.showMessageDialog(null, "Email is already exist");
        } else if (user.getName().matches(namePattern) && user.getEmail().matches(emailPattern) && user.getMobileNumber().matches(mobileNumberPattern) && user.getAddress().matches(addressPattern) && user.getPassword().matches(passwordPattern) && !user.getSecurityQuestion().equals("") && !user.getAnswer().equals("")) {
            DbOperations.setDataOrDelete(query, "Saved Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid data");
        }
    }

    public static User login(String email, String password) {
        User user = null;
        if (email.matches(emailPattern) && password.matches(passwordPattern)) {
            try {
                ResultSet rs = DbOperations.getData("select *from user where email='" + email + "' and password='" + password + "'");
                while (rs.next()) {
                    user = new User();
                    user.setStatus(rs.getString("status"));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Email or Password is incorrect");
        }
        return user;
    }

    public static User getSecurityQuestion(String email) {
        User user = null;
        if (email.matches(emailPattern)) {
            try {
                ResultSet rs = DbOperations.getData("select *from user where email = '" + email + "'");
                while (rs.next()) {
                    user = new User();
                    user.setSecurityQuestion(rs.getString("securityQuestion"));
                    user.setAnswer(rs.getString("answer"));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Email is incorrect");
        }
        return user;
    }

    public static void update(String email, String newPassword) {
        String query = "update user set password = '" + newPassword + "' where email = '" + email + "'";
        if (email.matches(emailPattern) && newPassword.matches(passwordPattern)) {
            DbOperations.setDataOrDelete(query, "Password Changed Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Email or Password is incorrect");
        }
    }

    public static ArrayList<User> getAllRecords(String email) {
        ArrayList<User> arrayList = new ArrayList<>();
        if (email.matches(emailPattern)) {
            try {
                ResultSet rs = DbOperations.getData("select *from user where email like '%" + email + "%'");
                while (rs.next()) {
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
                    arrayList.add(user);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return arrayList;
        } else {
            JOptionPane.showMessageDialog(null, "Email is Incorrect");
            return null;
        }
    }

    public static void changeStatus(String email, String status) {
        String query = "update user set status = '" + status + "' where email = '" + email + "'";
        if(email.matches(emailPattern))
        {
            DbOperations.setDataOrDelete(query, "Status Changed Succesfully");
        }
        else
            JOptionPane.showMessageDialog(null, "Email is incorrect");
    }

    public static void delete(String email) {
        String query = "delete from user where email = '" + email + "'";
        if (email.matches(emailPattern)) {
            DbOperations.setDataOrDelete(query, "User Deleted Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Email is incorrect");
        }
    }

    private static boolean checkDuplicatedEmail(String email) {
        String query = "select *from user where email = '" + email + "'";
        ResultSet rs = DbOperations.getData(query);
        boolean duplicated = false;
        try {
            if (rs.next()) {
                duplicated = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return duplicated;
    }
}
