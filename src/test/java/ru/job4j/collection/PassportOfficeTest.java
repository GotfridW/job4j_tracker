package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("6g32v", "Forrest Gump");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addBySamePassport() {
        Citizen citizen = new Citizen("42g653d", "Will Smith");
        Citizen citizenTwin = new Citizen("42g653d", "John Smith");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertFalse(office.add(citizenTwin));
    }
}