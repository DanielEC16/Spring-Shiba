package aplicaciones.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.modelo.Venta;
import aplicaciones.spring.repositorios.IVenta;
@Service("venta")
public class VentaService {
	@Autowired
	IVenta iVenta;

	public List<Venta> listar(){
		return iVenta.findAll();
	}
	
	public void guardar(Venta venta) {
		iVenta.save(venta);
	}
	
	public Venta obtenerPorId(Long id) {
		return iVenta.findById(id).orElse(null);
	}
	
	public void eliminar(Long id) {
		iVenta.deleteById(id);
	}
}
