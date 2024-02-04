package com.service.hotel.Service;

import com.service.hotel.DTO.Converter.Hotel2DTOConverter;
import com.service.hotel.DTO.HotelDTO;
import com.service.hotel.DTO.HotelRequestDTO;
import com.service.hotel.Entity.Hotel;
import com.service.hotel.Exceptions.NotFoundException;
import com.service.hotel.Repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    private final Hotel2DTOConverter hotel2DTOConverter;

    @Transactional(readOnly = true)
    public List<HotelDTO> getAllHotels() {
        return hotelRepository.findAll().stream().map(hotel2DTOConverter::convert).toList();
    }

    @Transactional(readOnly = true)
    public HotelDTO getOne(final Long id) {
        return hotelRepository.findById(id).map(hotel2DTOConverter::convert).orElseThrow(() -> new NotFoundException("Номер с таким айди " + id + " не найден"));

    }

    @Transactional
    public void delete(final long id){
       hotelRepository.deleteById(id);
    }

    @Transactional
    public HotelDTO create(final HotelRequestDTO request) {
        Hotel hotel = fillOrUpdateHotelEntity(request, new Hotel());

        return hotel2DTOConverter.convert(hotelRepository.save(hotel));
    }

    @Transactional
    public HotelDTO update(final Long id, final HotelRequestDTO request) {
        Hotel existingHotel = fillOrUpdateHotelEntity(request, hotelRepository.getReferenceById(id));

        return hotel2DTOConverter.convert(hotelRepository.save(existingHotel));
    }

    private static Hotel fillOrUpdateHotelEntity(HotelRequestDTO request, Hotel hotel) {
        hotel.setLocation(request.getLocation());
        hotel.setStar(request.getStar());
        hotel.setWifi(request.getWifi());
        hotel.setInformation(request.getInformation());
        hotel.setService(request.getService());
        hotel.setPool(request.getPool());
        hotel.setParkingSpace(request.getParkingSpace());
        hotel.setFood(request.getFood());
        hotel.setFitness(request.getFitness());
        hotel.setConveniences(request.getConveniences());
        hotel.setPublicAreas(request.getPublicAreas());

        return hotel;
    }
}
