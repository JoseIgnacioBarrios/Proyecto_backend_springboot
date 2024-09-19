package service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import jakarta.annotation.PostConstruct;
import model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {
	
	@Value("${usuario}")
	String user;
	@Value("${pwd_usuario}")
	String pass;
	
	
	//direccion base
//	@Value("${url.servicio.cursos}")
//	String url;
//	
//	@Value("${port.servicio.curso}")
//	String port;
	//String url= "http://localhost:8000/cursos/";
	
	String urlAll;
	
	RestClient restClient;
	
	public FormacionServiceImpl(RestClient restClient) {
		this.restClient=restClient;
		
	}
	//se ejecuta luego del metodo constructor
	@PostConstruct
	public void init() {
		//urlAll="http://"+url+":"+port+"/cursos/";
		//ahora con EUREKA
		urlAll="http://servicio-cursos/cursos/";
	}
	
	@Override
	public List<Formacion> buscarPorArea(String area) {
		
		System.out.println("user: ---"+user);
		System.out.println("pass: ---"+pass);
		
		return Arrays.stream(restClient
					.get()
					.uri(urlAll+"recuperarTodos")
					.header("Authorization", "Basic "+getBase64(user,pass))
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
			.uri(urlAll+"alta")
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
