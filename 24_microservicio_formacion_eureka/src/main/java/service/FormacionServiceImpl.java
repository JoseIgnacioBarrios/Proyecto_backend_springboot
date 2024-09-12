package service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {
	
	//direccion base
	//String url= "http://localhost:8000/cursos/";
	String url= "http://servicio-cursos/cursos/";
	RestClient restClient;
	
	public FormacionServiceImpl(RestClient restClient) {
		this.restClient=restClient;
	}
	
	@Override
	public List<Formacion> buscarPorArea(String area) {
		return Arrays.stream(restClient
					.get()
					.uri(url+"recuperarTodos")
					//.uri(url+"buscar/"+area)
					.retrieve()
					.body(Formacion[].class)//recuperamos la respuesta de valor Formacion[]
					)//stream
					.filter(f->f.getArea().equals(area))
					.toList();
	}

	@Override
	public void altaformacion(Formacion formacion) {
		restClient
			.post()
			.uri(url+"alta")
			.contentType(MediaType.APPLICATION_JSON)//el valorJ sera transformado en json
			.body(formacion)//enviamos la peticion de este valorJ 
			.retrieve()//retrieve ejecuta la configuracion que hicimos con post, uri, contentType
			.toBodilessEntity();// si no hay respuesta mostrar el error
			
	}

}
