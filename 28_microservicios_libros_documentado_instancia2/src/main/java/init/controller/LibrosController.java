package init.controller;

import org.springframework.web.bind.annotation.RestController;

import init.model.LibroDto;
import init.service.LibrosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@Tag(name = "Servicio Libros Jose")
public class LibrosController {
	
	//inyecta el identificador de la instancia
	@Value(value = "${eureka.instance.instance-id}")
	String instancia;
	
	LibrosService libroService;
	
	
	public LibrosController(LibrosService libroService) {
		super();
		this.libroService = libroService;
	}

	@Operation(summary = "Busqueda de libros por temario",description = "devuelve todos los libros perteneciente a la tematica que se pide como variable")
	@GetMapping(value="buscarPorTema/{tema}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LibroDto> buscarPorTema(@Parameter(description = "Tematica de busqueda") @PathVariable String tema) {
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
	//etiquetas que sirven como separador de metodos 
	@Tag(name = "metodo catalogo")
	//anotacion @Operation para la documentacion
	@Operation(summary = "catalogo de libros",description = "devuelve la lista de libros")
	@GetMapping(value="catalogo",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LibroDto> buscarTodos() {
		System.out.println("Instancia: "+instancia);
		return libroService.recupearTodos();
	}
	

}
