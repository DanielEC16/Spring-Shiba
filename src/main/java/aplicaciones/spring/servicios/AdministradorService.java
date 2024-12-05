package aplicaciones.spring.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aplicaciones.spring.modelo.Administrador;
import aplicaciones.spring.repositorios.IAdministrador;

@Service("administrador")
public class AdministradorService {
	@Autowired
	IAdministrador iAdministrador;

	public List<Administrador> listar() {
		return iAdministrador.findAll();
	}

	public void guardar(Administrador administrador) {
		iAdministrador.save(administrador);
	}

	public Administrador obtenerPorId(Long id) {
		return iAdministrador.findById(id).orElse(null);
	}

	public void eliminar(Long id) {
		iAdministrador.deleteById(id);
	}
	
	public Administrador buscarPorNombre(String nombre) {
        return iAdministrador.findByNombre(nombre);
    }

    public Administrador buscarPorCorreo(String correo) {
        return iAdministrador.findByCorreo(correo);
    }
    

}
