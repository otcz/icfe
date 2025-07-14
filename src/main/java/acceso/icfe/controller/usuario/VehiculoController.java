package acceso.icfe.controller.usuario;


import acceso.icfe.DTO.VehiculoRequestDTO;
import acceso.icfe.entity.vehiculo.Vehiculo;
import acceso.icfe.service.vehiculo.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/vehiculo")
@RestController
public class VehiculoController {
    @Autowired VehiculoService vehiculoService;

    @PostMapping("/registrar")
    public ResponseEntity<Vehiculo> registrarVehiculo(@RequestBody VehiculoRequestDTO dto) {
        Vehiculo vehiculo = vehiculoService.registrarVehiculo(dto);
        return ResponseEntity.ok(vehiculo);
    }
}
