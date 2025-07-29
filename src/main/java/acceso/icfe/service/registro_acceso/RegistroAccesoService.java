package acceso.icfe.service.registro_acceso;


import acceso.icfe.entity.registro_acceso.RegistroAcceso;

import java.util.List;

public interface RegistroAccesoService {
    RegistroAcceso registroAcceso(RegistroAcceso registroAcceso);

    List<RegistroAcceso> listarTodos();


}
