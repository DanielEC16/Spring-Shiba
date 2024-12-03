package aplicaciones.spring.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import aplicaciones.spring.modelo.Producto;

public interface IProducto extends JpaRepository<Producto, Serializable>{

}
