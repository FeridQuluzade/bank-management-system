ALTER table accounts
Add constraint fk_accountt_id Foreign key(owner_id) references customers(id);