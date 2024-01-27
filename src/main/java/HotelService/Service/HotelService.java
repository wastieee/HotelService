package HotelService.Service;

import HotelService.Entity.Hotel;
import HotelService.Exceptions.NotFoundException;
import HotelService.Repository.HotelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Transactional(readOnly = true)
    public List<Hotel> getAllCars() {
        return hotelRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Hotel getOne(final Long id) {
        return hotelRepository.findById(id).orElseThrow(() -> new NotFoundException("Номер с таким айди " + id + " не найден"));

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
        Hotel existingHotel = getOne(id);
        existingHotel.setLocation(newHotel.getLocation());
        existingHotel.setPricePerNight(newHotel.getPricePerNight());
        existingHotel.setStar(newHotel.getStar());
        existingHotel.setInformation(newHotel.getInformation());
        existingHotel.setWifi(newHotel.getWifi());
        existingHotel.setService(newHotel.getService());
        existingHotel.setPool(newHotel.getPool());
        existingHotel.setParkingSpace(newHotel.getParkingSpace());
        existingHotel.setFood(newHotel.getFood());
        existingHotel.setFitness(newHotel.getFitness());
        existingHotel.setConveniences(newHotel.getConveniences());
        existingHotel.setTimeOfStay(newHotel.getTimeOfStay());
        existingHotel.setPublicAreas(newHotel.getPublicAreas());
        existingHotel.setRoomId(newHotel.getRoomId());
        return hotelRepository.save(existingHotel);






    }
}
