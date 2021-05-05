package bank.system.manager.customer.application;

import bank.system.manager.customer.application.dto.CustomerCreateDto;
import bank.system.manager.customer.application.dto.CustomerDto;
import bank.system.manager.customer.application.dto.CustomerUpdateDto;
import bank.system.manager.customer.application.exception.CustomerNotFoundException;
import bank.system.manager.customer.domain.CustomerRepository;
import bank.system.manager.customer.domain.model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    public CustomerServiceImpl(){
        customerRepository=new CustomerRepository();
        modelMapper=new ModelMapper();
    }
    @Override
    public List<CustomerDto>retrieveAll() {
       return customerRepository
               .findAll()
               .stream()
               .map(customer -> modelMapper.map(customer, CustomerDto.class))
               .collect(Collectors.toList());
    }

    @Override
    public CustomerUpdateDto retrieveById(long id) {
       Customer customer=customerRepository
               .findById(id)
               .orElseThrow(()->new CustomerNotFoundException("Customer not found! by"+id));
       return modelMapper.map(customer,CustomerUpdateDto.class);
    }

    @Override
    public long create(CustomerCreateDto customerCreateDto) {
        Customer customer=modelMapper.map(customerCreateDto,Customer.class);
        return customerRepository.create(customer);
    }

    @Override
    public void update(CustomerUpdateDto customerUpdateDto) {
       Customer customer=modelMapper.map(customerUpdateDto,Customer.class);
       customerRepository.update(customer);
    }

    @Override
    public void deleteById(long id, long deleteBy, LocalDateTime deletedDate) {
       customerRepository.deleteById(id,deleteBy,deletedDate);
    }
}
