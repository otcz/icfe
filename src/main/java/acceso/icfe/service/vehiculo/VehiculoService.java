package acceso.icfe.service.vehiculo;

import acceso.icfe.DTO.vehiculo.VehiculoRequestDTO;
import acceso.icfe.DTO.vehiculo.VehiculoResponseDTO;
import acceso.icfe.entity.vehiculo.Vehiculo;

import java.util.List;

public interface VehiculoService {
    VehiculoResponseDTO registrarVehiculo(VehiculoRequestDTO dto);

    VehiculoResponseDTO findVehiculoByPropietario(Long id);

    List <VehiculoResponseDTO> findVehiculosByPropietario(Long id);
}
