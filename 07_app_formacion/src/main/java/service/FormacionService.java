package service;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import model.Respuesta;

public class FormacionService {
	String url= "http://localhost:8080/04_servicios_crud_cursos/curso";
	WebTarget wt= ClientBuilder
		.newClient() //cliente
		.target(url); //WebTarget
	public Respuesta[] listaRecursos(){
		
		
			
			
			Respuesta[] datos =wt
								.path("listado")
								.request(MediaType.APPLICATION_JSON)
			.get(Respuesta[].class);
			
			
		
		return datos;
	}
	
	public List<String> listaCurso(String area){
		List<String> cursos=new ArrayList<>();
		Respuesta[] datos = listaRecursos();
		
		for(Respuesta res: datos) {
			if (res.getArea().equals(area)) {
				cursos.add(res.getNombre());
			}
		}
		
		return cursos;
	}
	
	public void altaFormacion(Respuesta formacion) {
		String resp=(String)wt
								.path("/alta")
								.request(MediaType.TEXT_PLAIN)
								.post(Entity.entity(formacion, MediaType.APPLICATION_JSON)) //Response
								.getEntity();
		//no usamos el String devuelto por el servicio de cursos
		
	}

}
