package aplicaciones.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.modelo.Cliente;
import aplicaciones.spring.repositorios.ICliente;

@Service("cliente")
public class ClienteService {
	@Autowired
	private ICliente iCliente;

	public List<Cliente> listar() {
		return iCliente.findAll();
	}

	public void guardar(Cliente cliente) {
		iCliente.save(cliente);
	}

	public Cliente obtenerPorId(Long id) {
		return iCliente.findById(id).orElse(null);
	}

	public void eliminar(Long id) {
		iCliente.deleteById(id);
	}

}
