package com.service.hotel.DTO.Converter;

import com.service.hotel.DTO.HotelDTO;
import com.service.hotel.Entity.Hotel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class Hotel2DTOConverter implements Converter<Hotel, HotelDTO> {
    @Override
    public HotelDTO convert(Hotel source) {
        return HotelDTO.builder().id(source.getId()).location(source.getLocation())
                .star(source.getStar())
                .wifi(source.getWifi())
                .information(source.getInformation())
                .service(source.getService())
                .pool(source.getPool())
                .parkingSpace(source.getParkingSpace())
                .food(source.getFood())
                .fitness(source.getFitness())
                .conveniences(source.getConveniences())
                .publicAreas(source.getPublicAreas()).build();
    }
}
