package acceso.icfe.service.rol;

import acceso.icfe.DTO.RolRequestDTO;
import acceso.icfe.entity.rol.Rol;

public interface RolService {
    Rol crearRol(RolRequestDTO dto);
}
