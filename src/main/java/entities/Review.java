package entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Review {
    @Id
    private Long id;
    private Long restaurantId;
    private Long userId;
    private Double rating;
    private String comment;
}
