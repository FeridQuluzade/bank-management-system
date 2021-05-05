package bank.system.manager.employee.application;

import bank.system.manager.employee.application.dto.EmployeeCreateDto;
import bank.system.manager.employee.application.dto.EmployeeDto;
import bank.system.manager.employee.application.dto.EmployeeUpdateDto;

import java.time.LocalDateTime;
import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> retrieveAll();

    EmployeeUpdateDto retrieveById(long id);

    long create(EmployeeCreateDto employeeCreateDto);

    void update(EmployeeUpdateDto employeeUpdateDto);

    void deleteById(long id, long deleteBy, LocalDateTime deletedDate);
}
