package aplicaciones.spring.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/shiba")
public class HomeControler {

	@GetMapping
	public String index() {
		return "user/index";
	}
	
	@GetMapping("/productos")
	public String productos() {
		return "user/productos";
	}
	
	
}
