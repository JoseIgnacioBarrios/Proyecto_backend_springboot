package service;

import java.util.List;

import model.Pais;

public interface PaisesService {
	
	List<String> listcontinentes();
	
	List<Pais> listPaises(String continente);
}
