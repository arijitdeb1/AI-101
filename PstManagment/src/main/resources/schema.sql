--drop table if exists entity;
CREATE TABLE entity (
    id INT PRIMARY KEY,
    item_type VARCHAR(255),
    name VARCHAR(255),
    attributes VARCHAR(500),
    created_dt TIMESTAMP
);