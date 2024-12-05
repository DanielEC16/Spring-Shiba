package aplicaciones.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.modelo.Genero;
import aplicaciones.spring.repositorios.IGenero;

@Service("genero")
public class GeneroService {
	@Autowired
	IGenero iGenero;
	
	public List<Genero> listar(){
		return iGenero.findAll();
	}
	
	public void guardar(Genero genero) {
		iGenero.save(genero);
	}
	
	public Genero obtenerPorId(Long genero) {
		return iGenero.findById(genero).orElse(null);
	}
	
	public List<Genero> obtenerGenerosPorId(List<Long> ids){
		return iGenero.findAllById(ids);
	}
	
	public void eliminar(Long id) {
		iGenero.deleteById(id);
	}
}
