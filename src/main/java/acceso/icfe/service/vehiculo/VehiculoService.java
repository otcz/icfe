package acceso.icfe.service.vehiculo;

import acceso.icfe.DTO.vehiculo.VehiculoRequestDTO;
import acceso.icfe.DTO.vehiculo.VehiculoResponseDTO;
import acceso.icfe.entity.vehiculo.Vehiculo;

public interface VehiculoService {
    VehiculoResponseDTO registrarVehiculo(VehiculoRequestDTO dto);
}
