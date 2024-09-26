package init.utilidades;

import org.springframework.stereotype.Component;

import init.entities.Hotel;
import init.model.HotelDto;

@Component
public class Mapeador {

	public HotelDto hotelentityToDto(Hotel hotel) {
		return new HotelDto(hotel.getNombre(),
							hotel.getCategoria(),
							hotel.getPrecio(),
							hotel.getDisponible(),
							hotel.getLocalizacion());
	}
	

}
