package acceso.icfe.service.usuario;

import acceso.icfe.DTO.usuario.AsignarRolRequestDTO;
import acceso.icfe.DTO.usuario.UsuarioRequestDTO;
import acceso.icfe.DTO.usuario.UsuarioResponseDTO;
import acceso.icfe.DTO.vehiculo.VehiculoResponseDTO;
import acceso.icfe.entity.rol.Rol;
import acceso.icfe.entity.usuario.Usuario;
import acceso.icfe.repository.rol.RolRepository;
import acceso.icfe.repository.usuario.UsuarioRepository;
import acceso.icfe.utils.EstadoUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto) {
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

        return mapToDto(usuarioRepository.save(usuario));
    }


    @Override
    public UsuarioResponseDTO asignarRol(AsignarRolRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Rol rol = rolRepository.findById(dto.rolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        usuario.setRol(rol);
        return mapToDto(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioResponseDTO asiganarCodigoQr(String code, Long idUsuario) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("El código QR no puede estar vacío.");
        }

        // Verificar si ya está en uso por otro usuario
        usuarioRepository.findUsuarioByRutaCodigoQr(code).ifPresent(usuarioExistente -> {
            throw new RuntimeException("El código QR ya está asignado a otro usuario.");
        });

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + idUsuario));

        usuario.setRutaCodigoQr(code);
        return mapToDto(usuarioRepository.save(usuario));
    }

    @Override
    public Usuario buscarUserPorCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("El código QR no puede estar vacío.");
        }
        Optional<Usuario> optionalUsuario = usuarioRepository.findUsuarioByRutaCodigoQr(code);

        if (optionalUsuario.isPresent()) {
            return ((optionalUsuario.get()));
        } else {
            throw new RuntimeException("No se encontró un usuario con el código QR proporcionado.");
        }
    }

    public UsuarioResponseDTO mapToDto(Usuario usuario, VehiculoResponseDTO vehiculo) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getTelefono(),
                usuario.getCasa(),
                usuario.getNombreUsuario(),
                usuario.getEstado().name(),
                usuario.getRol() != null ? usuario.getRol().getNombre() : "SIN_ROL",
                vehiculo
        );
    }


    public UsuarioResponseDTO mapToDto(Usuario usuario) {
        return mapToDto(usuario, null);
    }

    public Usuario mapToEntity(UsuarioResponseDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.id());
        usuario.setNombres(dto.nombres());
        usuario.setApellidos(dto.apellidos());
        usuario.setTelefono(dto.telefono());
        usuario.setCasa(dto.casa());
        usuario.setNombreUsuario(dto.nombreUsuario());
        usuario.setEstado(EstadoUsuario.valueOf(dto.estado()));
        return usuario;
    }







}


