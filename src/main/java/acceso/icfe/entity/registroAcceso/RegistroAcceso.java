package acceso.icfe.entity.registroAcceso;

import acceso.icfe.entity.usuario.Usuario;
import acceso.icfe.entity.vehiculo.Vehiculo;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "registro_acceso")
public class RegistroAcceso {
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
    private String tipoMovimiento; // Entrada o Salida

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;
}
