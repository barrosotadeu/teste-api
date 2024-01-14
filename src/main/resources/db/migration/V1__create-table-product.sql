CREATE TABLE product (
    id serial PRIMARY KEY UNIQUE NOT NULL,
    name varchar NOT NULL,
    price float NOT NULL
);