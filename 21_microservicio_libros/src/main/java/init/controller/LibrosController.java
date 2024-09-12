package init.controller;

import org.springframework.web.bind.annotation.RestController;

import init.model.LibroDto;
import init.service.LibrosService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class LibrosController {
	
	LibrosService libroService;
	
	
	public LibrosController(LibrosService libroService) {
		super();
		this.libroService = libroService;
	}

	@GetMapping(value="buscarPorTema/{tema}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LibroDto> buscarPorTema(@PathVariable String tema) {
		 return libroService.buscarLibrosPorTema(tema);
	}
	
	@PostMapping(value="alta", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> alta(@RequestBody LibroDto libroDto){
		if(libroService.altaLibro(libroDto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping(value="buscarPorIsbn/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibroDto> buscarPorIsbn(@PathVariable("isbn") int isbn){
		LibroDto libro= libroService.buscarLibroPorIsbn(isbn);
		if(libro!= null) {
			return new ResponseEntity<>(libro,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.CONFLICT);
	}

}
