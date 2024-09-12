package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Pais;
import service.PaisesService;

@CrossOrigin("*")
@RestController
public class PaisesController {

	PaisesService paieseService;
	
	
	public PaisesController(PaisesService paieseService) {
		super();
		this.paieseService = paieseService;
	}


	@GetMapping(value="listaContinentes", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<String>> listaContinentes() {
		try {
			List<String> continentes= paieseService.listcontinentes();
			return new ResponseEntity<>(continentes,HttpStatus.OK);
		}catch (RuntimeException ex) {
			return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);
		}
		 
	}
	
	@GetMapping(value="paisesPorContinente/{continente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<List<Pais>> paisesPorContinente(@PathVariable("continente") String continente){
		try {
			List<Pais> paises=paieseService.listPaises(continente);
			return new ResponseEntity<>(paises,HttpStatus.OK);
		}catch (RuntimeException e) {
			return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
		}
		
	}
	
}
