package aplicaciones.spring.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import aplicaciones.spring.modelo.Administrador;



public interface IAdministrador extends JpaRepository<Administrador, Serializable>{
	public Administrador findByNombre(String nombre);
	public Administrador findByCorreo(String correo);
}
