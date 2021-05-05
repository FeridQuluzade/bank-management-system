create table payees(

id int8 NOT NULL ,
created_by int8 null,
created_date timestamp not null default CURRENT_TIMESTAMP,
updated_by int8 null,
updated_date timestamp null,
deleted_by int8 null,
deleted_date timestamp null ,
is_deleted bit not null default bit'0',
constraint pk_payee_id primary key(id)
);