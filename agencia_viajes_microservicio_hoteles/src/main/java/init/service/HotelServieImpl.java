package init.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import init.dao.HotelDao;
import init.entities.Hotel;
import init.model.HotelDto;
import init.utilidades.Mapeador;

@Service
public class HotelServieImpl implements HotelService {

	HotelDao hotelDao;
	Mapeador mapeador;


	public HotelServieImpl(HotelDao hotelDao, Mapeador mapeador) {
		this.hotelDao = hotelDao;
		this.mapeador = mapeador;
	}

	@Override
	public HotelDto buscarPorId(int idHotel) {
		Optional<Hotel> opHotel=hotelDao.findById(idHotel);
		
		return mapeador.hotelentityToDto(opHotel.isPresent()?opHotel.get():new Hotel());
	}

	@Override
	public List<HotelDto> buscarPorLocalizacion(String localizacion) {
		return hotelDao.findByLocalizacion(localizacion)
					.stream()
					.map(h->mapeador.hotelentityToDto(h))
					.toList();
	}

}
