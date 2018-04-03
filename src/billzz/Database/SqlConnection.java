/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzz.Database;
import java.sql.*;
/**
 *
 * @author sonu
 */
public class SqlConnection {
    private static Connection con;
    private static Statement stmt;
    public SqlConnection(){
        try {
             String createLogin = "create table if not exists login(id INTEGER  primary key AUTOINCREMENT , username varchar (100) , password varchar (100));";
             Statement stmt = getStat();
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
    public static Statement getStat() throws ClassNotFoundException, SQLException{
        if(con == null){
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:./database.db";
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
        }
        return stmt;
    }   
}
