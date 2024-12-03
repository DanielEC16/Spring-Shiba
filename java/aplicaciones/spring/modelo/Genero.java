package aplicaciones.spring.modelo;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="Generos")
public class Genero implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	@ManyToMany(mappedBy = "generos")
	private List<Producto> productos;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	@Override
	public String toString() {
		return "Genero [id=" + id + ", nombre=" + nombre + ", productos=" + productos + "]";
	}
}
