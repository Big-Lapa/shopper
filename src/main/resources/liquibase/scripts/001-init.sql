CREATE TABLE product
(
    id    UUID         NOT NULL,
    added TIMESTAMP WITHOUT TIME ZONE,
    name  VARCHAR(255) NOT NULL,
    price numeric(10, 2),
    CONSTRAINT product_pkey PRIMARY KEY (id)
)