package Model;

import Data.ContactData;
import core.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactModel extends Database {
    public ContactModel(){
        super();
    }
    public int insertIntoDatabase(ContactData contactData) throws SQLException {

        String sql = "INSERT INTO contacts(name,email,phoneno,address,mobno,userid) VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setString(1,contactData.getName());
        preparedStatement.setString(2,contactData.getEmail());
       preparedStatement.setLong(3,contactData.getPhoneno());
        preparedStatement.setString(4,contactData.getAddress());
        preparedStatement.setLong(5,contactData.getMobno());
        preparedStatement.setInt(6,contactData.getUserid());
        return preparedStatement.executeUpdate();
    }
    //public List<ContactData> getAllContact(){
    public List<ContactData> display(int userid) throws SQLException {

        String query = "SELECT * from contacts WHERE userid = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1,userid);
        ResultSet rs = preparedStatement.executeQuery();

        List contact = new ArrayList();

        while (rs.next()) {
            //Retrieve by column name

            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email=rs.getString("email");
            String address=rs.getString("address");
            Long phoneno = rs.getLong("phoneno");
            Long mobno = rs.getLong("mobno");

            ContactData cd = new ContactData();
            cd.setId(id);
            cd.setName(name);
            cd.setEmail(email);
            cd.setAddress(address);
            cd.setPhoneno(phoneno);
            cd.setMobno(mobno);

            contact.add(cd);
            System.out.println(cd);


        }
        return contact;
    }
public ContactData getDatabyId(int id) throws SQLException {
    ContactData cd = new ContactData();
    String sql="SELECT * FROM contacts WHERE id= ? ";
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet rs =  preparedStatement.executeQuery();
        while (rs.next()){
            cd = new ContactData();
            cd.setId(id);
            cd.setName(rs.getString("name"));
            cd.setEmail(rs.getString("email"));
            cd.setAddress(rs.getString("address"));
            cd.setPhoneno(rs.getLong("phoneno"));
            cd.setMobno(rs.getLong("mobno"));
            System.out.println(rs.getString("mobno") + "asd123");
        }
        return cd;

}
    public int Edit(ContactData contactData) throws SQLException{
        String sql="UPDATE contacts SET name=?,email=?,phoneno=?,address=?,mobno=?,userid=? WHERE id = ? ";
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setString(1,contactData.getName());
        preparedStatement.setString(2,contactData.getEmail());
        preparedStatement.setLong(3,contactData.getPhoneno());
        preparedStatement.setString(4,contactData.getAddress());
        preparedStatement.setLong(5,contactData.getMobno());
        preparedStatement.setInt(6,contactData.getUserid());
        preparedStatement.setInt(7,contactData.getId());
        return preparedStatement.executeUpdate();
    }



      public int delete(int id) throws SQLException {
          String sql="DELETE FROM contacts WHERE id=?";
          PreparedStatement preparedStatement =conn.prepareStatement(sql);
          preparedStatement.setInt(1,id);
          return preparedStatement.executeUpdate();
    }

    }
