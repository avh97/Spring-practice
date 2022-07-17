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
        personList.add(new Person(++id, "Tom", 24, "tom@mail.com"));
        personList.add(new Person(++id, "Bob", 52, "bob@mail.com"));
        personList.add(new Person(++id, "Mike", 18, "mike@mail.com"));
        personList.add(new Person(++id, "Kate", 28, "kate@mail.com"));
    }

    public List<Person> getAllPersonsFromList() {
        return personList;
    }

    public Person getPersonFromListById(int id) {
        return personList.stream().filter(persons -> persons.getId() == id).findAny().orElse(null);
    }

    public void addPersonToList(Person person) {
        person.setId(++id);
        personList.add(person);
    }

    public void editPersonInList(int id, Person newPerson) {
        Person person = getPersonFromListById(id);
        person.setName(newPerson.getName());
        person.setAge(newPerson.getAge());
        person.setEmail(newPerson.getEmail());
    }

    public void removePersonFromList(int id) {
        personList.removeIf(p -> p.getId() == id);
    }
}
