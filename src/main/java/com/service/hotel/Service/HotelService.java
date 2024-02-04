package com.service.hotel.Service;

import com.service.hotel.DTO.Converter.Hotel2DTOConverter;
import com.service.hotel.DTO.HotelDTO;
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
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
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
    public Hotel create(final Hotel newHotel) {
        return hotelRepository.save(newHotel);
    }

    @Transactional
    public Hotel update(final Hotel newHotel, final Long id) {
        Hotel existingHotel = hotelRepository.getReferenceById(id);
        existingHotel.setLocation(newHotel.getLocation());
        existingHotel.setStar(newHotel.getStar());
        existingHotel.setInformation(newHotel.getInformation());
        existingHotel.setWifi(newHotel.getWifi());
        existingHotel.setService(newHotel.getService());
        existingHotel.setPool(newHotel.getPool());
        existingHotel.setParkingSpace(newHotel.getParkingSpace());
        existingHotel.setFood(newHotel.getFood());
        existingHotel.setFitness(newHotel.getFitness());
        existingHotel.setConveniences(newHotel.getConveniences());
        existingHotel.setPublicAreas(newHotel.getPublicAreas());
        return hotelRepository.save(existingHotel);






    }
}
