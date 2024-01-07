create table tasks (
    status boolean,
    id bigserial not null,
    description varchar(2048),
    title varchar(2048) not null,
    primary key (id)
);

create table cats
(
    id bigserial not null,
    name varchar(64) ,
    breed varchar(64),
    primary key (id)
);