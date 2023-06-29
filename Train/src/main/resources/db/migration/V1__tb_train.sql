CREATE SCHEMA IF NOT EXISTS tb_train;

CREATE TABLE tb_train.train (
    id UUID PRIMARY KEY,
    number_of_passagers INTEGER,
    wagons INTEGER,
    value_of_ticket DOUBLE PRECISION
);
