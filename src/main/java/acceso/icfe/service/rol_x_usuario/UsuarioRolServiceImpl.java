package acceso.icfe.service.rol_x_usuario;


import acceso.icfe.DTO.UsuarioRolRequestDTO;
import acceso.icfe.entity.rol.Rol;
import acceso.icfe.entity.usuario.Usuario;
import acceso.icfe.entity.usuario_X_Rol.UsuarioRol;
import acceso.icfe.repository.rol.RolRepository;
import acceso.icfe.repository.rol_x_usuario.UsuarioRolRepository;
import acceso.icfe.repository.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UsuarioRolServiceImpl implements UsuarioRolService {

    private final UsuarioRepository usuarioRepo;
    private final RolRepository rolRepo;
    private final UsuarioRolRepository usuarioRolRepo;

    @Override
    public UsuarioRol asignarRolAUsuario(UsuarioRolRequestDTO dto) {
        Usuario usuario = usuarioRepo.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Rol rol = rolRepo.findById(dto.rolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        if (usuarioRolRepo.existsByUsuarioAndRol(usuario, rol)) {
            throw new RuntimeException("Ya asignado");
        }

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);
        usuarioRol.setFechaAsignacion(LocalDateTime.now());

        return usuarioRolRepo.save(usuarioRol);
    }
}


