package Model;

import core.Database;
import Data.UserData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel extends Database {

    public UserModel(){
        super();
    }

    public int insertIntoDatabase(UserData  user) throws SQLException {

        String sql = "INSERT INTO users(name,email,phone_number,password) VALUES(?,?,?,?)";
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getEmail());
        //preparedStatement.setString(3,user.getAddress());
        preparedStatement.setString(3,user.getPhoneNo());
        preparedStatement.setString(4,user.getPassword());
        return preparedStatement.executeUpdate();
    }

    public int getUserIdFromEmail(String email) throws  SQLException{
        String sql = "SELECT id FROM users WHERE email = ?";
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1,email);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            return rs.getInt("id");
        }
        return 0;

    }

    public ResultSet loginUser(String email, String password) throws SQLException
    {
        String sql = "SELECT id,name FROM users WHERE email = ? AND password = ?";
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1,email);
        stmt.setString(2,password);
        return stmt.executeQuery();
    }





}
