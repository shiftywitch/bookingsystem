package no.knowit.bookingsystem.Configuration;

import lombok.AllArgsConstructor;
import no.knowit.bookingsystem.BookingController;
import no.knowit.bookingsystem.Rom.RomType;
import no.knowit.bookingsystem.dto.BookRomDto;
import no.knowit.bookingsystem.dto.RegistrerRomDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@AllArgsConstructor
@Configuration
public class DummyData {

    private final BookingController bookingController;

    @Bean
    protected void populateWithSomeData() {

        //Registrere rom
        bookingController.regristrerRom(new RegistrerRomDto(2, 1000, RomType.Bryllupssuite));
        bookingController.regristrerRom(new RegistrerRomDto(4, 450, RomType.Kvalitetesrom));
        bookingController.regristrerRom(new RegistrerRomDto(1, 500, RomType.Businessuite));
        bookingController.regristrerRom(new RegistrerRomDto(2, 305, RomType.Lavprisrom));


        //Booking
        bookingController.bookRom(new BookRomDto(1, 2, new Date()));
        bookingController.bookRom(new BookRomDto(1, 2, new Date()));
        bookingController.bookRom(new BookRomDto(2, 3, new Date()));
        bookingController.bookRom(new BookRomDto(3, 1, new Date()));
        bookingController.bookRom(new BookRomDto(4, 2, new Date()));
    }

}
