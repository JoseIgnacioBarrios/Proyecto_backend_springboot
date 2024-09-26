package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.entities.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Integer> {
	
	@Query("select l from hoteles l where l.localizacion=?1")
	List<Hotel> findByLocalizacion(String localizacion);
}
