package aplicaciones.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.modelo.Genero;
import aplicaciones.spring.repositorios.IGenero;

@Service("genero")
public class GeneroService {
	@Autowired
	private IGenero iGenero;
	
	public List<Genero> listar(){
		return iGenero.findAll();
	}
	
	public void guardar(Genero genero) {
		iGenero.save(genero);
	}
	
	public Genero obtenerPorId(Long id) {
		return iGenero.findById(id).orElse(null);
	}
	
	public void eliminar(Long id) {
		iGenero.deleteById(id);
	}
}
