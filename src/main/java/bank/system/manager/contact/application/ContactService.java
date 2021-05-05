package bank.system.manager.contact.application;

import bank.system.manager.contact.application.dto.ContactCreateDto;
import bank.system.manager.contact.application.dto.ContactDto;
import bank.system.manager.contact.application.dto.ContactUpdateDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ContactService {
    List<ContactDto> retrieveAll();

    ContactUpdateDto retrieveById(long id);

    long create(ContactCreateDto contactCreateDto);

    void  update(ContactUpdateDto contactUpdateDto);

    void  deleteById(long id, long deleteBy, LocalDateTime deletedDate);
}
