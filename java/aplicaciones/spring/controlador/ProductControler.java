package aplicaciones.spring.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aplicaciones.spring.modelo.Producto;
import aplicaciones.spring.servicios.ProductoService;

@Controller
@RequestMapping("admin/productos")
public class ProductControler {
	@Autowired
	ProductoService productoService;
	
	@GetMapping
	public String listarProductos(Model model) {
		List<Producto> productos = productoService.listar();
		model.addAttribute("productos",productos);
		model.addAttribute("activeSection", "products");
		return "administrador/mantenimiento";
	}
}
