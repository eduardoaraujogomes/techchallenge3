package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.EnableCaching;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Restaurant {

    @Id
    private Long id;
    private String name;
    private String location;
    private String cuisineType;
    private String openingHours;
    private Integer capacity;
}
