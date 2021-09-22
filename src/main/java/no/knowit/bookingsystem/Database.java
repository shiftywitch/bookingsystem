package no.knowit.bookingsystem;

import no.knowit.bookingsystem.Booking.Booking;
import no.knowit.bookingsystem.Rom.Rom;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Database {
    public static List<Rom> rom = new ArrayList<>();
    public static List<Booking> bookings = new ArrayList<>();
}
