package bank.system.manager.employee;

import bank.system.manager.contact.application.dto.ContactCreateDto;
import bank.system.manager.contact.application.dto.ContactDto;
import bank.system.manager.contact.application.dto.ContactUpdateDto;
import bank.system.manager.employee.application.EmployeeService;
import bank.system.manager.employee.application.dto.EmployeeCreateDto;
import bank.system.manager.employee.application.dto.EmployeeDto;
import bank.system.manager.employee.application.dto.EmployeeUpdateDto;
import bank.system.manager.shared.UserContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping(value = "retrieve-all")
    @ResponseBody
    public List<EmployeeDto> retrieveAll() {
        return employeeService.retrieveAll();
    }

    @GetMapping(value = "/retrieve-by-id/{id}")
    @ResponseBody
    public EmployeeUpdateDto retrieveById(@PathVariable Long id) {
        return employeeService.retrieveById(id);
    }

    @PostMapping(value = "/create")
    public long create(@Valid @RequestBody EmployeeCreateDto employeeCreateDto) {
        employeeCreateDto.setCreatedBy(UserContextHolder.getUserId());
        employeeCreateDto.setCreatedDate(LocalDateTime.now());
        return employeeService.create(employeeCreateDto);
    }

    @PutMapping(value = "/update")
    public void update(@Valid @RequestBody EmployeeUpdateDto employeeUpdateDto) {
        employeeUpdateDto.setUpdatedBy(UserContextHolder.getUserId());
        employeeUpdateDto.setUpdatedDate(LocalDateTime.now());
        employeeService.update(employeeUpdateDto);
    }

    @DeleteMapping(value = "/deleted/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.deleteById(id, UserContextHolder.getUserId(), LocalDateTime.now());
    }



}
