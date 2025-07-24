package acceso.icfe.DTO.usuario;

// UsuarioRequestDTO.java
public record UsuarioRequestDTO(
        String nombres,
        String apellidos,
        String telefono,
        String casa,
        String nombreUsuario,
        String contrasena
) {
}
