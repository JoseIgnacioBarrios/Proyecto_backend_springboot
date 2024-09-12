package service;

import java.util.ArrayList;
import java.util.List;

import model.Curso;



public class ServiceCurso {
	
	//static List<Curso> cursosList=new ArrayList<>(List.of());
	private static List<Curso> cursosList=new ArrayList<>(List.of(new Curso("Java 21","Programación",100,200),
			new Curso("Inglés","Idiomas",200,340),
			new Curso("Francés","Idiomas",150,320),
			new Curso("Python","Programación",60,110)
			)); 
	
	public boolean alta(Curso curso) {
		if (buscar(curso.getNombre()) == null) {
			cursosList.add(curso);
			return true;
		}
		return false;
		
	}
	
	public void baja(String nombre) {
		cursosList.removeIf(r->r.getNombre().equals(nombre));
	}
	
	public void actualizar(Curso curso) {
		Curso updateCurso = buscar(curso.getNombre());
		if (updateCurso != null) {
			updateCurso.setArea(curso.getArea());
			updateCurso.setDuracion(curso.getDuracion());
			updateCurso.setPrecio(curso.getPrecio());
		}	
	}
	
	public Curso buscar(String nombre){
		return cursosList.stream().filter(r->r.getNombre().equals(nombre)).findFirst().orElse(null);
	}
	
	public List<Curso> listaCursos(){
		return cursosList;
	}
	
	
}
