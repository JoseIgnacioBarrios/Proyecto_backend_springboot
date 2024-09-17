package service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {
	
	@Value("${usuario}")
	String user;
	@Value("${pwd}")
	String pass;
	
	
	//direccion base
	@Value("${url.cursos}")
	String url;
	//String url= "http://localhost:8000/cursos/";
	RestClient restClient;
	
	public FormacionServiceImpl(RestClient restClient) {
		this.restClient=restClient;
	}
	
	@Override
	public List<Formacion> buscarPorArea(String area) {
		return Arrays.stream(restClient
					.get()
					.uri(url+"recuperarTodos")
					.header("Authorization", "Basic "+getBase64(user,pass))
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
	
	private String getBase64(String us ,String pwd) {
		String cad=us+":"+pwd;
		return Base64.getEncoder().encodeToString(cad.getBytes());
		
	}

}
