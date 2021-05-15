package bank.system.manager.customer.domain;

import bank.system.manager.customer.domain.model.Customer;
import bank.system.manager.employee.domain.model.Employee;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    private final String URL = "jdbc:postgresql://localhost/bankdb";
    private final String USER = "postgres";
    private final String PASSWORD = "Pass1234";
    private final String DRIVER_NAME = "org.postgresql.Driver";

    public List<Customer> findAll() {
        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            List<Customer> customers = new ArrayList<>();
            String query = "select id,name,gender,married,status,contact_id,occupation from customers";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");

                String married = resultSet.getString("married");
                String status = resultSet.getString("status");
                long contact_id = resultSet.getLong("contact_id");
                String occupation = resultSet.getString("occupation");

                customers.add(new Customer(id, name, gender, married, status, contact_id, occupation));

            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
            return customers;

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }


    }

    public Optional<Customer> findById(long id) {
        try {
            Class.forName(DRIVER_NAME);
            Optional<Customer> optionalCustomer = Optional.empty();
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "Select * from customers where  id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String married = resultSet.getString("married");
                String status = resultSet.getString("status");
                long contact_id = resultSet.getLong("contact_id");
                String occupation = resultSet.getString("occupation");
                Customer customer = new Customer(id, name, gender, married, status, contact_id, occupation);
                optionalCustomer = Optional.of(customer);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

            return optionalCustomer;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public long create(Customer customer) {
        try {

            Class.forName(DRIVER_NAME);

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "insert into customers(name,gender,married,status,contact_id,occupation,created_by,created_date)" +
                    "values (?,?,?,?,?,?,?,?) returning id;";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getGender());
            preparedStatement.setString(3, customer.getMarried());
            preparedStatement.setString(4, customer.getStatus());
            preparedStatement.setLong(5, customer.getContact_id());
            preparedStatement.setString(6, customer.getOccupation());
            preparedStatement.setLong(7, customer.getCreatedBy());
            preparedStatement.setTimestamp(8, Timestamp.valueOf(customer.getCreatedDate()));
            ResultSet resultSet = preparedStatement.executeQuery();

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

    public void update(Customer customer) {
        try {
            Class.forName(DRIVER_NAME);

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "UPDATE customers SET name=?,gender=?,marrried=?,status=?,contact_id=?,updated_by=?,updated_date=?" +
                    "where  id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getGender());
            preparedStatement.setString(3, customer.getMarried());
            preparedStatement.setString(4, customer.getStatus());
            preparedStatement.setLong(5, customer.getContact_id());
            preparedStatement.setLong(6, customer.getUpdatedBy());
            preparedStatement.setTimestamp(7, Timestamp.valueOf(customer.getUpdatedDate()));
            preparedStatement.setLong(8, customer.getId());

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

            String query = "update customers SET is_deleted=cast(? as bit), deleted_by=?, deleted_date=? " +
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
