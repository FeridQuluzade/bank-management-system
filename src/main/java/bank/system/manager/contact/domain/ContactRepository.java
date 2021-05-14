package bank.system.manager.contact.domain;

import bank.system.manager.contact.domain.model.Contact;

import javax.naming.ldap.PagedResultsControl;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactRepository {

    private final String URL = "jdbc:postgresql://localhost/bankdb";
    private final String USER = "postgres";
    private final String PASSWORD = "Pass1234";
    private final String DRIVER_NAME = "org.postgresql.Driver";


    public List<Contact> findAll() {

        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            List<Contact> contacts = new ArrayList<>();
            String query = "select  id,address,city,email,mobile,pin from contacts";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String email = resultSet.getString("email");
                String mobile = resultSet.getString("mobile");
                String pin = resultSet.getString("pin");

                contacts.add(new Contact(id, address, city, email, mobile, pin));

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return contacts;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public Optional<Contact> findById(long id){
        try{
            Class.forName(DRIVER_NAME);
            Optional<Contact> optionalContact=Optional.empty();
            Connection connection=DriverManager.getConnection(URL,USER,PASSWORD);

            String query="Select * from contacts where id=?";

            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setLong(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();

            if (resultSet.next()){
                String address=resultSet.getString("address");
                String city=resultSet.getString("city");
                String email=resultSet.getString("email");
                String mobile=resultSet.getString("mobile");
                String pin=resultSet.getString("pin");
                Contact contact=new Contact(id,address,city,email,mobile,pin);
                optionalContact=Optional.of(contact);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return optionalContact;
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public long create (Contact contact){
        try{
            Class.forName(DRIVER_NAME);

            Connection connection=DriverManager.getConnection(URL,USER,PASSWORD);
            String query="insert into contacts (address,city,email,mobile,pin,created_by,created_date) " +
                    "values (?,?,?,?,?,?,?) returning id";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,contact.getAddress());
            preparedStatement.setString(2,contact.getCity());
            preparedStatement.setString(3,contact.getEmail());
            preparedStatement.setString(4,contact.getMobile());
            preparedStatement.setString(5,contact.getPin());
            preparedStatement.setLong(6,contact.getCreatedBy());
            preparedStatement.setTimestamp(7, Timestamp.valueOf(contact.getCreatedDate()));
            ResultSet resultSet= preparedStatement.executeQuery();
            resultSet.next();
            long id=resultSet.getLong(1);

            resultSet.close();
            preparedStatement.close();
            connection.close();
            return id;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void update(Contact contact){
        try{
            Class.forName(DRIVER_NAME);

            Connection connection=DriverManager.getConnection(URL,USER,PASSWORD);
            String query="UPDATE contacts set  address=?,city=?,email=?,mobile=?,pin=?,updated_by=?,updated_date=?"+
                    "where  id=?";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setString(1,contact.getAddress());
            preparedStatement.setString(2,contact.getCity());
            preparedStatement.setString(3,contact.getEmail());
            preparedStatement.setString(4,contact.getMobile());
            preparedStatement.setString(5,contact.getPin());
            preparedStatement.setLong(6,contact.getUpdatedBy());
            preparedStatement.setTimestamp(7, Timestamp.valueOf(contact.getUpdatedDate()));
            preparedStatement.setLong(8,contact.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public void deleteById(long id, long deleteBy, LocalDateTime deletedDate) {

        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "update contacts SET is_deleted=cast(? as bit), deleted_by=?, deleted_date=? " +
                    "where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "1");
            preparedStatement.setLong(2, deleteBy);
            preparedStatement.setTimestamp(3, Timestamp.valueOf(deletedDate));
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
