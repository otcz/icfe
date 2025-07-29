package acceso.icfe.service.vehiculo;

import acceso.icfe.DTO.vehiculo.VehiculoRequestDTO;
import acceso.icfe.DTO.vehiculo.VehiculoResponseDTO;
import acceso.icfe.entity.usuario.Usuario;
import acceso.icfe.entity.vehiculo.Vehiculo;
import acceso.icfe.repository.usuario.UsuarioRepository;
import acceso.icfe.repository.vehiculo.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public VehiculoResponseDTO registrarVehiculo(VehiculoRequestDTO dto) {
        Usuario propietario = usuarioRepository.findById(dto.propietarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPropietario(propietario);
        vehiculo.setTipo(dto.tipo());
        vehiculo.setMarca(dto.marca());
        vehiculo.setEstado(dto.estado());

        Vehiculo vehiculoSave= vehiculoRepository.save(vehiculo);
        return new VehiculoResponseDTO(
                vehiculoSave.getId(),
                vehiculoSave.getTipo(),
                vehiculoSave.getMarca(),
                vehiculoSave.getEstado().name(),
                propietario.getNombres() + " " + propietario.getApellidos()
        );
    }

    @Override
    public VehiculoResponseDTO findVehiculoByPropietario(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findByPropietarioId(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado para el usuario con ID: " + id));

        String nombrePropietario = vehiculo.getPropietario().getNombres() + " " + vehiculo.getPropietario().getApellidos();

        return new VehiculoResponseDTO(
                vehiculo.getId(),
                vehiculo.getTipo(),
                vehiculo.getMarca(),
                vehiculo.getEstado().name(),
                nombrePropietario
        );
    }



}
