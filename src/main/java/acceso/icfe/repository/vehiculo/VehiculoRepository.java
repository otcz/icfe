package acceso.icfe.repository.vehiculo;

import acceso.icfe.entity.vehiculo.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    // Puedes agregar métodos personalizados si los necesitas más adelante
}
