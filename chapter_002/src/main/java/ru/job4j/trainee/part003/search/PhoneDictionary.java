package ru.job4j.trainee.part003.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = (person) -> person.getName().contains(key);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.or(person1 -> person1.getSurname().contains(key))
                    .or(person1 -> person1.getPhone().contains(key))
                    .or(person1 -> person1.getAddress().contains(key))
                    .test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
