package acceso.icfe.controller.rol;

import acceso.icfe.DTO.rol.RolRequestDTO;
import acceso.icfe.entity.rol.Rol;
import acceso.icfe.service.rol.RolService;
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


    @PostMapping("/crear")
    public ResponseEntity<Rol> crearRol(@RequestBody RolRequestDTO dto) {
        return ResponseEntity.ok(rolService.crearRol(dto));
    }



}
