package acceso.icfe.controller.usuario;

import acceso.icfe.DTO.RolRequestDTO;
import acceso.icfe.DTO.UsuarioRequestDTO;
import acceso.icfe.DTO.UsuarioRolRequestDTO;
import acceso.icfe.entity.rol.Rol;
import acceso.icfe.entity.usuario.Usuario;
import acceso.icfe.entity.usuario_X_Rol.UsuarioRol;
import acceso.icfe.service.rol.RolService;
import acceso.icfe.service.rol_x_usuario.UsuarioRolService;
import acceso.icfe.service.usuario.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/auth")
@RestController
public class UsuarioController {


    private UsuarioService usuarioService;
    private  RolService rolService;
    private UsuarioRolService usuarioRolService;

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody UsuarioRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.crearUsuario(dto));
    }

    @PostMapping("/rol")
    public ResponseEntity<Rol> crearRol(@RequestBody RolRequestDTO dto) {
        return ResponseEntity.ok(rolService.crearRol(dto));
    }

    @PostMapping("/asignar-rol")
    public ResponseEntity<UsuarioRol> asignarRol(@RequestBody UsuarioRolRequestDTO dto) {
        return ResponseEntity.ok(usuarioRolService.asignarRolAUsuario(dto));
    }
}
