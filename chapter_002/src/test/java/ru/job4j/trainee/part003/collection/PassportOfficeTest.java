package ru.job4j.trainee.part003.collection;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class PassportOfficeTest {

    @Test
    public void whenAddNewCitizenThenGetInfoCitizen() {
        Citizen citizen = new Citizen("1111", "Ivan Ivanov");
        PassportOffice office = new PassportOffice();
        office.addNewCitizen(citizen);
        assertThat(office.getInfoCitizen(citizen.getPassport()), is(citizen));
    }
}
