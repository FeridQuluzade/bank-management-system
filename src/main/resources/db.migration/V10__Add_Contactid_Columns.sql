ALTER table customers
    Add constraint fk_contact_id foreign key(contact_id) references contacts(id);