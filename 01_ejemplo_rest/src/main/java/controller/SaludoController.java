package controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/pruebas")
public class SaludoController {
	
	@GET //metodo con peticiones GET
	@Path("/saludar")
	@Produces(MediaType.TEXT_PLAIN)
	public String getSaludo() {
		return "bienvenido a mi servicio rest";
	}
	
	//valores por la url de entrada
	@GET
	@Path("/saludar/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getSaludoPersonal(@PathParam("name") String nombre) {
		return "Bienvnido a mi servicio rest sr./a. "+nombre;
	}
	
	// pasar datos por anotacion
	@GET
	@Path("/info")
	@Produces(MediaType.TEXT_PLAIN)
	public String getInfo(@QueryParam("name") String nombre ,@QueryParam("age") int edad) {
		return "te llamas "+nombre +" y tienes "+edad+" años";		
	}
}
