package aplicaciones.spring.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import aplicaciones.spring.modelo.DetalleVenta;
import aplicaciones.spring.modelo.Venta;
import aplicaciones.spring.servicios.DetalleVentaService;
import aplicaciones.spring.servicios.VentaService;

@Controller
@RequestMapping("/admin/ventas")
public class VentasControler {
	@Autowired
	VentaService ventaService;
	@Autowired
	DetalleVentaService detalleService;
	
	@GetMapping
	public String listarVentas(Model model) {
		List<Venta> ventas = ventaService.listar();
		List<DetalleVenta> detalles = detalleService.listar();
		model.addAttribute("ventas",ventas);
		model.addAttribute("detalles",detalles);
		model.addAttribute("activeSection" , "ventas");
		return "administrador/mantenimiento";
	}
	@GetMapping("/ventas/{id}")
	public String verDetallesVenta(@PathVariable Long id, Model model) {
	    // Obtener la venta por ID
	    Venta venta = ventaService.obtenerPorId(id);
	    
	    // Obtener los detalles de la venta
	    List<DetalleVenta> detalles = detalleService.obtenerDetallesPorVentaId(id);
	    
	    model.addAttribute("venta", venta);
	    model.addAttribute("detalles", detalles);
	    
	    return "administrador/modalDetalles";  // Vista del modal con detalles
	}

}
