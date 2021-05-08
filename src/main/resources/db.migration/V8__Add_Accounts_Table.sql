create table accounts(
                       id bigserial NOT NULL ,
                       sum int8 null ,
                       owner_id int8  null ,
                       created_by int8 null,
                       created_date timestamp not null default CURRENT_TIMESTAMP,
                       updated_by int8 null,
                       updated_date timestamp null,
                       deleted_by int8 null,
                       deleted_date timestamp null ,
                       is_deleted bit not null default bit'0',
                       constraint pk_payeer_id primary key(id),
                       constraint fk_customer_created_by foreign key (created_by) references users (id),
                       constraint fk_customer_updated_by foreign key (updated_by) references users (id),
                       constraint fk_customer_deleted_by foreign key (deleted_by) references users (id),
                       constraint fk_customer foreign key (owner_id) references customers(id)
                     );