package acceso.icfe.service.usuario;

import acceso.icfe.DTO.usuario.AsignarRolRequestDTO;
import acceso.icfe.DTO.usuario.UsuarioRequestDTO;
import acceso.icfe.DTO.usuario.UsuarioResponseDTO;
import acceso.icfe.DTO.vehiculo.VehiculoResponseDTO;
import acceso.icfe.entity.usuario.Usuario;

public interface UsuarioService {

    UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto);

    UsuarioResponseDTO asignarRol(AsignarRolRequestDTO dto);

    UsuarioResponseDTO asiganarCodigoQr(String codigo, Long idUsuario);

    Usuario buscarUserPorCode(String code);


}
