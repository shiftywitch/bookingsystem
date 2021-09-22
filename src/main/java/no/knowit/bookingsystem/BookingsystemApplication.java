package no.knowit.bookingsystem;

import lombok.AllArgsConstructor;
import no.knowit.bookingsystem.Rom.RomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@AllArgsConstructor
@SpringBootApplication
public class BookingsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingsystemApplication.class, args);
        BookingController bookingController = new BookingController(new BookingService(new BookingRepository()));

        bookingController.hentAlleRomEtterTotalInntjening().forEach(rom -> {
            System.out.println(rom.getId());
            System.out.println(rom.getPrisPrDag());
            System.out.println(rom.getSengePlasser());
            System.out.println(rom.getRomType());
            System.out.println("");
        });
    }
}
