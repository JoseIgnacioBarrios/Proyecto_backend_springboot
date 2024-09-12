package init.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import init.dao.LibrosDao;
import init.entities.Libro;
import init.model.LibroDto;
import init.utilidades.Mapeador;
@Service
public class LibrosServiceImpl implements LibrosService {
	
	LibrosDao librosDao;
	Mapeador mapeador;
	
	
	public LibrosServiceImpl(LibrosDao librosDao, Mapeador mapeador) {
		this.librosDao = librosDao;
		this.mapeador = mapeador;
	}
	
	@Override
	public LibroDto buscarLibroPorIsbn(int isbn) {
		Optional<Libro> opLibro=librosDao.findById(isbn);
		return mapeador.libroEntityToDto(opLibro.isPresent()?opLibro.get():new Libro());
	}

	@Override
	public List<LibroDto> buscarLibrosPorTema(String tema) {
		return librosDao.findByNombreTema(tema)
					.stream()
					.map(f->mapeador.libroEntityToDto(f))
					.toList();
	}

	@Override
	public boolean altaLibro(LibroDto libroDto) {
		if(librosDao.findById(libroDto.getIsbn()).isEmpty()) {
			librosDao.save(mapeador.libroDtoToEntity(libroDto));
			return true;
		}
		return false;
	}

	


	
	
}
