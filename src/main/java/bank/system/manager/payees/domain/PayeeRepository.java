package bank.system.manager.payees.domain;

import bank.system.manager.payees.domain.model.Payee;
import bank.system.manager.shared.PostgreDbService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
@Service
public class PayeeRepository {

    private final String URL = "jdbc:postgresql://localhost/bankdb";
    private final String USER = "postgres";
    private final String PASSWORD = "Pass1234";
    private final String DRIVER_NAME = "org.postgresql.Driver";

    public long create(Payee payee) {
        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "insert into payees(payment_year,payment_month,accountid,created_by,created_date)" +
                    "values ((select (sum+(sum*degree*year)/100)/year from accounts where id=?),(select  (sum+(sum*degree*year)/100)/(12*year) from accounts where id=?),?,?,?) returning id";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, payee.getAccountid());
            preparedStatement.setLong(2, payee.getAccountid());
            preparedStatement.setLong(3, payee.getAccountid());
            preparedStatement.setLong(4, payee.getCreatedBy());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(payee.getCreatedDate()));
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            long id = resultSet.getLong(1);
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return  id;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
