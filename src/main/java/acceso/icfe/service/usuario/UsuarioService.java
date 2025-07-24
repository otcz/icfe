package acceso.icfe.service.usuario;

import acceso.icfe.DTO.usuario.AsignarRolRequestDTO;
import acceso.icfe.DTO.usuario.UsuarioRequestDTO;
import acceso.icfe.entity.usuario.Usuario;

public interface UsuarioService {

    Usuario crearUsuario(UsuarioRequestDTO dto);
    Usuario asignarRol(AsignarRolRequestDTO dto);
}
