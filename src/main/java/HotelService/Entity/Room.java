package HotelService.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToOne
    @JoinColumn
    private Hotel hotel;

    @Column(name = "room_type", nullable = false)
    public String roomType;

    @Column(name = "conditioner", nullable = false)
    public String conditioner;

    @Column(name = "private_bathroom", nullable = false)
    public String privateBathroom;

}
