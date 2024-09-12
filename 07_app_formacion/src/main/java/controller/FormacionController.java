package controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Respuesta;
import service.FormacionService;

@Path("/formacion")
public class FormacionController {

	FormacionService formacionService = new FormacionService();
	@GET
	@Path("/buscaporarea/{area}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> buscarporArea(@PathParam("area")String area){
		return formacionService.listaCurso(area);
	}
	
	@POST
	@Path("/alta")
	@Consumes(MediaType.APPLICATION_JSON)
	public void altaFormacion(Respuesta respuesta) {
		formacionService.altaFormacion(respuesta);
	}
}
