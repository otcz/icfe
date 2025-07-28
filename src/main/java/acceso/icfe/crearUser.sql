
-- Insertar USUARIO admin con rol_id = 1 y contraseña 1234 (encriptada)
INSERT INTO usuarios (
    id, nombres, apellidos, telefono, casa, nombre_usuario, contrasena, estado, ruta_codigo_qr, rol_id
) VALUES (
             1, 'OSCAR TOMAS', 'CARRILLO ZULETA', '3135331533', 'ADMIN', 'OTCARRILLOZ',
             '$2a$10$Vi8X1zxVIoZiiAElXEck8.eWTqGxDErZu8Ut/DKS6Ykw9Dggy2FNu',
             'ACTIVO', null, null
         );
