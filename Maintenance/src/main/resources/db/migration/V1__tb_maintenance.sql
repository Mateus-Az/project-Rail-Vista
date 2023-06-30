CREATE SCHEMA IF NOT EXISTS tb_maintenance;

CREATE TABLE tb_maintenance.maintenance (
    id UUID PRIMARY KEY,
    value_of_maintenance DOUBLE PRECISION NOT NULL,
    time_service TIMESTAMP NOT NULL,
    train_id UUID,
    FOREIGN KEY (train_id) REFERENCES tb_train.train(id)
);