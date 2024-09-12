package init.service;

import java.util.List;

import init.model.LibroDto;

public interface LibrosService {

	LibroDto buscarLibroPorIsbn(int isbn);
	List<LibroDto> buscarLibrosPorTema(String tema);
	boolean altaLibro(LibroDto libroDto);
}
