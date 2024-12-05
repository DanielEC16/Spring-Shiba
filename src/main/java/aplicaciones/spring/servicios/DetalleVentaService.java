package aplicaciones.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.modelo.DetalleVenta;
import aplicaciones.spring.repositorios.IDetalleVenta;

@Service("detalleventa")
public class DetalleVentaService {
	@Autowired
	IDetalleVenta iDetalleventa;

	public List<DetalleVenta> listar() {
		return iDetalleventa.findAll();
	}

	public void guardar(DetalleVenta detalle) {
		iDetalleventa.save(detalle);
	}

	public DetalleVenta obtenerPorId(Long id) {
		return iDetalleventa.findById(id).orElse(null);
	}

	public void eliminar(Long id) {
		iDetalleventa.deleteById(id);
	}
	
	public List<DetalleVenta> obtenerDetallesPorVentaId(Long ventaId) {
        return iDetalleventa.findByVentaId(ventaId);
    }
	
}
