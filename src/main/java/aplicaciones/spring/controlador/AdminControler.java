package aplicaciones.spring.controlador;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminControler {

	@GetMapping("/home")
	public String forwarAdminRoutes(Model model) {
		model.addAttribute("activeSection", "inicio");
		return "administrador/mantenimiento";
	}
}
