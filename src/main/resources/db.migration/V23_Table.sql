ALTER  table employees
    add constraint fk_employe_id foreign  key(contact_id) references contacts(id);