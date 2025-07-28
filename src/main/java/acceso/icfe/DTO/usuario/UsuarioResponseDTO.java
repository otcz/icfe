package acceso.icfe.DTO.usuario;

public record UsuarioResponseDTO(
        Long id,
        String nombres,
        String apellidos,
        String telefono,
        String casa,
        String nombreUsuario,
        String estado,
        String rol
) {
}
