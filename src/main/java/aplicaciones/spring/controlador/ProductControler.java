package aplicaciones.spring.controlador;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import aplicaciones.spring.modelo.Genero;
import aplicaciones.spring.modelo.Producto;
import aplicaciones.spring.servicios.GeneroService;
import aplicaciones.spring.servicios.ProductoService;

@Controller
@RequestMapping("admin/productos")
public class ProductControler {
	@Autowired
	ProductoService productoService;
	@Autowired
	GeneroService geneService;
	
	@GetMapping
	public String listarProductos(Model model) {
		List<Producto> productos = productoService.listar();
		List<Genero> generos = geneService.listar();
		int totalProductos = productos.size();
		model.addAttribute("productos",productos);
		model.addAttribute("producto",new Producto());
		model.addAttribute("generos",generos);
		model.addAttribute("totalProductos",totalProductos);
		model.addAttribute("activeSection", "products");
		return "administrador/mantenimiento";
	}
	
	@PostMapping("/save")
	public String guardarProd(@RequestParam("picture__input") MultipartFile imagen,
			@ModelAttribute Producto producto,
			@RequestParam(value = "generos") List<Long> generos) {
		if (producto.getFechaRegistro()==null) {
			producto.setFechaRegistro(new Date());
		}
		if (!imagen.isEmpty()) {
			Path directorioImagenes = Paths.get("src//main//resources//static/img/baseDatos/products");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				producto.setFotoPortada(imagen.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (generos != null && !generos.isEmpty()) {
            List<Genero> listaGeneros = geneService.obtenerGenerosPorId(generos);
            producto.setGeneros(listaGeneros);
        }
	    
		productoService.guardar(producto);
		System.out.println("Producto Guardado");
		return "redirect:/admin/productos";
	}
	

}
