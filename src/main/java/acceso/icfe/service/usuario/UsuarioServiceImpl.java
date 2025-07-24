package acceso.icfe.service.usuario;

import acceso.icfe.DTO.usuario.UsuarioRequestDTO;
import acceso.icfe.entity.usuario.Usuario;
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
        String passwordEncriptada = passwordEncoder.encode(dto.contrasena());
        usuario.setContrasena(passwordEncriptada);

        usuario.setEstado(EstadoUsuario.ACTIVO);
        return usuarioRepository.save(usuario);
    }
}
