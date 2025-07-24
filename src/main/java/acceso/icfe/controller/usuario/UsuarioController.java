package acceso.icfe.controller.usuario;

import acceso.icfe.DTO.usuario.AsignarRolRequestDTO;
import acceso.icfe.DTO.usuario.UsuarioRequestDTO;
import acceso.icfe.entity.usuario.Usuario;
import acceso.icfe.service.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/usuario")
@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/crear")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody UsuarioRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.crearUsuario(dto));
    }

    @PostMapping("/asignar-rol")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Usuario> asignarRol(@RequestBody AsignarRolRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.asignarRol(dto));
    }


}
