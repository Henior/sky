DROP TABLE USER IF EXISTS ;
CREATE TABLE USER (
      id bigint generated by default as identity,
      username varchar(16),
      name varchar(24),
      age int(2),
      balance decimal(12,2),
      primary key (id)
);