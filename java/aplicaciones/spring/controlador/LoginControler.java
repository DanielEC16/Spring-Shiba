package aplicaciones.spring.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControler {
	@GetMapping("/login")
    public String login() {
        // Regresa la vista de login
        return "administrador/login";  
    }
}
