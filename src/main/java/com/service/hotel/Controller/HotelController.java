package com.service.hotel.Controller;

import com.service.hotel.DTO.HotelDTO;
import com.service.hotel.DTO.HotelRequestDTO;
import com.service.hotel.Service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/hotel")
public class HotelController {
    private final HotelService hotelService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<HotelDTO> getHotelById(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.getOne(id));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @PostMapping
    public ResponseEntity<HotelDTO> createHotel(@RequestBody HotelRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(request));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteHotelById(@PathVariable Long id) {
        hotelService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<HotelDTO> updateHotel(@PathVariable Long id, @RequestBody HotelRequestDTO request) {
        return ResponseEntity.ok(hotelService.update(id, request));
    }

}
