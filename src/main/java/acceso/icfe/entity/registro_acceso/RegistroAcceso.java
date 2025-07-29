package acceso.icfe.entity.registro_acceso;

import acceso.icfe.audit.AuditableEntity;
import acceso.icfe.entity.usuario.Usuario;
import acceso.icfe.entity.vehiculo.Vehiculo;
import lombok.*;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@EntityListeners({AuditingEntityListener.class})
@Table(name = "registro_acceso")
public class RegistroAcceso extends AuditableEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(optional = true) // Puede ingresar sin vehículo
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    @Column(name = "tipo_movimiento", nullable = false)
    private String tipoMovimiento;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;
}
