package bank.system.manager.payees.application;

import bank.system.manager.payees.application.dto.PayeeCreateDto;

public interface PayeeService {

long create(PayeeCreateDto payeeCreateDto);
}
