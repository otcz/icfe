package acceso.icfe.DTO.registro_acceso;

import java.time.LocalDateTime;

public record RegistroAccesoDTO(
        Long id,
        Long usuarioId,
        Long vehiculoId,
        String tipoMovimiento
) {}
