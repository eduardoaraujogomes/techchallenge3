package br.com.fiap.techChallenge3.infraestructure.config.web;

import br.com.fiap.techChallenge3.entity.restaurant.gateway.RestaurantGateway;
import br.com.fiap.techChallenge3.infraestructure.config.db.repository.RestaurantRepository;
import br.com.fiap.techChallenge3.infraestructure.restaurant.gateway.RestaurantDatabaseGateway;
import br.com.fiap.techChallenge3.usecase.restaurant.CreateRestaurantUseCase;
import br.com.fiap.techChallenge3.usecase.restaurant.DeleteRestaurantUseCase;
import br.com.fiap.techChallenge3.usecase.restaurant.GetRestaurantUseCase;
import br.com.fiap.techChallenge3.usecase.restaurant.SearchRestaurantUseCase;
import br.com.fiap.techChallenge3.usecase.restaurant.UpdateRestaurantUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {

    @Bean
    public CreateRestaurantUseCase createRestaurantUseCase(RestaurantRepository restaurantRepository){
        RestaurantGateway restaurantGateway = new RestaurantDatabaseGateway(restaurantRepository);
        return new CreateRestaurantUseCase(restaurantGateway);
    }

    @Bean
    public DeleteRestaurantUseCase deleteRestaurantUseCase(RestaurantRepository restaurantRepository){
        RestaurantGateway restaurantGateway = new RestaurantDatabaseGateway(restaurantRepository);
        return new DeleteRestaurantUseCase(restaurantGateway);
    }

    @Bean
    public GetRestaurantUseCase getRestaurantUseCase(RestaurantRepository restaurantRepository){
        RestaurantGateway restaurantGateway = new RestaurantDatabaseGateway(restaurantRepository);
        return new GetRestaurantUseCase(restaurantGateway);
    }

    @Bean
    public SearchRestaurantUseCase searchRestaurantUseCase(RestaurantRepository restaurantRepository){
        RestaurantGateway restaurantGateway = new RestaurantDatabaseGateway(restaurantRepository);
        return new SearchRestaurantUseCase(restaurantGateway);
    }

    @Bean
    public UpdateRestaurantUseCase updateRestaurantUseCase(RestaurantRepository restaurantRepository){
        RestaurantGateway restaurantGateway = new RestaurantDatabaseGateway(restaurantRepository);
        return new UpdateRestaurantUseCase(restaurantGateway);
    }
}
