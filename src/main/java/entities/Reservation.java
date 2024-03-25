package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Reservation {

    @Id
    private Long id;
    private Long restaurantId;
    private Long userId;
    private LocalDate date;
    private LocalTime time;
    private Integer partySize;
}
