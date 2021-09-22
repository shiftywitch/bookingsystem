package no.knowit.bookingsystem.Booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import no.knowit.bookingsystem.Rom.Rom;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class Booking {
    private Rom rom;
    private Date date;
    private Integer gjester;
}
