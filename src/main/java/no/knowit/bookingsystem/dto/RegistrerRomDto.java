package no.knowit.bookingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import no.knowit.bookingsystem.Rom.RomType;

@AllArgsConstructor
@Getter
@Setter
public class RegistrerRomDto {
    private Integer sengePlasser;
    private Integer prisPrDag;
    private RomType romType;
}
