package acceso.icfe.DTO.usuario;

import acceso.icfe.DTO.vehiculo.VehiculoResponseDTO;

import java.util.List;

public record UsuarioResponseDTO(
        Long id,
        String nombres,
        String apellidos,
        String telefono,
        String casa,
        String nombreUsuario,
        String estado,
        String rol,
        List <VehiculoResponseDTO> vehiculo
) {
}
