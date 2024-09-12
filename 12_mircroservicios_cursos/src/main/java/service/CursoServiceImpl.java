package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Curso;


@Service
public class CursoServiceImpl implements CursoService  {
	
	//static List<Curso> cursosList=new ArrayList<>(List.of());
	private static List<Curso> cursosList=new ArrayList<>(List.of(new Curso("Java 21","Programación",100,200),
			new Curso("Inglés","Idiomas",200,340),
			new Curso("Francés","Idiomas",150,320),
			new Curso("Python","Programación",60,110)
			)); 
	
	@Override
	public boolean alta(Curso curso) {
		if (buscarCurso(curso.getNombre()) == null) {
			cursosList.add(curso);
			return true;
		}
		return false;
		
	}
	
	@Override
	public void eliminar(String nombre) {
		cursosList.removeIf(r->r.getNombre().equals(nombre));
	}
	
	@Override
	public void modificarDatos(Curso curso) {
		Curso updateCurso = buscarCurso(curso.getNombre());
		if (updateCurso != null) {
			updateCurso.setArea(curso.getArea());
			updateCurso.setDuracion(curso.getDuracion());
			updateCurso.setPrecio(curso.getPrecio());
		}	
	}
	
	@Override
	public Curso buscarCurso(String nombre){
		return cursosList.stream().filter(r->r.getNombre().equals(nombre)).findFirst().orElse(null);
	}
	
	@Override
	public List<Curso> devolverCursos(){
		return cursosList;
	}
	
	
}
