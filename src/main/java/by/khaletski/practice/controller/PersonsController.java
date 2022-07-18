package by.khaletski.practice.controller;

import by.khaletski.practice.dao.PersonDao;
import by.khaletski.practice.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String createPerson(@ModelAttribute("person") @Valid Person person,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "persons/newPerson";
        personDao.addPersonToList(person);
        return "redirect:/persons";
    }

    @GetMapping("/{id}/edit")
    public String editPerson(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDao.getPersonFromListById(id));
        return "persons/editPerson";
    }

    // The BindingResult object should be placed right after the object with the @Valid annotation
    @PatchMapping("/{id}")
    public String updatePerson(@ModelAttribute("person") @Valid Person person,
                               BindingResult bindingResult,
                               @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) return "persons/editPerson";
        personDao.editPersonInList(id, person);
        return "redirect:/persons";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        personDao.removePersonFromList(id);
        return "redirect:/persons";
    }
}
