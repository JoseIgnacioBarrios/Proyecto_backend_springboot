package controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Curso;
import service.ServiceCurso;

@Path("/curso")
public class CursoController {
	
	ServiceCurso serviceCurso= new ServiceCurso();
	
	@POST
	@Path("/alta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String alta(Curso curso) {
		//serviceCurso.alta(curso);
		//si quisieramos enviar un boolean en texto para que imprima si tod fue correcto
		return String.valueOf(serviceCurso.alta(curso));
	}
	
	@DELETE
	@Path("/baja/{nombre}")
	public void baja(@PathParam("nombre") String nombre) {
		serviceCurso.baja(nombre);
	}
	
	@PUT
	@Path("/actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar(Curso curso) {
		serviceCurso.actualizar(curso);
	}
	
	@GET
	@Path("/buscar/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public Curso buscarPorNombre(@PathParam("nombre")String nombre) {
		return serviceCurso.buscar(nombre);
	}
	
	
	@GET
	@Path("/listado")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Curso> recuperarTodos(){
		return serviceCurso.listaCursos();
	}

}
