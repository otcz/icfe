package acceso.icfe.controller.usuario;

import acceso.icfe.DTO.RolRequestDTO;
import acceso.icfe.DTO.UsuarioRolRequestDTO;
import acceso.icfe.entity.rol.Rol;
import acceso.icfe.entity.usuario_X_Rol.UsuarioRol;
import acceso.icfe.service.rol.RolService;
import acceso.icfe.service.rol_x_usuario.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/rol")
@RestController
public class RolController {

    @Autowired
    RolService rolService;
    @Autowired
    UsuarioRolService usuarioRolService;

    @PostMapping("/crear")
    public ResponseEntity<Rol> crearRol(@RequestBody RolRequestDTO dto) {
        return ResponseEntity.ok(rolService.crearRol(dto));
    }

    @PostMapping("/asignar-rol")
    public ResponseEntity<UsuarioRol> asignarRol(@RequestBody UsuarioRolRequestDTO dto) {
        return ResponseEntity.ok(usuarioRolService.asignarRolAUsuario(dto));
    }

}
