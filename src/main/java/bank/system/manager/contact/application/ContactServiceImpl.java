package bank.system.manager.contact.application;

import bank.system.manager.contact.application.dto.ContactCreateDto;
import bank.system.manager.contact.application.dto.ContactDto;
import bank.system.manager.contact.application.dto.ContactUpdateDto;
import bank.system.manager.contact.application.exception.ContactNotFoundException;
import bank.system.manager.contact.domain.ContactRepository;
import bank.system.manager.contact.domain.model.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;
    private ModelMapper modelMapper;

    public ContactServiceImpl(){
        contactRepository=new ContactRepository();
        modelMapper=new ModelMapper();
    }

    @Override
    public List<ContactDto> retrieveAll() {
        return contactRepository
                .findAll()
                .stream()
                .map(contact -> modelMapper.map(contact,ContactDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ContactUpdateDto retrieveById(long id) {
        Contact contact=contactRepository
                .findById(id)
                .orElseThrow(()->new ContactNotFoundException("Contact Not Found!"+id));

        return modelMapper.map(contact,ContactUpdateDto.class);
    }

    @Override
    public long create(ContactCreateDto contactCreateDto) {
        Contact contact=modelMapper.map(contactCreateDto,Contact.class);
        return contactRepository.create(contact);
    }

    @Override
    public void update(ContactUpdateDto contactUpdateDto) {
        Contact contact=modelMapper.map(contactUpdateDto,Contact.class);
        contactRepository.update(contact);
    }

    @Override
    public void deleteById(long id, long deleteBy, LocalDateTime deletedDate) {
          contactRepository.deleteById(id,deleteBy,deletedDate);
    }
}
