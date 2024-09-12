package controller;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Ficha;

@RestController
public class InfoController {
	
	//response body ya no es necesario explicarlo por defecto de devuelve en el responseBody
	@GetMapping(value="info", produces = MediaType.APPLICATION_JSON_VALUE)
	public Ficha info() {
		return new Ficha("pc", 800, "Informatica");
	}
}
