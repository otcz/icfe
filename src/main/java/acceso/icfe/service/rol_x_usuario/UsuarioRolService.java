package acceso.icfe.service.rol_x_usuario;

import acceso.icfe.DTO.usuario.UsuarioRolRequestDTO;
import acceso.icfe.entity.usuario.UsuarioRol;


public interface UsuarioRolService {
    UsuarioRol asignarRolAUsuario(UsuarioRolRequestDTO dto);
}


