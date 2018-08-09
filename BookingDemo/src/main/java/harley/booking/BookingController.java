package harley.booking;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/booking")
public class BookingController {
    private List<HotelBooking> bookings;

    public BookingController(){
        bookings = new ArrayList<>();
        bookings.add(new HotelBooking("Marriot",200.50,3));
        bookings.add(new HotelBooking("ibis",90,4));
        bookings.add(new HotelBooking("Novotel",140.47,1));
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<HotelBooking> getAll(){
        return bookings;
    }

    @RequestMapping(value = "/affordable/{price}",method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price) {
        return bookings.stream().filter(x -> x.getPricePerNight() <= price)
                .collect(Collectors.toList());
    }
}
