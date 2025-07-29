package acceso.icfe.repository.vehiculo;

import acceso.icfe.DTO.vehiculo.VehiculoResponseDTO;
import acceso.icfe.entity.vehiculo.Vehiculo;
import acceso.icfe.utils.EstadoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    Optional<Vehiculo> findByPropietarioId(Long propietarioId);

    List<Vehiculo> findAllByPropietarioId(Long propietarioId);

    List<Vehiculo> findAllByPropietarioIdAndEstado(Long propietarioId, EstadoVehiculo estado);




}
