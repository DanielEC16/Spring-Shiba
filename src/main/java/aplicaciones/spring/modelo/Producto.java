package aplicaciones.spring.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "Productos")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigo;
	private String titulo;
	private String autor;
	private String reseña;
	@Column(name = "Num_pag")
	private int numeroPaginas;
	private int stock = 0;
	private double precio = 1;
	@Column(name = "Foto_Portada")
	private String fotoPortada;
	@Temporal(TemporalType.DATE)
	@Column(name = "Fecha_Creacion")
	private Date fechaRegistro;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "Producto_Genero", joinColumns = @JoinColumn(name = "Producto_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Genero_ID", referencedColumnName = "id"))
	private List<Genero> generos = new ArrayList<>();

	@PrePersist
	public void prePersist() {
		fechaRegistro = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getReseña() {
		return reseña;
	}

	public void setReseña(String reseña) {
		this.reseña = reseña;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFotoPortada() {
		return fotoPortada;
	}

	public void setFotoPortada(String fotoPortada) {
		this.fotoPortada = fotoPortada;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", reseña="
				+ reseña + ", numeroPaginas=" + numeroPaginas + ", stock=" + stock + ", precio=" + precio
				+ ", fotoPortada=" + fotoPortada + ", fechaRegistro=" + fechaRegistro + ", generos=" + generos + "]";
	}

}
