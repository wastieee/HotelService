package com.service.hotel.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Hotel hotel;

    @Column(name = "room_type", nullable = false)
    public String roomType;

    @Column(name = "conditioner", nullable = false)
    public String conditioner;

    @Column(name = "private_bathroom", nullable = false)
    public String privateBathroom;

    @Column(name = "room_id", nullable = false)
    private String roomId;

    @Column(name = "price_per_night", nullable = false)
    private Integer pricePerNight;

}
