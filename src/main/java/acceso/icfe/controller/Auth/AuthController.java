package acceso.icfe.controller.Auth;

import acceso.icfe.DTO.Auth.AuthRequestDTO;
import acceso.icfe.DTO.Auth.AuthResponseDTO;
import acceso.icfe.entity.usuario.Usuario;
import acceso.icfe.repository.usuario.UsuarioRepository;
import acceso.icfe.service.Auth.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private  AuthenticationManager authManager;
    @Autowired
    private  JwtService jwtService;
    @Autowired
    private  UsuarioRepository usuarioRepo;

        @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO dto) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.nombreUsuario(), dto.contrasena())
        );

        Usuario usuario = (Usuario) auth.getPrincipal();
        String rol = usuario.getRolesAsignados().stream()
                .findFirst()
                .map(r -> r.getRol().getNombre())
                .orElse("SIN_ROL");

        String token = jwtService.generateToken(usuario);
        return ResponseEntity.ok(new AuthResponseDTO(token, rol));
    }
}
