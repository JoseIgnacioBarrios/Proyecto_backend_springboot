package controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import model.Curso;
import service.CursoService;

@RestController
public class CursoController {
	
	CursoService cursoService;

	public CursoController(CursoService cursoService) {
		super();
		this.cursoService = cursoService;
	}
	//administrador
	@PostMapping(value="alta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String alta(@RequestBody Curso curso) {
		//serviceCurso.alta(curso);
		//si quisieramos enviar un boolean en texto para que imprima si tod fue correcto
		return String.valueOf(cursoService.alta(curso));
	}
	//rol
	@DeleteMapping(value="eliminar/{nombre}")
	public void eliminar(@PathVariable ("nombre") String nombre) {
		cursoService.eliminar(nombre);
	}
	//rol
	@PutMapping(value="actualizar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Curso curso) {
		cursoService.modificarDatos(curso);
	}
	//tiene que estar autenticado
	@GetMapping(value="buscar/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarPorNombre(@PathVariable("nombre") String nombre) {
		return cursoService.buscarCurso(nombre);
	}
	//tendra acceso libre
	@GetMapping(value="recuperarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> recuperarTodos(){
		return cursoService.devolverCursos();
	}
	

}
