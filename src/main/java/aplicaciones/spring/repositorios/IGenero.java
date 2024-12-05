package aplicaciones.spring.repositorios;



import org.springframework.data.jpa.repository.JpaRepository;

import aplicaciones.spring.modelo.Genero;

public interface IGenero extends JpaRepository<Genero, Long>{

}
