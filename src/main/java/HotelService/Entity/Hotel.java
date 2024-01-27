package HotelService.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "price_per_night", nullable = false)
    private Integer pricePerNight;

    @Column(name = "star", nullable = false)
    private Integer star;

    @Column(name = "wifi", nullable = false)
    private String wifi;

    @Column(name = "information", nullable = false)
    private String information;

    @Column(name = "service", nullable = false)
    private String service;

    @Column(name = "pool", nullable = false)
    private String pool;

    @Column(name = "parking_space", nullable = false)
    private String parkingSpace;

    @Column(name = "food", nullable = false)
    private String food;

    @Column(name = "fitness", nullable = false)
    private String fitness;

    @Column(name = "conveniences", nullable = false)
    private String conveniences;

    @Column(name = "time_of_stay", nullable = false)
    private Integer timeOfStay;

    @Column(name = "number_of_guests", nullable = false)
    private Integer numberOfGuests;

    @Column(name = "public_areas", nullable = false)
    private String publicAreas;

    @Column(name = "created_when", nullable = false)
    private LocalDate createdWhen;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "room_id", nullable = false)
    private String roomId;

    @OneToMany
    @JoinColumn
    private Room room;


}
