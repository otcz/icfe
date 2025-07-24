package acceso.icfe.service.rol;

import acceso.icfe.DTO.rol.RolRequestDTO;
import acceso.icfe.entity.rol.Rol;

public interface RolService {
    Rol crearRol(RolRequestDTO dto);
}
