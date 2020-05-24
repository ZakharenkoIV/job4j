package ru.job4j.trainee.part003.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    List<Profile> profiles = List.of(
            new Profile(new Address("Moscow", "Rusakovsky")),
            new Profile(new Address("Kaliningrad", "Frunze")));
    Profiles prof = new Profiles();

    @Test
    public void whenClassDivided70to100() {
        List<Address> result = prof.collect(profiles);
        List<Address> expected = List.of(
                new Address("Moscow", "Rusakovsky"),
                new Address("Kaliningrad", "Frunze")
        );
        assertThat(result, is(expected));
    }
}
