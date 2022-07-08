package by.khaletski.practice.dao;

import by.khaletski.practice.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private static int id;
    private List<Person> personList;

    {
        personList = new ArrayList<>();
        personList.add(new Person(++id, "Tom"));
        personList.add(new Person(++id, "Bob"));
        personList.add(new Person(++id, "Mike"));
        personList.add(new Person(++id, "Kate"));
    }

    public List<Person> getAllPersonsFromList() {
        return personList;
    }

    public Person getPersonFromListById(int id) {
        return personList.stream().filter(persons -> persons.getId() == id).findAny().orElse(null);
    }
}
