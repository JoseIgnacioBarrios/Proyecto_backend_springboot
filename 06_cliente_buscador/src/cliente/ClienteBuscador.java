package cliente;

import java.util.Scanner;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;
import model.Respuesta;

public class ClienteBuscador {

	public static void main(String[] args) {
		String url= "http://localhost:8080/03_prototipo_buscador/buscador";
		
//		Scanner sc= new Scanner(System.in);
//		System.out.println("Introduce la tematica de busqueda");
//		String tematica=sc.nextLine();
		
		WebTarget wt= ClientBuilder
						.newClient() //cliente
						.target(url); //WebTarget
		
		
		//ruta del servicio
//			Respuesta[] datos=wt
//							.path("/busqueda") //webtarget
//							.queryParam("tematica",tematica)
//							.request(MediaType.APPLICATION_JSON) //Builder tiene el metodo de llamada al metodo
//							.get(Respuesta[].class );//objeto
//			
//			
//			for(Respuesta r:datos) {
//				//mostramos
//				System.out.println(r.getUrl());
//			}
			
		
		Respuesta res= new Respuesta();
		Scanner sc2= new Scanner(System.in);
		System.out.println("Introduce URL");
		res.setUrl(sc2.nextLine());
		System.out.println("Introduce tematica");
		res.setTematica(sc2.nextLine());
		System.out.println("Introduce descripcion");
		res.setDes(sc2.nextLine());
		
		
//		Form form = new Form();
//		form.param("url", res.getUrl());
//		form.param("tematica", res.getTematica());
//		form.param("des", res.getDes());
		
		
		//ruta de servico
			wt
				.path("/alta") //webtarget
				.request(MediaType.APPLICATION_FORM_URLENCODED_TYPE) //Builder tiene el metodo de llamada al metodo
				.post(Entity.entity(res,MediaType.APPLICATION_JSON ));
		System.out.println("ALTA");
		
		
	
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce la tematica de busqueda");
		String tematica=sc.nextLine();
		
		//ruta del servicio
		Respuesta[] datos=wt
						.path("/busqueda") //webtarget
						.queryParam("tematica",tematica)
						.request(MediaType.APPLICATION_JSON) //Builder tiene el metodo de llamada al metodo
						.get(Respuesta[].class );//objeto
		
		
		for(Respuesta r:datos) {
			//mostramos
			System.out.println(r.getUrl());
		}
	}

}
