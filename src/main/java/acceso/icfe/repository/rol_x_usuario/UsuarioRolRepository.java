package acceso.icfe.repository.rol_x_usuario;

import acceso.icfe.entity.rol.Rol;
import acceso.icfe.entity.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRolRepository extends JpaRepository<Rol,Integer> {
    boolean existsByUsuarioAndRol(Usuario usuario, Rol rol);
}
