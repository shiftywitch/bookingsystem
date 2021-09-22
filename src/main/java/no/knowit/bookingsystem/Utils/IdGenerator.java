package no.knowit.bookingsystem.Utils;

public class IdGenerator {
    public static Integer id = 0;

    public static Integer genererId() {
        return ++IdGenerator.id;
    }
}
