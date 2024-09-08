package com.fitstam.ratingservice.external;

import com.fitstam.ratingservice.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="HOTELSERVICE")
public interface HotelService {
    @GetMapping("/hotels/getHotel/{hotelId}")
    Hotel getHotelsByHotelId(@PathVariable String hotelId);
}
