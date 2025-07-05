package acceso.icfe.controller.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/auth")
@RestController
public class UsuarioController {

    @PostMapping("/registro")
    public ResponseEntity resgistroUsuario(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
