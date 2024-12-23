package aplicaciones.spring.controlador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import aplicaciones.spring.modelo.Administrador;
import aplicaciones.spring.modelo.Cliente;
import aplicaciones.spring.modelo.Rol;
import aplicaciones.spring.servicios.AdministradorService;
import aplicaciones.spring.servicios.ClienteService;
import aplicaciones.spring.servicios.RolService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/admin/usuarios")
public class UsersControler {

	@Autowired
	ClienteService clienteService;
	@Autowired
	AdministradorService administradorService;
	@Autowired
	RolService rolService;

	@GetMapping
	public String listarUsuarios(Model model) {
		List<Cliente> clientes = clienteService.listar();
		List<Administrador> administrador = administradorService.listar();
		List<Rol> rol = rolService.listar();
		model.addAttribute("clientes", clientes);
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("administradores", administrador);
		model.addAttribute("administrador", new Administrador());
		model.addAttribute("roles", rol);
		model.addAttribute("activeSection", "users");
		return "administrador/mantenimiento";
	}

	@PostMapping("/save")
	public String guardarCli(@RequestParam("picture__input") MultipartFile imagen,
			@ModelAttribute Cliente cliente) {
		if (cliente.getFechaRegistro() == null) {
	        cliente.setFechaRegistro(new Date());  
	    }
		if (!imagen.isEmpty()) {
			Path directorioImagenes = Paths.get("src//main//resources//static/img/baseDatos/clientes");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);

				cliente.setFoto(imagen.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		clienteService.guardar(cliente);
		System.out.println("Cliente Guardado");
		return "redirect:/admin/usuarios";
	}

	@PostMapping("/saveAdm")
	public String guardarAdm(@RequestParam("picture__input") MultipartFile imagen,
			@RequestParam("rolAdmin") Long rolSeleccionado,
			@ModelAttribute Administrador admin) {
		if (!imagen.isEmpty()) {
			Path directorioImagenes = Paths.get("src//main//resources//static/img/baseDatos/admins");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);

				admin.setFoto(imagen.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    System.out.println("Rol seleccionado: " + rolSeleccionado);
		Rol rol = rolService.obtenerPorId(rolSeleccionado);
	    admin.setRol(rol);
		administradorService.guardar(admin);
		System.out.println("Administrador Guardado");
		return "redirect:/admin/usuarios";
	}
	
	@GetMapping("edit/{id}")
	public String editarCli(@PathVariable("id") Long idCliente ,Model model) {
		Cliente cliente = clienteService.obtenerPorId(idCliente);
		model.addAttribute("cliente",cliente);
		return "administrador/editCliente";
	}
	
	@GetMapping("editadm/{id}")
	public String editarAdm(@PathVariable("id") Long idAdmin ,Model model) {
		Administrador admin = administradorService.obtenerPorId(idAdmin);
		List<Rol> rol = rolService.listar();
		model.addAttribute("administrador",admin);
		model.addAttribute("roles", rol);
		return "administrador/editAdmin";
	}
	
	@GetMapping("delete/{id}")
	public String eliminarCli(@PathVariable("id") Long idCliente) {
		clienteService.eliminar(idCliente);
		return "redirect:/admin/usuarios";
	}
	@GetMapping("deleteadm/{id}")
	public String eliminarAdm(@PathVariable("id") Long idAdmin) {
		administradorService.eliminar(idAdmin);
		return "redirect:/admin/usuarios";
	}

}
