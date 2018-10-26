DROP SCHEMA IF EXISTS easybooking;
DROP USER IF EXISTS 'test'@'%';

CREATE SCHEMA easybooking;
CREATE USER 'test'
  IDENTIFIED BY 'test';
GRANT ALL PRIVILEGES ON easybooking.* TO 'test'@'%';