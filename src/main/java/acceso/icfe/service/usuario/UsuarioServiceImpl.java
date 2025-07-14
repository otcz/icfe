package acceso.icfe.service.usuario;

import acceso.icfe.DTO.UsuarioRequestDTO;
import acceso.icfe.entity.usuario.Usuario;
import acceso.icfe.repository.usuario.UsuarioRepository;
import acceso.icfe.utils.EstadoUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombres(dto.nombres());
        usuario.setApellidos(dto.apellidos());
        usuario.setTelefono(dto.telefono());
        usuario.setCasa(dto.casa());
        usuario.setNombreUsuario(dto.nombreUsuario());
        usuario.setContrasena(dto.contrasena());
        usuario.setEstado(EstadoUsuario.ACTIVO);
        return usuarioRepository.save(usuario);
    }
}
