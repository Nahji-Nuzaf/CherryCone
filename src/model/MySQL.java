
package model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class MySQL {
    
    private static Connection connection;
    
    public static void createConnection() throws Exception{
        if (connection == null) {
            
//            FileInputStream inputStream = new FileInputStream("dbinfo.ser");
//            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//            MySQL db = (MySQL) objectInputStream.readObject();
//            objectInputStream.close();
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cherry_cone", "root", "Nahji@0284Iforgot");
        }
    }
    
    public static ResultSet executeSearch(String query) throws Exception{
        createConnection();
        return connection.createStatement().executeQuery(query);
    }
    
    public static Integer executeIUD(String query) throws Exception{
        createConnection();
        return connection.createStatement().executeUpdate(query);
    }
    
}
