package ru.job4j.trainee.part003.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.getAddress()).collect(Collectors.toList());
    }

    List<Address> collectSortedDistinct(List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .sorted(Comparator.comparing(address -> address.getCity()))
                .distinct()
                .collect(Collectors.toList());
    }
}
