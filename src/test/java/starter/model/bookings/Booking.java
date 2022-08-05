package starter.model.bookings;

import lombok.Data;
import lombok.Getter;

@Getter
public class Booking {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

}
