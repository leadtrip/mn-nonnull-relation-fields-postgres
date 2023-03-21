CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS role
(
    id           UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name         varchar(128)  not null
);

CREATE TABLE IF NOT EXISTS employee
(
    id           UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name         varchar(128) not null
);


CREATE TABLE IF NOT EXISTS employee_roles
(
    employee_id UUID not null,
    role_id UUID not null
);

