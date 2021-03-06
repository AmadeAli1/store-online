/* Table 'Item' */
/* Table 'Company' */
CREATE TABLE if not exists company
(
    id        integer primary key NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    name      varchar(50)         NOT NULL,
    email     varchar             NOT NULL,
    contact   varchar(20)         NOT NULL,
    region    varchar(40)         NOT NULL,
    imageLogo varchar             NOT NULL
);
/* Table 'Category' */
CREATE TABLE if not exists category
(
    id   integer primary key NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    name varchar(30)         NOT NULL
);
CREATE TABLE if not exists item
(
    id         integer primary key NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    name       varchar(50)         NOT NULL,
    category   varchar             NOT NULL,
    price      float8              NOT NULL,
    image      varchar             NOT NULL,
    date       date                NOT NULL default current_date,
    companyId  integer             NOT NULL references company (id) on delete cascade on update cascade,
    categoryId integer             NOT NULL references category (id) on delete cascade on update cascade
);

/* Table 'User' */
CREATE TABLE if not exists usuario
(
    id    varchar primary key NOT NULL unique,
    email varchar             NOT NULL,
    name  varchar             NOT NULL,
    image varchar
);

/* Table 'UserItem' */
CREATE TABLE if not exists usuarioItem
(
    id     integer primary key NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    itemId integer             NOT NULL references item (id) on delete cascade on update cascade,
    userId varchar             NOT NULL references usuario (id) on delete cascade on update cascade,
    status varchar             NOT NULL
);