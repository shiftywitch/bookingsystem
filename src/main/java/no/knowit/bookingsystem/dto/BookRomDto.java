package no.knowit.bookingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class BookRomDto {
    private Integer romId;
    private Integer gjester;
    private Date date;
}
