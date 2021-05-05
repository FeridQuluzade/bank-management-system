package bank.system.manager.employee.domain;

import bank.system.manager.employee.domain.model.Employee;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class EmployeeRepository {

    private final String URL = "jdbc:postgresql://localhost/bankdb";
    private final String USER = "postgres";
    private final String PASSWORD = "Pass1234";
    private final String DRIVER_NAME = "org.postgresql.Driver";


    public List<Employee> findAll() {
        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            List<Employee> employees = new ArrayList<>();
            String query = "select id, name,gender,married,password,contact_id from employees";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String married = resultSet.getString("married");
                String password = resultSet.getString("password");
                long contact_id = resultSet.getLong("contact_id");

                employees.add(new Employee(id, name, gender, married, password, contact_id));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return employees;

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Optional<Employee> findById(long id)
    {
        try{
            Optional<Employee> optionalEmployee=Optional.empty();

            Connection connection=DriverManager.getConnection(URL,USER,PASSWORD);

            String query="Select * from employees where  id=?";

            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setLong(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();

            if (resultSet.next()){
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String married = resultSet.getString("married");
                String password = resultSet.getString("password");
                long contact_id = resultSet.getLong("contact_id");
                Employee employee= new Employee(id,name,gender,married,password,contact_id);
                optionalEmployee=Optional.of(employee);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return optionalEmployee;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public long create(Employee employee) {

        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "insert  into employees(name,gender,married,password,contact_id,created_by,created_date)" +
                    "values (?,?,?,?,?,?,?) returning id";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getGender());
            preparedStatement.setString(3, employee.getMarried());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setLong(5, employee.getContact_id());
            preparedStatement.setLong(6, employee.getCreatedBy());
            preparedStatement.setTimestamp(7, Timestamp.valueOf(employee.getCreatedDate()));
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            long id = resultSet.getLong(1);
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return id;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public void update(Employee employee) {
        try {
            Class.forName(DRIVER_NAME);

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "UPDATE  employees SET name=?,gender=?,married=?,password=?,contact_id=?,updated_by=?,updated_date=?" +
                    "where  id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getGender());
            preparedStatement.setString(3, employee.getPassword());
            preparedStatement.setLong(4, employee.getContact_id());
            preparedStatement.setLong(5, employee.getContact_id());
            preparedStatement.setTimestamp(6, Timestamp.valueOf(employee.getUpdatedDate()));
            preparedStatement.setLong(7, employee.getId());
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

            String query = "update employees SET is_deleted=cast(? as bit), deleted_by=?, deleted_date=? " +
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
