package bank.system.manager.account.application;

import bank.system.manager.account.application.dto.AccountCreateDto;
import bank.system.manager.account.application.dto.AccountDto;
import bank.system.manager.account.domain.model.Account;

import java.util.List;

public interface AccountService {
    List<AccountDto> retrieveAll();

    long create(AccountCreateDto accountCreateDto);


}
