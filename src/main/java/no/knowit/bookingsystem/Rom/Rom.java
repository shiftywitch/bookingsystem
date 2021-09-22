package no.knowit.bookingsystem.Rom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Rom {
    private Integer id;
    private Integer sengePlasser;
    private Integer prisPrDag;
    private RomType romType;
}
