package acceso.icfe.controller.auth;

import acceso.icfe.DTO.auth.AuthRequestDTO;
import acceso.icfe.DTO.auth.AuthResponseDTO;
import acceso.icfe.entity.usuario.Usuario;
import acceso.icfe.repository.usuario.UsuarioRepository;
import acceso.icfe.service.auth.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO dto) {
        try {
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.nombreUsuario(), dto.contrasena())
            );
            Usuario usuario = (Usuario) auth.getPrincipal();
            if (usuario.getRol() == null) {
                return ResponseEntity
                        .status(403)
                        .body("El usuario no tiene un rol asignado. Comuníquese con el administrador.");
            }

            String rol = usuario.getRol().getNombre();
            String token = jwtService.generateToken(usuario);

            return ResponseEntity.ok(new AuthResponseDTO(token, rol));

        } catch (BadCredentialsException e) {
            return ResponseEntity
                    .status(401)
                    .body("Usuario o contraseña inválidos");
        }
    }

}
