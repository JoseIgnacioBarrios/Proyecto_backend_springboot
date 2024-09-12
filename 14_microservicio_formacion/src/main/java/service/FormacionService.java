package service;

import java.util.List;

import model.Formacion;

public interface FormacionService {
	
	List<Formacion> buscarPorArea(String area);
	
	void altaformacion(Formacion formacion);
}
