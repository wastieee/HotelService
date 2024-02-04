package com.service.hotel.Controller;

import com.service.hotel.DTO.HotelDTO;
import com.service.hotel.Entity.Hotel;
import com.service.hotel.Service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class HotelController {
    private final HotelService hotelService;


     @GetMapping(value = "/:id")
      public ResponseEntity<HotelDTO> getHotelById(@PathVariable Long id){
        return ResponseEntity.ok(hotelService.getOne(id));
      }

      @GetMapping(value ="/:list")
       public ResponseEntity<HotelDTO> getAllHotels(@PathVariable List<Hotel>){
          return ResponseEntity.ok(hotelService.getAllHotels(List<Hotel>));
       }

      @GetMapping(value ="/:create")
        public ResponseEntity<Hotel> createHotel(@PathVariable Hotel newHotel){
           return ResponseEntity.created(hotelService.create(newHotel));
       }

    @GetMapping(value = "/:id")
      public ResponseEntity<HotelDTO> deleteHotelById(@PathVariable Long id){
         return ResponseEntity.ok(hotelService.delete(id));
     }

    @GetMapping(value = "/:update")
     public ResponseEntity<HotelDTO> updateHotel(@PathVariable Hotel newHotel){
         return ResponseEntity.created(hotelService.update(newHotel));

    }



}
