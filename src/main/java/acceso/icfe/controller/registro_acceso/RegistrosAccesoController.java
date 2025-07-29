package acceso.icfe.controller.registro_acceso;

import acceso.icfe.DTO.usuario.UsuarioResponseDTO;
import acceso.icfe.DTO.vehiculo.VehiculoResponseDTO;
import acceso.icfe.entity.registro_acceso.RegistroAcceso;
import acceso.icfe.entity.usuario.Usuario;
import acceso.icfe.service.registro_acceso.RegistroAccesoService;
import acceso.icfe.service.registro_acceso.RegistroAccesoServiceImpl;
import acceso.icfe.service.usuario.UsuarioServiceImpl;
import acceso.icfe.service.vehiculo.VehiculoServiceImpl;
import acceso.icfe.utils.TipoRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("api/acceso")
@RestController
public class RegistrosAccesoController {

    @Autowired
    private VehiculoServiceImpl vehiculoService;

    @Autowired
    private UsuarioServiceImpl usuarioService;


    @PostMapping("/validar/{code}")
    public ResponseEntity<?> registrarAcceso(@PathVariable String code) {
        try {
            Usuario usuarioEntity = usuarioService.buscarUserPorCode(code); // necesitas este método
            List<VehiculoResponseDTO> vehiculo = vehiculoService.findVehiculosByPropietario(usuarioEntity.getId());
            UsuarioResponseDTO dto = usuarioService.mapToDto(usuarioEntity, vehiculo);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


}
