package acceso.icfe.service.rol;

import acceso.icfe.DTO.RolRequestDTO;
import acceso.icfe.entity.rol.Rol;
import acceso.icfe.repository.rol.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    @Override
    public Rol crearRol(RolRequestDTO dto) {
        Rol rol = new Rol();
        rol.setNombre(dto.nombre());
        return rolRepository.save(rol);
    }
}