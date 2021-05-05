package bank.system.manager.customer.application;

import bank.system.manager.customer.application.dto.CustomerCreateDto;
import bank.system.manager.customer.application.dto.CustomerDto;
import bank.system.manager.customer.application.dto.CustomerUpdateDto;
import bank.system.manager.customer.domain.model.Customer;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomerService {
    List<CustomerDto> retrieveAll();

    CustomerUpdateDto retrieveById(long id);

    long create(CustomerCreateDto customerCreateDto);

    void update(CustomerUpdateDto customerUpdateDto);

    void deleteById(long id, long deleteBy, LocalDateTime deletedDate);
}
