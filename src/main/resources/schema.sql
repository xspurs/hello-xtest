DROP TABLE static_resource IF EXISTS;
CREATE TABLE static_resource (id bigint generated by default as identity (start with 1), static_resource_seq bigint, type VARCHAR(16), name VARCHAR(16), content VARCHAR(128));