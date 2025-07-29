package acceso.icfe.controller.usuario;

import acceso.icfe.DTO.usuario.AsignarCodeRequestDTO;
import acceso.icfe.DTO.usuario.AsignarRolRequestDTO;
import acceso.icfe.DTO.usuario.UsuarioRequestDTO;
import acceso.icfe.DTO.usuario.UsuarioResponseDTO;
import acceso.icfe.entity.usuario.Usuario;
import acceso.icfe.service.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/usuario")
@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/crear")
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(@RequestBody UsuarioRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.crearUsuario(dto));
    }

    @PostMapping("/asignar-rol")
    public ResponseEntity<UsuarioResponseDTO> asignarRol(@RequestBody AsignarRolRequestDTO dto) {
        UsuarioResponseDTO usuario = usuarioService.asignarRol(dto);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/asignar-code")
    public ResponseEntity<?> asignarCode(@RequestBody AsignarCodeRequestDTO dto) {
        try {
            UsuarioResponseDTO usuario = usuarioService.asiganarCodigoQr(dto.code(), dto.idUsuario());
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }



}
