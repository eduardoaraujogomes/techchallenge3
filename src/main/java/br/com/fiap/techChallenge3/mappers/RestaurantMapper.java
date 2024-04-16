package br.com.fiap.techChallenge3.mappers;

import br.com.fiap.techChallenge3.dto.restaurant.RestaurantRequestDTO;
import br.com.fiap.techChallenge3.dto.restaurant.RestaurantResponseDTO;
import br.com.fiap.techChallenge3.entities.Restaurant;

public interface RestaurantMapper {

 static Restaurant toRestaurantEntity (RestaurantRequestDTO dto){
    Restaurant restaurant = new Restaurant();
    restaurant.setName(dto.name());
    restaurant.setCapacity(dto.capacity());
    restaurant.setLocation(dto.location());
    restaurant.setCuisineType(dto.cuisineType());
    restaurant.setOpeningHours(dto.openingHours());
    return restaurant;
 }

 static RestaurantResponseDTO returnRestaurant (Restaurant restaurant){
     return new RestaurantResponseDTO(restaurant.getId(),
             restaurant.getName(),
             restaurant.getLocation(),
             restaurant.getCuisineType(),
             restaurant.getOpeningHours(),
             restaurant.getCapacity(),
             restaurant.getReviews());
 }


}
