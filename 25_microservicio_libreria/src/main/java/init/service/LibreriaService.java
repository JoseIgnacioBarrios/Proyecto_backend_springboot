package init.service;

import java.util.List;

import init.model.Book;

public interface LibreriaService {
	
	List<Book> librosPorRangoPrecio(double x, double y);

}
