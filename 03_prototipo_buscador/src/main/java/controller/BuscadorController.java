package controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import model.Resultado;
import services.Busqueda;


@Path("/buscador")
public class BuscadorController {
	
	Busqueda busquedaServ = new Busqueda();
	
	@GET
	@Path("/busqueda")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resultado> buscar(@QueryParam("tematica") String tematica) {
		return busquedaServ.encontrado(tematica);
	}
	
	@POST
	@Path("/alta")
	@Consumes(MediaType.APPLICATION_JSON)
	public void alta( Resultado resultado) {
		busquedaServ.alta(resultado);
	}
	
	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resultado> eliminar(@FormParam("url") String url){
		return busquedaServ.eliminar(url);
	}
	
	
}
