package service;

import entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.RestaurantRepository;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Long id, Restaurant updatedRestaurant) {
        if (restaurantRepository.existsById(id)) {
            updatedRestaurant.setId(id);
            return restaurantRepository.save(updatedRestaurant);
        }
        return null;
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
