package by.khaletski.practice.controller;

import by.khaletski.practice.dao.PersonDao;
import by.khaletski.practice.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // @GetMapping("/new")
    // public String newPerson(Model model) {
    //     model.addAttribute("person", new Person());
    //     return "persons/newPerson";
    // }

     @GetMapping("/new")
     public String newPerson(@ModelAttribute("person") Person person) {
         return "persons/newPerson";
     }


    @PostMapping("/persons")
    public String createPerson(@ModelAttribute("person") Person person) {
        personDao.addPersonToList(person);
        return "redirect:/persons";
    }

    @GetMapping("/{id}/edit")
    public String editPerson(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDao.getPersonFromListById(id));
        return "persons/editPerson";
    }

    @PatchMapping("/{id}")
    public String updatePerson(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        personDao.editPersonInList(id, person);
        return "redirect:/persons";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        personDao.removePersonFromList(id);
        return "redirect:/persons";
    }
}
