package com.duongvantien.controller;

import com.duongvantien.model.Person;
import com.duongvantien.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by tienduongvan on 25/03/2017.
 *
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String findAll(Model model, Integer offset, Integer maxResults) {
        List<Person> list = personService.findAll(offset, maxResults);
        System.out.println("------------------ list size :"+list.size());
        model.addAttribute("count", personService.count());
        System.out.println(" --------------count : "+personService.count());
        model.addAttribute("offset", offset);
        model.addAttribute("listPersons", list);
        return "persons";
    }
}
