package acceso.icfe.controller.usuario;

import acceso.icfe.DTO.usuario.UsuarioRequestDTO;
import acceso.icfe.DTO.usuario.UsuarioRolRequestDTO;
import acceso.icfe.entity.usuario.Usuario;
import acceso.icfe.entity.usuario.UsuarioRol;
import acceso.icfe.service.rol_x_usuario.UsuarioRolService;
import acceso.icfe.service.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/usuario")
@RestController
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRolService usuarioRolService;
    @PostMapping("/crear")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody UsuarioRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.crearUsuario(dto));
    }

    @PostMapping("/asignar-rol")
    public ResponseEntity<UsuarioRol> asignarRol(@RequestBody UsuarioRolRequestDTO dto) {
        return ResponseEntity.ok(usuarioRolService.asignarRolAUsuario(dto));
    }

}
