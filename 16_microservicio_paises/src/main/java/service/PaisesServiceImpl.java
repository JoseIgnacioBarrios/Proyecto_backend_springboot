package service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import model.Pais;

@Service
public class PaisesServiceImpl implements PaisesService {
	
	String url="https://restcountries.com/v2/all";
	RestClient restClient;
	
	public PaisesServiceImpl(RestClient restClient) {
		super();
		this.restClient = restClient;
	}

	@Override
	public List<String> listcontinentes() {
		
		try { return  Arrays.stream(
					restClient
						.get()
						.uri(url)
						.retrieve()
						.body(Pais[].class)
						)
						.map(f->f.getContinente()).distinct().toList();
		
		}catch (HttpClientErrorException e) {
			throw new RuntimeException();
		}
		 
		
		
	}

	@Override
	public List<Pais> listPaises(String continente) {
		try {
		return  Arrays.stream(
			restClient
				.get()
				.uri(url)
				.retrieve()
				.body(Pais[].class)
				)
		 	.filter(f->f.getContinente().equals(continente)).toList();
		}catch  (HttpClientErrorException e) {
			throw new RuntimeException();
		}
			
	}

}
