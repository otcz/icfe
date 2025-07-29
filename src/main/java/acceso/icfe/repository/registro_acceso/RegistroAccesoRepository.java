package acceso.icfe.repository.registro_acceso;

import acceso.icfe.entity.registro_acceso.RegistroAcceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroAccesoRepository extends JpaRepository<RegistroAcceso, Long> {

}
