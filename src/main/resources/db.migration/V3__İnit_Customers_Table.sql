create table customers
(
    id bigserial NOT NULL ,
    name varchar (255) default NULL ,
    gender varchar(255) default NULL ,
    married varchar (255) default NULL ,
    status varchar (255) default NULL ,
    contact_id int8 default NULL ,
    occupation varchar (255) default NULL ,
    created_by int8 null,
    created_date timestamp not null default CURRENT_TIMESTAMP,
    updated_by int8 null,
    updated_date timestamp null,
    deleted_by int8 null,
    deleted_date timestamp null ,
    is_deleted bit not null default bit'0',
    constraint pk_id primary key (id),


    constraint fk_customer_created_by foreign key (created_by) references users (id),
    constraint fk_customer_updated_by foreign key (updated_by) references users (id),
    constraint fk_customer_deleted_by foreign key (deleted_by) references users (id)
);