package no.knowit.bookingsystem;

import lombok.AllArgsConstructor;
import no.knowit.bookingsystem.Booking.Booking;
import no.knowit.bookingsystem.Rom.Rom;
import no.knowit.bookingsystem.Utils.IdGenerator;
import no.knowit.bookingsystem.dto.BookRomDto;
import no.knowit.bookingsystem.dto.RegistrerRomDto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingService {

    BookingRepository bookingRepository;

    public Integer registrerRom(RegistrerRomDto registrerRomDto) {

        var id = IdGenerator.genererId();

        Rom nyttRom = new Rom(
                id,
                registrerRomDto.getSengePlasser(),
                registrerRomDto.getPrisPrDag(),
                registrerRomDto.getRomType()
        );

        bookingRepository.registrerRom(nyttRom);

        return id;
    }

    private Rom hentRomMedId(Integer romId) {
        return Database.rom.stream()
                .filter(rom -> romId.equals(rom.getId()))
                .findAny()
                .orElseThrow();
    }

    private Boolean eksistererRom(Integer romId) {
        return Database.rom
                .stream()
                .anyMatch(rom -> romId.equals(rom.getId()));
    }

    public Integer hentTotalInntjeningForEtRom(Integer romId) {
        if (!eksistererRom(romId)) {
            throw new IllegalStateException("Room does not exists");
        }

        return Database.bookings
                .stream()
                .filter(booking -> romId.equals(booking.getRom().getId()))
                .mapToInt(booking -> booking.getRom().getPrisPrDag())
                .sum();

    }

    public List<Rom> hentAlleRomEtterTotalInntjening() {
        List<Rom> alleRom = bookingRepository.hentAlleRom();

        List<Rom> sorted = alleRom.stream()
                .sorted(Comparator.comparingInt(rom -> hentTotalInntjeningForEtRom(rom.getId())))
                .collect(Collectors.toList());

        Collections.reverse(sorted);
        return sorted;
    }


    //Funker ikke
    public Integer hentHoeyestAntallDagerKonsekutivtBooketRom(Integer romId) {
        List<Booking> alleBokkings = hentBookingerForRom(romId);
        alleBokkings.stream()
                .sorted(Comparator.comparing(Booking::getDate));
        return 1;
    }

    private List<Booking> hentBookingerForRom(Integer romId) {
        eksistererRom(romId);
        return Database.bookings
                .stream()
                .filter(booking -> romId.equals(booking.getRom().getId()))
                .collect(Collectors.toList());
    }

    public void bookRom(BookRomDto bookRomDto) {

        Rom rom = hentRomMedId(bookRomDto.getRomId());
        Booking nyBooking = new Booking(
                rom,
                bookRomDto.getDate(),
                bookRomDto.getGjester()
        );
        bookingRepository.bookRom(nyBooking);
    }
}
