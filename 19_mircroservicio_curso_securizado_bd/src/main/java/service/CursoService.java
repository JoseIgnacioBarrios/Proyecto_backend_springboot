package service;

import java.util.List;

import model.Curso;

public interface CursoService {

	boolean alta(Curso curso);

	void eliminar(String nombre);

	void modificarDatos(Curso curso);

	Curso buscarCurso(String nombre);

	List<Curso> devolverCursos();

}