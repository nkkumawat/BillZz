/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz.Database;
import billzz.Model.User;
import java.sql.*;
/**
 *
 * @author sonu
 */
public class SqlConnection {
    private static Connection con , con1;
    private static Statement stmt ,stmt1;
    public SqlConnection(){
        try {
            Statement stmt = getStatLogin();
            String createLogin = "create table if not exists login(id INTEGER  primary key AUTOINCREMENT\n"
                    +" , username varchar (100) , password varchar (100));";
            stmt.execute(createLogin);
            String sqlAdminLogin = "insert or ignore into login (username , password) values ('admin' , 'admin');";
            String check = "select * from login where username = 'admin'";
            ResultSet rs = stmt.executeQuery(check);
            if(!rs.next()){
               stmt.execute(sqlAdminLogin);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() );
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }    
     public static void initilizeDataBase() {
          try {
            Statement stmt = getStat();
            String createLogin = "create table if not exists login(id INTEGER  primary key AUTOINCREMENT\n"
                    +" , username varchar (100) , password varchar (100));";
            stmt.execute(createLogin);
            String customerTable = "create table if not exists customer(id integer primary key AUTOINCREMENT, \n"
                    + "full_name varchar(100) , locality varchar(100) , email varchar(100) , mobile varchar(12) , billing_address varchar(100), \n"
                    + " last_bill_date varchar(15) , last_bill_amount double(20) , last_pay_time varchar(20) , unbilled_amount double(20))";
            stmt.execute(customerTable);
            String paymentTable = "create table if not exists payment(id integer primary key AUTOINCREMENT , \n"
                    + "customer_id integer ,paid_amount double(20) ,  mode varchar(20) , record_time varchar(20), \n"
                    + "signature blob)";
            stmt.execute(paymentTable);
            String productTable = "create table if not exists product(id integer primary key AUTOINCREMENT , \n"
                    +"product_name varchar(50),product_rate double , product_desc varchar(10) , language varchar(10) ,  create_time varchar(20),\n"
                    + "signature blob)";
            stmt.execute(productTable);
            String subscriptionTable = "create table if not exists subscription(id integer primary key AUTOINCREMENT , \n"
                    + "customer_id integer , product_id integer , qty integer , start_date varchar(20))";
            stmt.execute(subscriptionTable);
            String recentPayTabl = "create table if not exists notification(id integer primary key AUTOINCREMENT, \n"
                    +" customer_id integer , customer_name varchar(100) , payed_amount double)";
            stmt.execute(recentPayTabl);
            } catch (Exception e) {
            System.out.println(e.getMessage() );
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "InfoBox: " , javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
     }
    public static Statement getStat() throws ClassNotFoundException, SQLException{
        if(con1 == null){
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:./Database/"+User.id+".db";
            con1 = DriverManager.getConnection(url);
            stmt1 = con1.createStatement();
        }
        return stmt1;
    } 
    public static Statement getStatLogin() throws ClassNotFoundException, SQLException{
        if(con == null){
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:./Database/login.db";
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
        }
        return stmt;
    } 
}
