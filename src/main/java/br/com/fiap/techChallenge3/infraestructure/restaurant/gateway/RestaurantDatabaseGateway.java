package br.com.fiap.techChallenge3.infraestructure.restaurant.gateway;

import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.entity.restaurant.model.Restaurant;
import br.com.fiap.techChallenge3.infraestructure.config.db.repository.RestaurantRepository;
import br.com.fiap.techChallenge3.infraestructure.config.db.schema.RestaurantSchema;

import java.util.List;
import java.util.Optional;

public class RestaurantDatabaseGateway implements RestaurantGateway {

    private final RestaurantRepository restaurantRepository;

    public RestaurantDatabaseGateway(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(new RestaurantSchema(restaurant)).toRestaurant();
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return restaurantRepository.save(new RestaurantSchema(restaurant)).toRestaurant();
    }

    @Override
    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Optional<Restaurant> findByName(String name) {
        return restaurantRepository.findByName(name);
    }

    @Override
    public List<Restaurant> findByCuisine(String cuisine) {
        return restaurantRepository.findByCuisine(cuisine);
    }

    @Override
    public List<Restaurant> findByLocation(String location) {
        return restaurantRepository.findByLocation(location);
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository
                .findAll()
                .stream()
                .map(RestaurantSchema::toRestaurant)
                .toList();
    }

    @Override
    public Optional <Restaurant> findById(Long id) {
        return restaurantRepository
                .findById(id)
                .map(RestaurantSchema::toRestaurant);
    }

}
