package ru.job4j.trainee.part003.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean addNewCitizen(Citizen citizen) {
        boolean success = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            success = true;
        }
        return success;
    }

    public Citizen getInfoCitizen(String password) {
        return citizens.get(password);
    }
}
