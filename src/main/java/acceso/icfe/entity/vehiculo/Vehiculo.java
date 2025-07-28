package acceso.icfe.entity.vehiculo;

import acceso.icfe.audit.AuditableEntity;
import acceso.icfe.entity.usuario.Usuario;
import acceso.icfe.utils.EstadoVehiculo;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@EntityListeners({AuditingEntityListener.class})
@Table(name = "vehiculo")
public class Vehiculo extends AuditableEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "propietario_id")
    private Usuario propietario;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoVehiculo estado;
}