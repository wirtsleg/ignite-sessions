CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    email    VARCHAR(30)  NOT NULL,
    password VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX users_email_idx ON users ((lower (email)) );
