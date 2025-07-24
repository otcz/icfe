package acceso.icfe.controller.vehiculo;


import acceso.icfe.DTO.vehiculo.VehiculoRequestDTO;
import acceso.icfe.DTO.vehiculo.VehiculoResponseDTO;
import acceso.icfe.entity.vehiculo.Vehiculo;
import acceso.icfe.service.vehiculo.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/vehiculo")
@RestController
public class VehiculoController {
    @Autowired
    VehiculoService vehiculoService;

    @PostMapping("/registrar")
    public ResponseEntity<VehiculoResponseDTO> registrarVehiculo(@RequestBody VehiculoRequestDTO dto) {
        VehiculoResponseDTO vehiculo = vehiculoService.registrarVehiculo(dto);
        return ResponseEntity.ok(vehiculo);
    }
}
