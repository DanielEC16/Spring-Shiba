package aplicaciones.spring.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import aplicaciones.spring.modelo.Cliente;

public interface ICliente extends JpaRepository<Cliente, Serializable>{

}
