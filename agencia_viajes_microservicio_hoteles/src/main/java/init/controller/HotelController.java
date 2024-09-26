package init.controller;

import org.springframework.web.bind.annotation.RestController;

import init.model.HotelDto;
import init.service.HotelService;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class HotelController {
	
	HotelService hotelService;
	
	public HotelController(HotelService hotelService) {
		super();
		this.hotelService = hotelService;
	}

	@GetMapping(value="buscarPorId/{idHotel}",produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelDto buscarPorId(@PathVariable("idHotel")int idHotel) {
		return hotelService.buscarPorId(idHotel);
	}
	
	@GetMapping(value="buscarPorUbi/{localizacion}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<HotelDto> getMethodName(@PathVariable("localizacion") String localizacion) {
		return hotelService.buscarPorLocalizacion(localizacion);
	}
	
	

}
