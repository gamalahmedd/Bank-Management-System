package dao;
import bank.sec;
import bank.DbOperations;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
"alter table table_name rename to new_table_name" لو عايز اغير اسم التيبل
"alter table table_name rename col_old to to col_new" لو عايز اغير اسم الكولوم
"alter table table_name modify col_name new_type" لو عايز اغير التايب بتاع الكولوم
"alter table table_name add(new_col)" لو عايز اضيف كولوم جديد
"alter table table_name add index(col_name)" >> عشان اعمل كولوم معين انديكس
"alter table table_name add primary key(col_name)" >> عشان اعمل كولوم معين برايمري كي
"alter table table_name drop col_name" >> لو عايز امسح كولوم معين
"insert into table_name(table_colmuns) values()" >> لما ابقي عايز احط داتا معينة
"update table_name set column_name='"+value+"' , column_name='"+value+"' where احط شئ بيميزه" >> لو عايز اعمل ابديت للداتا
"delete from table_name where شئ مميز"
"primay key >> القيمة بتاعته مبتتكررش,doesn't accept null value >> constraint pk primary key (column_name)"
"select coulmn_name from table_name"
طب لو انا عايز اعرض كل الاعمدة وبميزها
"select *from table_name where colmun_name = value and column_name = value" >> لو عايز اخد داتا معينة
*/

public class table {
    public static void main(String[] args) {
        try{
////          String userTable = "create table user (id int AUTO_INCREMENT primary key, name varchar(200),email varchar(200),mobileNumber varchar(200),address varchar(200),password varchar(200),securityQuestion varchar(200),answer varchar(200),status varchar(20),UNIQUE (email))";
////          String clientTable = "create table client(clientId int not null,name varchar(100) not null, cash int(100) not null,address varchar(100) not null,gender varchar(10) not null,phoneno varchar(100) not null,dateofbirth varchar(100) not null,nationalId varchar(100) not null,email varchar(100) not null,nationality varchar(100) not null,city varchar(100) not null,occupation varchar(100) not null,constraint pk1 primary key (clientId))";
////          DbOperations.setDataOrDelete(clientTable, "Client Table Created Successfully");
////          DbOperations.setDataOrDelete(userTable, "User Table Created Successfully");
//          String adminDetails = "insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('Gamal','admin27@gmail.com','01159553525','Beni Suef','010509','What is your child school','Shagara Eldor','true')";
//          DbOperations.setDataOrDelete(adminDetails, "Admin Email Created Successfully");
////          String query = "alter table client add index(nationalId)";
////          DbOperations.setDataOrDelete(query, "Updated Succesfully");
////          String query = "create table receipt (receiptNumber int not null, clientId int not null, name varchar(100) not null, balance int not null, address varchar(100) not null, deposit int not null, withdraw int not null, constraint pk1 primary key (receiptNumber))";
////          DbOperations.setDataOrDelete(query, "Created Succesfully");
////          String query = "alter table receipt add(transfer int not null)";
////          DbOperations.setDataOrDelete(query, "Added Succesfully");   
//            String query = "Create table t(id int not null)";
//            DbOperations.setDataOrDelete(query, "ss");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
    }
}
}
