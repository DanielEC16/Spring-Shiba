package aplicaciones.spring.repositorios;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import aplicaciones.spring.modelo.DetalleVenta;

public interface IDetalleVenta extends JpaRepository<DetalleVenta, Serializable>{
	List<DetalleVenta> findByVentaId(Long ventaId);
}
