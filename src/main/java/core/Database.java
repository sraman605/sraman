package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String username="root";
    private static final String password="";

    protected Connection conn;

    public Database(){
        try {
            this.conn = this.getConnection();
        }
        catch (SQLException ex){
            System.out.println("Problem in Database Connection.check it out");
        }
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ephonebook",username,password);
        return conn;
    }
}
