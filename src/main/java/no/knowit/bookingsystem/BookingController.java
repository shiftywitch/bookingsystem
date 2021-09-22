package no.knowit.bookingsystem;

import lombok.AllArgsConstructor;
import no.knowit.bookingsystem.Booking.Booking;
import no.knowit.bookingsystem.Rom.Rom;
import no.knowit.bookingsystem.dto.BookRomDto;
import no.knowit.bookingsystem.dto.RegistrerRomDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/*")
@AllArgsConstructor
@Controller
public class BookingController {

    BookingService bookingService;

    @PostMapping("/registrer_rom")
    public Integer regristrerRom(@RequestBody RegistrerRomDto registrerRomDto) {
        return bookingService.registrerRom(registrerRomDto);

    }

    @PostMapping("/book_rom")
    public void bookRom(@RequestBody BookRomDto bookRomDto) {
        bookingService.bookRom(bookRomDto);
    }

    @GetMapping("/totalInntjening/{romId}")
    public Integer hentTotalInntjeningForEtRom(@PathVariable  Integer romId) {
        return bookingService.hentTotalInntjeningForEtRom(romId);
    }

    @GetMapping("/totalInntjening/rom")
    public List<Rom> hentAlleRomEtterTotalInntjening() {
        return bookingService.hentAlleRomEtterTotalInntjening();
    }

    @GetMapping("/rom_{romId}/flest_dager_booket_konsekutivt")
    public Integer hentHoeyestAntallDagerKonsekutivtBooketRom(@PathVariable Integer romId) {
        return bookingService.hentHoeyestAntallDagerKonsekutivtBooketRom(romId);
    }
}
