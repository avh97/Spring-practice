package by.khaletski.practice.controller;

import by.khaletski.practice.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/persons")
public class PersonsController {
    private final PersonDao personDao;

    @Autowired
    public PersonsController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping()
    public String showAllPersons(Model model) {
        model.addAttribute("persons", personDao.getAllPersonsFromList());
        return "persons/showAllPersons";
    }

    @GetMapping("/{id}")
    public String showPerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDao.getPersonFromListById(id));
        return "persons/showPerson";
    }
}
