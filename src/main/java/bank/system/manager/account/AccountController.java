package bank.system.manager.account;


import bank.system.manager.account.application.AccountService;
import bank.system.manager.account.application.dto.AccountCreateDto;
import bank.system.manager.account.application.dto.AccountDto;
import bank.system.manager.account.application.dto.AccountUpdateDto;
import bank.system.manager.shared.UserContextHolder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping(value = "/retrieve-all")
    @ResponseBody
    public List<AccountDto> retrieveAll() {
        return accountService.retrieveAll();
    }

    @GetMapping(value = "/retrieve-by-id/{id}")
    @ResponseBody
    public AccountUpdateDto retrieveById(@PathVariable Long id) {
        return accountService.retrieveById(id);
    }

    @PostMapping(value = "/create")
    public long create(@Valid @RequestBody AccountCreateDto accountCreateDto) {
        accountCreateDto.setCreatedBy(UserContextHolder.getUserId());
        accountCreateDto.setCreatedDate(LocalDateTime.now());
        return accountService.create(accountCreateDto);
    }

    @PutMapping(value = "/update")
    public void update(@Valid @RequestBody AccountUpdateDto accountUpdateDto){
        accountUpdateDto.setUpdatedBy(UserContextHolder.getUserId());
        accountUpdateDto.setUpdatedDate(LocalDateTime.now());
        accountService.update(accountUpdateDto);
    }
    @DeleteMapping(value = "/deleted/{id}")
    public void delete(@PathVariable Long id) {
        accountService.deleteById(id, UserContextHolder.getUserId(), LocalDateTime.now());
    }
}
