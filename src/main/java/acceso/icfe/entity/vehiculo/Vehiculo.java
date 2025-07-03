package acceso.icfe.entity.vehiculo;


import acceso.icfe.entity.usuario.Usuario;
import acceso.icfe.utils.EstadoVehiculo;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "propietario_id")
    private Usuario propietario;

    @Column(name = "tipo", nullable = false)
    private String tipo; // Ej: Carro, Moto, Bicicleta

    @Column(name = "marca", nullable = false)
    private String marca;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoVehiculo estado; // ACTIVO, INACTIVO
}