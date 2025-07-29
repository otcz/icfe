package acceso.icfe.DTO.vehiculo;

public record VehiculoResponseDTO(
        Long id,
        String tipo,
        String marca,
        String estado,
        String color,
        String placa,
        String nombrePropietario
) {
}