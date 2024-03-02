
-- Create the companies table first
CREATE TABLE companies (
    id VARCHAR(255) PRIMARY KEY,
    correo VARCHAR(255),
    UNIQUE (correo)
);

-- Now create the users table with the foreign key
CREATE TABLE users (
    username VARCHAR(255) PRIMARY KEY,
    empresa_id VARCHAR(100) NOT NULL, -- Clave foránea para la empresa
    rol VARCHAR(30),
    encrypted_password VARCHAR(255)
);


INSERT INTO companies VALUES ('empresa_test', 'correo@gmail.com');
INSERT INTO users VALUES ('admin', 'empresa_test', 'ADMIN', '$2a$10$zW4Qg.LZ6b3ObX5IXXRhk.KLZRHSjkCD4pAfAJrX924Zt6YQJlYa2')
