package acceso.icfe.DTO.vehiculo;


import acceso.icfe.utils.EstadoVehiculo;

public record VehiculoRequestDTO(
        Long propietarioId,
        String tipo,
        String marca,
        String color,
        String placa,
        EstadoVehiculo estado
) {}
