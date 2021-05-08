package bank.system.manager.contact;


import bank.system.manager.contact.application.ContactService;
import bank.system.manager.contact.application.dto.ContactCreateDto;
import bank.system.manager.contact.application.dto.ContactDto;
import bank.system.manager.contact.application.dto.ContactUpdateDto;
import bank.system.manager.shared.UserContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/contacts")
public class ContactController {
    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping(value = "retrieve-all")
    @ResponseBody
    public List<ContactDto> retrieveAll() {
        return contactService.retrieveAll();
    }

    @GetMapping(value = "/retrieve-by-id/{id}")
    @ResponseBody
    public ContactUpdateDto retrieveById(@PathVariable Long id) {
        return contactService.retrieveById(id);
    }

    @PostMapping(value = "/create")
    public long create(@Valid @RequestBody ContactCreateDto contactCreateDto) {
        contactCreateDto.setCreatedBy(UserContextHolder.getUserId());
        contactCreateDto.setCreatedDate(LocalDateTime.now());
        return contactService.create(contactCreateDto);
    }

    @PutMapping(value = "/update")
    public void update(@Valid @RequestBody ContactUpdateDto contactUpdateDto) {
        contactUpdateDto.setUpdatedBy(UserContextHolder.getUserId());
        contactUpdateDto.setUpdatedDate(LocalDateTime.now());
        contactService.update(contactUpdateDto);
    }

    @DeleteMapping(value = "/deleted/{id}")
    public void delete(@PathVariable Long id) {
        contactService.deleteById(id, UserContextHolder.getUserId(), LocalDateTime.now());
    }

}
