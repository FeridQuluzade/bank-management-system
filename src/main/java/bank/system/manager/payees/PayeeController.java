package bank.system.manager.payees;

import bank.system.manager.payees.application.PayeeService;
import bank.system.manager.payees.application.dto.PayeeCreateDto;
import bank.system.manager.shared.UserContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;


@RestController
@RequestMapping(value = "/payees")
public class PayeeController {
    private PayeeService payeeService;

    @Autowired
    public PayeeController(PayeeService payeeService) {
        this.payeeService = payeeService;
    }

    @PostMapping(value = "/create")
    public long create(@Valid @RequestBody PayeeCreateDto payeeCreateDto) {
        payeeCreateDto.setPayment_month(payeeCreateDto.getAccountid());
        payeeCreateDto.setPayment_year(payeeCreateDto.getAccountid());
        payeeCreateDto.setCreatedBy(UserContextHolder.getUserId());
        payeeCreateDto.setCreatedDate(LocalDateTime.now());
        return payeeService.create(payeeCreateDto);
    }

}
