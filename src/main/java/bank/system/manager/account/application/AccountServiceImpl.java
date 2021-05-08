package bank.system.manager.account.application;

import bank.system.manager.account.application.dto.AccountCreateDto;
import bank.system.manager.account.application.dto.AccountDto;
import bank.system.manager.account.application.dto.AccountUpdateDto;
import bank.system.manager.account.application.exception.AccountNotFoundException;
import bank.system.manager.account.domain.AccountRepository;
import bank.system.manager.account.domain.model.Account;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    private ModelMapper modelMapper;

    public AccountServiceImpl() {
        accountRepository = new AccountRepository();
        modelMapper = new ModelMapper();
    }

    @Override
    public List<AccountDto> retrieveAll() {
        return accountRepository
                .findAll()
                .stream()
                .map(account -> modelMapper.map(account, AccountDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AccountUpdateDto retrieveById(long id) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account Not Found!" + id));

        return modelMapper.map(account, AccountUpdateDto.class);
    }


    @Override
    public long create(AccountCreateDto accountCreateDto) {
        Account account = modelMapper.map(accountCreateDto, Account.class);
        return accountRepository.create(account);
    }

    @Override
    public void deleteById(long id, long deleteBy, LocalDateTime deletedDate) {
        accountRepository.deleteById(id, deleteBy, deletedDate);
    }
}
