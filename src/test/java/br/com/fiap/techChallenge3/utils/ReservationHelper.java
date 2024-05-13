package br.com.fiap.techChallenge3.utils;

public class ReservationHelper {

    public String bodyRequestReservation(){

        String hour = "22:00";
        String date = "04/12/2024";
        Integer idRestaurantd = 1;
        String restaurantId = idRestaurantd.toString();

        Integer idCustomer = 1;
        String customerId = idCustomer.toString();

        String requestBody = "{\"hour\":\"" + hour + "\",\"date\":\"" + date + "\",\"restaurantId\":\"" + restaurantId + "\",\"customerId\":\"" + customerId + "\"}";
        return requestBody;
    }
}
