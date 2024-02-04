package com.service.hotel.DTO;
import com.service.hotel.Entity.Room;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HotelDTO {

    private Long id;

    private String location;

    private Integer star;

    private String wifi;

    private String information;

    private String service;

    private String pool;

    private String parkingSpace;

    private String food;

    private String fitness;

    private String conveniences;

    private String publicAreas;

}
