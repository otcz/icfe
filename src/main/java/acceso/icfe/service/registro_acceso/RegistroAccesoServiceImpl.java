package acceso.icfe.service.registro_acceso;

import acceso.icfe.entity.registro_acceso.RegistroAcceso;
import acceso.icfe.repository.registro_acceso.RegistroAccesoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegistroAccesoServiceImpl implements RegistroAccesoService{

    @Autowired
    private RegistroAccesoRepository registroAccesoRepository;
    @Override
    public RegistroAcceso registroAcceso(RegistroAcceso registroAcceso) {
        return registroAccesoRepository.save(registroAcceso);
    }

    @Override
    public List<RegistroAcceso> listarTodos() {
        return null;
    }


}
