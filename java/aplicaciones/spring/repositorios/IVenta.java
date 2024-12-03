package aplicaciones.spring.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import aplicaciones.spring.modelo.Venta;

public interface IVenta extends JpaRepository<Venta, Serializable>{

}
