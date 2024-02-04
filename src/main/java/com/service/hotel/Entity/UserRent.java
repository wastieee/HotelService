package com.service.hotel.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_rent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class UserRent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Column(name = "start_rent_date", nullable = false)
    private LocalDateTime startRentDate;

    @Column(name = "end_rent_date", nullable = false)
    private LocalDateTime endRentDate;


}
