package edu.utdallas.foodhunt.restaurantmanagement.businesslayer;

import edu.utdallas.foodhunt.restaurantmanagement.datalayer.dao.RestaurantDao;
import edu.utdallas.foodhunt.restaurantmanagement.datalayer.entity.Restaurant;

import java.util.List;

public class RestaurantService {

    private RestaurantDao restaurantDao;

    public RestaurantService(){
        restaurantDao = new RestaurantDao();
    }

    public List<Restaurant> getRestaurants(){
        return restaurantDao.getRestaurants();
    }

    public  boolean addRestaurant(Restaurant restaurant){
        return restaurantDao.addRestaurant(restaurant);
    }

    public Restaurant getRestaurant(String id){
        return restaurantDao.getRestaurant(id);
    }
    public boolean modifyRestaurant(Restaurant restaurant){
        return restaurantDao.modifyRestaurant(restaurant);
    }
}
