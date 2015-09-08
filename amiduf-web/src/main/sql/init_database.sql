-- en user root (postgres)
CREATE USER amiduf WITH PASSWORD 'amiduf';
CREATE DATABASE "amidufdb" WITH ENCODING='UTF8' OWNER=amiduf CONNECTION LIMIT=-1; 
GRANT ALL PRIVILEGES ON SCHEMA pg_catalog to amiduf;
GRANT ALL PRIVILEGES ON SCHEMA information_schema to amiduf;