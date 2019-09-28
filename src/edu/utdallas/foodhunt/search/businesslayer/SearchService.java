package edu.utdallas.foodhunt.search.businesslayer;

import edu.utdallas.foodhunt.restaurantmanagement.datalayer.dao.RestaurantDao;
import edu.utdallas.foodhunt.restaurantmanagement.datalayer.entity.Restaurant;

import java.util.*;

public class SearchService {

    public List<Restaurant> searchRestaurants(String keyword){
        return new RestaurantDao().searchRestaurant(keyword);
    }
    public List<Restaurant> searchRestaurants(String keyword, double latitude, double longitude){
        List<Restaurant> restaurants = searchRestaurants(keyword);
        for(Restaurant restaurant: restaurants){
            restaurant.setDistanceFromUser(calculateDistance(latitude,longitude, restaurant.getLatitude(), restaurant.getLongitude()));
        }
        Collections.sort(restaurants,new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant o1, Restaurant o2) {
                if(o1.getDistanceFromUser() < o2.getDistanceFromUser()) return -1;
                if(o1.getDistanceFromUser() > o2.getDistanceFromUser()) return 1;
                return 0;
            }
        });
        Collections.reverse(restaurants);
        return restaurants;
    }

    public List<Restaurant> searchAlternateRestaurants(String restaurantId, double latitude, double longitude){
        RestaurantDao rdao = new RestaurantDao();
        List<Restaurant> allRestaurants = rdao.getRestaurants();
        Restaurant thisRestaurant = rdao.getRestaurant(restaurantId);
        for(Restaurant restaurant: allRestaurants){
            restaurant.setSimilarityScore(calculateSimilarityScore(restaurant, thisRestaurant, latitude,longitude));
        }
        Collections.sort(allRestaurants, new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant o1, Restaurant o2) {
                return o1.getSimilarityScore() - o2.getSimilarityScore();
            }
        });
        Collections.reverse(allRestaurants);

        return allRestaurants;
    }

    private int calculateSimilarityScore(Restaurant restaurant, Restaurant thisRestaurant, double latitude, double longitude) {

        double thisRestaurantdistance = calculateDistance(latitude,longitude,thisRestaurant.getLatitude(),thisRestaurant.getLongitude());
        double restaurantdistance =  calculateDistance(latitude,longitude, restaurant.getLatitude(), restaurant.getLongitude());
        int similarityScore = (int)Math.abs(Math.ceil(thisRestaurantdistance-restaurantdistance));
        if(restaurant.getOverallRating() >= thisRestaurant.getOverallRating()) similarityScore+=5;
        if(restaurant.getAmbienceRating()>= thisRestaurant.getAmbienceRating()) similarityScore+=2;
        if(restaurant.getAccessibilityRating() >= thisRestaurant.getAccessibilityRating()) similarityScore++;
        if(restaurant.getFoodRating() >= thisRestaurant.getFoodRating()) similarityScore+=3;
        String[] thisRestaurantTags =  thisRestaurant.getTags().split(",");
        List<String> tagList = Arrays.asList(thisRestaurantTags);
        String[] restaurantTags = restaurant.getTags().split(",");
        for(String tag: restaurantTags){
            if(tagList.contains(tag)) similarityScore++;
        }

        return similarityScore;
    }

    private double calculateDistance(double latitude, double longitude, double latitude1, double longitude1) {
        final int radius_of_Earth = 6371;
        double latDist = Math.toRadians(latitude1-latitude);
        double longDist = Math.toRadians(longitude1-longitude);
        double a = Math.sin(latDist / 2) * Math.sin(latDist / 2)
                + Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(latitude1))
                * Math.sin(longDist / 2) * Math.sin(longDist / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return radius_of_Earth * c * 1000;
    }


}
