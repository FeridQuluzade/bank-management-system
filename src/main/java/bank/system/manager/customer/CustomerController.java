package bank.system.manager.customer;


import bank.system.manager.customer.application.CustomerService;
import bank.system.manager.customer.application.dto.CustomerCreateDto;
import bank.system.manager.customer.application.dto.CustomerDto;
import bank.system.manager.customer.application.dto.CustomerUpdateDto;
import bank.system.manager.shared.UserContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @GetMapping(value = "retrieve-all")
    @ResponseBody
    public List<CustomerDto> retrieveAll() {
        return customerService.retrieveAll();
    }

    @GetMapping(value = "/retrieve-by-id/{id}")
    @ResponseBody
    public CustomerUpdateDto retrieveById(@PathVariable Long id) {
        return customerService.retrieveById(id);
    }

    @PostMapping(value = "/create")
    public long create(@Valid @RequestBody CustomerCreateDto customerCreateDto) {
        customerCreateDto.setCreatedBy(UserContextHolder.getUserId());
        customerCreateDto.setCreatedDate(LocalDateTime.now());
        return customerService.create(customerCreateDto);
    }

    @PutMapping(value = "/update")
    public void update(@Valid @RequestBody CustomerUpdateDto customerUpdateDto) {
        customerUpdateDto.setUpdatedBy(UserContextHolder.getUserId());
        customerUpdateDto.setUpdatedDate(LocalDateTime.now());
        customerService.update(customerUpdateDto);
    }

    @DeleteMapping(value = "/deleted/{id}")
    public void delete(@PathVariable Long id) {
        customerService.deleteById(id, UserContextHolder.getUserId(), LocalDateTime.now());
    }


}
