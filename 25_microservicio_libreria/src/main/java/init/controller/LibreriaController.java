package init.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import init.model.Book;
import init.service.LibreriaService;

@CrossOrigin("*")
@RestController
public class LibreriaController {
	
	LibreriaService libreriaService;
	
	
	public LibreriaController(LibreriaService libreriaService) {
		super();
		this.libreriaService = libreriaService;
	}


	@GetMapping(value="boocks/{min}/{max}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> boock(@PathVariable("min")double min,@PathVariable("max")double max) {
		return libreriaService.librosPorRangoPrecio(min, max);
	}
	
	
}
