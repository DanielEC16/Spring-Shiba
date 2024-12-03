package aplicaciones.spring.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import aplicaciones.spring.modelo.Rol;

public interface IRol extends JpaRepository<Rol, Serializable>{

}
