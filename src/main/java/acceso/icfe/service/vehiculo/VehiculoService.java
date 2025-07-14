package acceso.icfe.service.vehiculo;

import acceso.icfe.DTO.VehiculoRequestDTO;
import acceso.icfe.entity.vehiculo.Vehiculo;

public interface VehiculoService {
    Vehiculo registrarVehiculo(VehiculoRequestDTO dto);
}
