package init.service;

import java.util.List;

import init.model.HotelDto;

public interface HotelService {
	
	HotelDto buscarPorId(int idHotel);
	
	List<HotelDto> buscarPorLocalizacion(String localizacion);
}
