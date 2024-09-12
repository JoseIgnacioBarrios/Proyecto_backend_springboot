package cliente;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class ClienteEjemplo {

	public static void main(String[] args) {
		
		//ruta de la app de un servicio
		String url= "http://localhost:8080/01_ejemplo_rest/pruebas";
		
		WebTarget wt= ClientBuilder
						.newClient() //cliente
						.target(url); //WebTarget
		
		//podemos usar los servicios de la app
		
		//ruta del servicio
		String mensaje1=wt
						.path("/saludar") //webtarget
						.request(MediaType.TEXT_PLAIN) //Builder tiene el metodo de llamada al metodo
						.get(String.class);//String
		
		//mostramos
		System.out.println(mensaje1);
		
		
		//////////////////////////////////
		//nueva llamada a otro metodo del servicio 01_ejemplo_rest
		
		//ruta del servicio
				String mensaje2=wt
								.path("/saludar/Jose") //webtarget
								.request(MediaType.TEXT_PLAIN) //Builder tiene el metodo de llamada al metodo
								.get(String.class);//String
				
				//mostramos
				System.out.println(mensaje2);
		
		//////////////////////////////////
		//nueva llamada a otro metodo del servicio 01_ejemplo_rest
		
		//ruta del servicio
		String mensaje3=wt
						.path("/info") //webtarget
						.queryParam("name", "Jose")
						.queryParam("age", 555)
						.request(MediaType.TEXT_PLAIN) //Builder tiene el metodo de llamada al metodo
						.get(String.class);//String
		
		//mostramos
		System.out.println(mensaje3);
	}

}
