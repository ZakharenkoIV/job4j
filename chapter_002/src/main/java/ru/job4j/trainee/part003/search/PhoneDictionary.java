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
     * @return Список подошедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> addressPredicate = (person) -> person.getAddress().contains(key);
        Predicate<Person> phonePredicate = (person) -> person.getPhone().contains(key);
        Predicate<Person> surnamePredicate = (person) -> person.getSurname().contains(key);
        Predicate<Person> namePredicate = (person) -> person.getName().contains(key);
        Predicate<Person> combine = (person) -> addressPredicate.or(phonePredicate).or(surnamePredicate).or(namePredicate).test(person);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
