package no.knowit.bookingsystem;

import no.knowit.bookingsystem.Booking.Booking;
import no.knowit.bookingsystem.Rom.Rom;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepository {

    public void registrerRom(Rom rom) {
        Database.rom.add(rom);
    }

    public void bookRom(Booking booking) {
        Database.bookings.add(booking);
    }

    public List<Rom> hentAlleRom() {
        return Database.rom;
    }
}
