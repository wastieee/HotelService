package com.service.hotel.DTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelRequestDTO {
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
