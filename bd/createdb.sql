DROP SCHEMA_NAME IF EXISTS easybooking;
DROP USER IF EXISTS 'test'@'%';

CREATE SCHEMA_NAME easybooking;
CREATE USER 'test' IDENTIFIED BY 'test'; *
GRANT ALL PRIVILEGES ON easybooking.* TO 'test'@'%';