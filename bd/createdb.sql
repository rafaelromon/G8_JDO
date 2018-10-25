/* DROP SCHEMA IF EXISTS easybooking; */
DROP SCHEMA_NAME IF EXISTS easybooking; /* MariaDB*/
DROP USER IF EXISTS 'test'@'%';

CREATE SCHEMA_NAME easybooking;
CREATE USER 'test' IDENTIFIED BY 'test'; *
GRANT ALL PRIVILEGES ON easybooking.* TO 'test'@'%';