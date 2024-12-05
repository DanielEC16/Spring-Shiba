package aplicaciones.spring.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="Ventas")
public class Venta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "Cliente_ID")
	private Cliente cliente;
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_Venta")
	private Date fechaVenta;
	private double total;
	private String estado;
	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetalleVenta> detalles = new ArrayList<>();
	
	@PrePersist
	public void prePersist() {
		if (this.fechaVenta== null) {
	        this.fechaVenta = new Date(); // Asigna la fecha de creación solo si está vacía
	    }
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<DetalleVenta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVenta> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", cliente=" + cliente + ", fechaVenta=" + fechaVenta + ", total=" + total
				+ ", estado=" + estado + ", detalles=" + detalles + "]";
	}
	
}
