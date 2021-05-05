create table contacts(
id int8 not null ,
address varchar (255) default null ,
city varchar (255) default null ,
email varchar (255) default null ,
mobile varchar (255) default  null ,
pin varchar (255) default  null ,
created_by int8 null,
created_date timestamp not null default CURRENT_TIMESTAMP,
updated_by int8 null,
updated_date timestamp null,
deleted_by int8 null,
deleted_date timestamp null ,
is_deleted bit not null default bit'0',
constraint pk_iid primary key (id)
);