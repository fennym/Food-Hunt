package edu.utdallas.foodhunt.restaurantmanagement.datalayer.dao;

import edu.utdallas.foodhunt.reservation.datalayer.entity.Reservation;
import edu.utdallas.foodhunt.restaurantmanagement.datalayer.entity.Restaurant;
import edu.utdallas.foodhunt.utils.db.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDao {

    private Connection conn;
    private PreparedStatement ps;

    public RestaurantDao() {
        conn = DBUtils.getDbConnection();
        ps = null;
    }

    public boolean addRestaurant(Restaurant restaurant) {
        try {
            ps = conn.prepareStatement("insert into restaurant(rname,rtype,address,city,state,zip,country,latitude,longitude,phone,food_rating,accessibility_rating,ambience_rating,overall_rating,open_timing,close_timing,seat_capacity,table_arrangement,isHomeDelivery,picture_url) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
            ps.setString(1, restaurant.getName());
            ps.setString(2, restaurant.getRestaurantType());
            ps.setString(3, restaurant.getAddress());
            ps.setString(4, restaurant.getCity());
            ps.setString(5, restaurant.getState());
            ps.setInt(6, restaurant.getZip());
            ps.setString(7, restaurant.getCountry());
            ps.setDouble(8, restaurant.getLatitude());
            ps.setDouble(9, restaurant.getLongitude());
            ps.setInt(10, Integer.parseInt(restaurant.getPhone()));
            ps.setFloat(11, restaurant.getFoodRating());
            ps.setFloat(12, restaurant.getAccessibilityRating());
            ps.setFloat(13, restaurant.getAmbienceRating());
            ps.setFloat(14, restaurant.getOverallRating());
            ps.setTime(15, restaurant.getOpenTime());
            ps.setTime(16, restaurant.getCloseTime());
            ps.setInt(17, restaurant.getSeatCapacity());
            ps.setString(18, restaurant.getTableArrangement());
            ps.setBoolean(19, restaurant.isHomeDelivery());
            ps.setString(20, restaurant.getTags());
            ps.setString(21, restaurant.getPictureUrl());
            return ps.execute();
        } catch (Exception e) {

        }
        return false;
    }

    public boolean modifyRestaurant(Restaurant restaurant) {
        try {
            ps = conn.prepareStatement("update restaurant set rname = ?,rtype=?,address = ?, city = ?, state = ?,zip = ?," +
                    "country = ?, latitude = ?, longitude = ?, phone = ?, food_rating = ?, accessibility_rating = ?, ambience_rating = ?, overall_rating = ?, " +
                    "open_timing = ?, close_timing= ?, seat_capacity= ?, table_arrangement= ?, isHomeDelivery= ?, tag= ?, isActive = ? where restaurant_id = ?");

            ps.setString(1, restaurant.getName());
            ps.setString(2, restaurant.getRestaurantType());
            ps.setString(3, restaurant.getAddress());
            ps.setString(4, restaurant.getCity());
            ps.setString(5, restaurant.getState());
            ps.setInt(6, restaurant.getZip());
            ps.setString(7, restaurant.getCountry());
            ps.setDouble(8, restaurant.getLatitude());
            ps.setDouble(9, restaurant.getLongitude());
            ps.setString(10, restaurant.getPhone());
            ps.setFloat(11, restaurant.getFoodRating());
            ps.setFloat(12, restaurant.getAccessibilityRating());
            ps.setFloat(13, restaurant.getAmbienceRating());
            ps.setFloat(14, restaurant.getOverallRating());
            ps.setTime(15, restaurant.getOpenTime());
            ps.setTime(16, restaurant.getCloseTime());
            ps.setInt(17, restaurant.getSeatCapacity());
            ps.setString(18, restaurant.getTableArrangement());
            ps.setBoolean(19, restaurant.isHomeDelivery());
            ps.setString(20, restaurant.getTags());
            ps.setBoolean(21, restaurant.isStatus());
            ps.setInt(22, restaurant.getId());
            int status = ps.executeUpdate();
            return status > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Restaurant getRestaurant(String id) {
        Restaurant restaurant = new Restaurant();
        try {
            ps = conn.prepareStatement("select * from restaurant where restaurant_id = ?");
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                restaurant.setId(Integer.parseInt(id));
                restaurant.setName(rs.getString("rname"));
                restaurant.setRestaurantType(rs.getString("rtype"));
                restaurant.setAddress(rs.getString("address"));
                restaurant.setCity(rs.getString("city"));
                restaurant.setState(rs.getString("state"));
                restaurant.setZip(rs.getInt("zip"));
                restaurant.setCountry(rs.getString("country"));
                restaurant.setLatitude(rs.getDouble("latitude"));
                restaurant.setLongitude(rs.getDouble("longitude"));
                restaurant.setPhone(rs.getString("phone"));
                restaurant.setFoodRating(rs.getFloat("food_rating"));
                restaurant.setAccessibilityRating(rs.getFloat("accessibility_rating"));
                restaurant.setAmbienceRating(rs.getFloat("ambience_rating"));
                restaurant.setOverallRating(rs.getFloat("overall_rating"));
                restaurant.setOpenTime(rs.getTime("open_timing"));
                restaurant.setCloseTime(rs.getTime("close_timing"));
                restaurant.setSeatCapacity(rs.getInt("seat_capacity"));
                restaurant.setTableArrangement(rs.getString("table_arrangement"));
                restaurant.setHomeDelivery(rs.getBoolean("isHomeDelivery"));
                restaurant.setTags(rs.getString("tag"));
                restaurant.setPictureUrl(rs.getString("picture_url"));
                restaurant.setStatus(rs.getBoolean("isActive"));
            }
            return restaurant;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();

        try {
            ps = conn.prepareStatement("select * from restaurant where isActive = 1");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(rs.getInt("restaurant_id"));
                restaurant.setName(rs.getString("rname"));
                restaurant.setRestaurantType(rs.getString("rtype"));
                restaurant.setAddress(rs.getString("address"));
                restaurant.setCity(rs.getString("city"));
                restaurant.setState(rs.getString("state"));
                restaurant.setZip(rs.getInt("zip"));
                restaurant.setCountry(rs.getString("country"));
                restaurant.setLatitude(rs.getDouble("latitude"));
                restaurant.setLongitude(rs.getDouble("longitude"));
                restaurant.setPhone(rs.getString("phone"));
                restaurant.setFoodRating(rs.getFloat("food_rating"));
                restaurant.setAccessibilityRating(rs.getFloat("accessibility_rating"));
                restaurant.setAmbienceRating(rs.getFloat("ambience_rating"));
                restaurant.setOverallRating(rs.getFloat("overall_rating"));
                restaurant.setOpenTime(rs.getTime("open_timing"));
                restaurant.setCloseTime(rs.getTime("close_timing"));
                restaurant.setSeatCapacity(rs.getInt("seat_capacity"));
                restaurant.setTableArrangement(rs.getString("table_arrangement"));
                restaurant.setHomeDelivery(rs.getBoolean("isHomeDelivery"));
                restaurant.setTags(rs.getString("tag"));
                restaurant.setPictureUrl(rs.getString("picture_url"));
                restaurant.setStatus(rs.getBoolean("isActive"));
                restaurants.add(restaurant);
            }
            return restaurants;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Restaurant> searchRestaurant(String keyword) {
        List<Restaurant> restaurants = new ArrayList<>();

        try {
            ps = conn.prepareStatement("select distinct * from restaurant where rname like %" + keyword + "% OR " + "rtype like %" + keyword + "% OR" +
                    "address like %" + keyword + "% or city like %" + keyword + "% or state like %" + keyword + "% or zip like %" + Integer.parseInt(keyword) + "% or tag like %" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(rs.getInt("restaurant_id"));
                restaurant.setName(rs.getString("rname"));
                restaurant.setName(rs.getString("rtype"));
                restaurant.setAddress(rs.getString("address"));
                restaurant.setCity(rs.getString("city"));
                restaurant.setState(rs.getString("state"));
                restaurant.setZip(rs.getInt("zip"));
                restaurant.setCountry(rs.getString("country"));
                restaurant.setLatitude(rs.getDouble("latitude"));
                restaurant.setLongitude(rs.getDouble("longitude"));
                restaurant.setPhone(rs.getString("phone"));
                restaurant.setFoodRating(rs.getFloat("food_rating"));
                restaurant.setAccessibilityRating(rs.getFloat("accessibility_rating"));
                restaurant.setAmbienceRating(rs.getFloat("ambience_rating"));
                restaurant.setOverallRating(rs.getFloat("overall_rating"));
                restaurant.setOpenTime(rs.getTime("open_timing"));
                restaurant.setCloseTime(rs.getTime("close_timing"));
                restaurant.setSeatCapacity(rs.getInt("seat_capacity"));
                restaurant.setTableArrangement(rs.getString("table_arrangement"));
                restaurant.setHomeDelivery(rs.getBoolean("isHomeDelivery"));
                restaurant.setTags(rs.getString("tag"));
                restaurant.setPictureUrl(rs.getString("picture_url"));
                restaurant.setStatus(rs.getBoolean("isActive"));
                if(rs.getBoolean("isActive")) restaurants.add(restaurant);
            }
            return restaurants;
        } catch (Exception e) {

        }

        return null;
    }

    public boolean deleteRestaurant(String id) {
        try {
            ps = conn.prepareStatement("delete from restaurant where restaurant_id = ?");
            ps.setInt(1, Integer.parseInt(id));
            return ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }


    @Override
    protected void finalize() throws Throwable {
        conn.close();
    }
}
