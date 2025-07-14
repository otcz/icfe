package acceso.icfe.repository.rol_x_usuario;

import acceso.icfe.entity.rol.Rol;
import acceso.icfe.entity.usuario.Usuario;
import acceso.icfe.entity.usuario_X_Rol.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long> {
    boolean existsByUsuarioAndRol(Usuario usuario, Rol rol);
}

