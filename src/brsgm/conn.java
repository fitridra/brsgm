/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brsgm;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

//Koneksi Database
public class conn{
    private Connection conn;
    public static Connection getConnection()throws SQLException{
        Object conn = null;
        if (conn==null){
            Driver driver = new Driver();
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/brsgm","root","");
        }
        return (Connection) conn;   
    }
}
