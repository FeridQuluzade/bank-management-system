package bank.system.manager.employee.application;

import bank.system.manager.employee.application.dto.EmployeeCreateDto;
import bank.system.manager.employee.application.dto.EmployeeDto;
import bank.system.manager.employee.application.dto.EmployeeUpdateDto;
import bank.system.manager.employee.application.exception.EmployeeNotFoundException;
import bank.system.manager.employee.domain.EmployeeRepository;
import bank.system.manager.employee.domain.model.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
      private EmployeeRepository employeeRepository;
      private ModelMapper modelMapper;

      @Autowired
      public  EmployeeServiceImpl(){
         employeeRepository=new EmployeeRepository();
         modelMapper=new ModelMapper();
      }

    @Override
    public List<EmployeeDto> retrieveAll() {
        return employeeRepository
                .findAll()
                .stream()
                .map(employee -> modelMapper.map(employee,EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeUpdateDto retrieveById(long id) {
       Employee employee=employeeRepository
               .findById(id)
               .orElseThrow(()-> new EmployeeNotFoundException("Employee not found! by "+id));
       return modelMapper.map(employee,EmployeeUpdateDto.class);
    }

    @Override
    public long create(EmployeeCreateDto employeeCreateDto) {
        Employee employee=modelMapper.map(employeeCreateDto,Employee.class);
        return employeeRepository.create(employee);
    }

    @Override
    public void update(EmployeeUpdateDto employeeUpdateDto) {
        Employee employee=modelMapper.map(employeeUpdateDto,Employee.class);
        employeeRepository.update(employee);
    }

    @Override
    public void deleteById(long id, long deleteBy, LocalDateTime deletedDate) {
          employeeRepository.deleteById(id,deleteBy,deletedDate);
    }
}
