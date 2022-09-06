package com.demo.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.hotel.entity.Hotel;
import com.demo.hotel.entity.Item;
import com.demo.hotel.util.Message;

@Service
public interface HotelService {
//	Add hotel
	Message addHotel(Hotel hotel);
//	Update hotel (Address and name)
	Message updateHotel(Hotel hotel);
//	Get by id
	Optional<Hotel> findHotelById(int id);
//	Get by name
	Optional<Hotel> findHotelByName(String name);
//	Get by name like
	List<Hotel> findHotelsByNameLike(String name);
//	Get all the hotels
	List<Hotel> findAllHotels();
	
//	Add item
	Message addItemToHotel(int hotelId,Item item);
//	Update the item
	Message updateItemOfHotel(int itemId,Item item);
//	Get all the items of the hotel
	List<Item> findAllitems();
//	Get the item in price range of a hotel
//	Get the item By name like of a hotel
//	Get the item in discount range of a hotel
//	Get the items by item id list (In you did it in your demo project)
	List<Item> findAllSeleteditems(List<Integer> itemIds);
//	Get all the orders of the hotel - not here 
//	Get details of the order -- not here

}
