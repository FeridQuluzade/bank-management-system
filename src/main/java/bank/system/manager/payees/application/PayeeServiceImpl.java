package bank.system.manager.payees.application;

import bank.system.manager.payees.application.dto.PayeeCreateDto;
import bank.system.manager.payees.domain.PayeeRepository;
import bank.system.manager.payees.domain.model.Payee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayeeServiceImpl implements PayeeService {
    private PayeeRepository payeeRepository;
    private ModelMapper modelMapper;

     @Autowired
    public PayeeServiceImpl(ModelMapper modelMapper,PayeeRepository payeeRepository){
       this.modelMapper=modelMapper;
       this.payeeRepository=payeeRepository;
    }

    @Override
    public long create(PayeeCreateDto payeeCreateDto) {
        Payee payee=modelMapper.map(payeeCreateDto,Payee.class);
         return payeeRepository.create(payee);
    }
}
