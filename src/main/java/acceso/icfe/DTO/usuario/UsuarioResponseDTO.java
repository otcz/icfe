package acceso.icfe.DTO.usuario;

import acceso.icfe.DTO.vehiculo.VehiculoResponseDTO;

public record UsuarioResponseDTO(
        Long id,
        String nombres,
        String apellidos,
        String telefono,
        String casa,
        String nombreUsuario,
        String estado,
        String rol,
        VehiculoResponseDTO vehiculo
) {
}
