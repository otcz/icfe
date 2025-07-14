package acceso.icfe.DTO;

// UsuarioRequestDTO.java
public record UsuarioRequestDTO(
        String nombres,
        String apellidos,
        String telefono,
        String casa,
        String nombreUsuario,
        String contrasena
) {}
