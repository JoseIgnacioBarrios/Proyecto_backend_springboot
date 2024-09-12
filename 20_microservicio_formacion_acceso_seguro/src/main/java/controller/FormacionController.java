package controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Formacion;
import service.FormacionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("*")
@RestController
public class FormacionController {
	FormacionService formacionService;

	public FormacionController(FormacionService formacionService) {
		super();
		this.formacionService = formacionService;
	}
	
	
	@GetMapping(value="consultaArea/{area}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> consultarPorArea(@PathVariable String area){
		return formacionService.buscarPorArea(area);
	}
	
	@PostMapping(value="altaformacion", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaFormacion(@RequestBody Formacion formacion) {
		formacionService.altaformacion(formacion);
	}
	

}
