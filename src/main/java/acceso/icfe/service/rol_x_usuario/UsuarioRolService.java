package acceso.icfe.service.rol_x_usuario;

import acceso.icfe.DTO.UsuarioRolRequestDTO;
import acceso.icfe.entity.usuario_X_Rol.UsuarioRol;


public interface UsuarioRolService {
    UsuarioRol asignarRolAUsuario(UsuarioRolRequestDTO dto);
}


