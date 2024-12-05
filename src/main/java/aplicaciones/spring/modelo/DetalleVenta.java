package aplicaciones.spring.modelo;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "Detalleventas")
public class DetalleVenta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "Venta_ID", referencedColumnName = "ID", nullable = false)
	private Venta venta;

	@ManyToOne
	@JoinColumn(name = "Producto_ID", referencedColumnName = "ID", nullable = false)
	private Producto producto;

	private int cantidad;
	private double precioUnitario;
	@Column(name = "Subtotal", insertable = false, updatable = false)
	private double subtotal;
	
	@Transient // Campo temporal, no se guarda en la base de datos
    private boolean incluir;
	
	
	public boolean isIncluir() {
		return incluir;
	}
	public void setIncluir(boolean incluir) {
		this.incluir = incluir;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	@Override
	public String toString() {
		return "DetalleVenta [id=" + id + ", venta=" + venta + ", producto=" + producto + ", cantidad=" + cantidad
				+ ", precioUnitario=" + precioUnitario + ", subtotal=" + subtotal + "]";
	}
}
