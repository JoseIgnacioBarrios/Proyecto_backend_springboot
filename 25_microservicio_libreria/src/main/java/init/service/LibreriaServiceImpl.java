package init.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import init.model.Book;
import init.model.LibroJson;
import init.utilidades.Mapeador;

@Service
public class LibreriaServiceImpl implements LibreriaService {

	//reemplzamos por que usaremos el serve Eureka 
	//String url="http://localhost:9000/libros";
	String url="http://servicio-libros/libros";
	
	RestClient restClient;
	Mapeador mapeador;
	
	public LibreriaServiceImpl(RestClient resclClient, Mapeador mapeador) {
		this.restClient=resclClient;
		this.mapeador=mapeador;
	}
	
	@Override
	public List<Book> librosPorRangoPrecio(double x, double y) {
		// TODO Auto-generated method stub
		return Arrays.stream(restClient.get()
					.uri(url+"/catalogo")
					.retrieve()
					.body(LibroJson[].class))
					.map(l->mapeador.libroJsonToBoock(l))
					.filter(l->l.getPrecio()>=x && l.getPrecio()<=y)
					.toList();
	}


	

}
