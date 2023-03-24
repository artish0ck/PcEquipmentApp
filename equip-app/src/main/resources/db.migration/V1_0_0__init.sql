CREATE TABLE IF NOT EXISTS pc_equipment
(
    id      SERIAL PRIMARY KEY,
    model   VARCHAR,
    type    VARCHAR,
    status  BOOLEAN,
    created_date TIMESTAMP,
    comment VARCHAR
)


