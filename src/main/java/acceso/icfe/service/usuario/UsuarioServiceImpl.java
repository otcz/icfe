package acceso.icfe.service.usuario;

import acceso.icfe.DTO.usuario.AsignarRolRequestDTO;
import acceso.icfe.DTO.usuario.UsuarioRequestDTO;
import acceso.icfe.DTO.usuario.UsuarioResponseDTO;
import acceso.icfe.entity.rol.Rol;
import acceso.icfe.entity.usuario.Usuario;
import acceso.icfe.repository.rol.RolRepository;
import acceso.icfe.repository.usuario.UsuarioRepository;
import acceso.icfe.utils.EstadoUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Usuario crearUsuario(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombres(dto.nombres());
        usuario.setApellidos(dto.apellidos());
        usuario.setTelefono(dto.telefono());
        usuario.setCasa(dto.casa());
        usuario.setNombreUsuario(dto.nombreUsuario());

        // Encriptar la contraseña si usas BCrypt
        usuario.setContrasena(passwordEncoder.encode(dto.contrasena()));

        usuario.setEstado(EstadoUsuario.ACTIVO);

        // No se asigna rol en la creación
        usuario.setRol(null);

        return usuarioRepository.save(usuario);
    }


    @Override
    public Usuario asignarRol(AsignarRolRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Rol rol = rolRepository.findById(dto.rolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        usuario.setRol(rol);
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioResponseDTO mapToDto(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getTelefono(),
                usuario.getCasa(),
                usuario.getNombreUsuario(),
                usuario.getEstado().name(),
                usuario.getRol() != null ? usuario.getRol().getNombre() : "SIN_ROL"
        );
    }

}


