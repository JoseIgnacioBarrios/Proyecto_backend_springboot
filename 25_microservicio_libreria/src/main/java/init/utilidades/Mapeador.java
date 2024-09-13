package init.utilidades;

import org.springframework.stereotype.Component;

import init.model.Book;
import init.model.LibroJson;

@Component
public class Mapeador {
	
	public Book libroJsonToBoock(LibroJson libroJson) {
		int clasificacion= getClasiticacion(libroJson);
		return new Book(libroJson.getTitulo(), libroJson.getTemaJson().getNombreTema(), libroJson.getPrecio(), clasificacion);
		
	}
	
	private int getClasiticacion(LibroJson libroJson) {
		int clasificacion;
		if(libroJson.getPaginas()>0 && libroJson.getPaginas()<=100) {
			clasificacion=1;
		}
		else if (libroJson.getPaginas()>100 && libroJson.getPaginas()<=200) {
			clasificacion=2;
		} 
		else {
			clasificacion=3;
		} 
		return clasificacion;
	}
}
