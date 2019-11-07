package it.nextre.academy.nxtlearn.controller.handle.controller;

import it.nextre.academy.nxtlearn.exception.PersonaNotFoundException;
import it.nextre.academy.nxtlearn.model.Persona;
import it.nextre.academy.nxtlearn.service.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/persona")//rotta
public class PersonaController {
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    PersonaService personaService;

    @GetMapping
    public String getPersone(Model model) {
        logger.info("Log: getPersone()");
        model.addAttribute("persone", personaService.getPersone());
        return "persone.html";
    }

    @GetMapping("/new")//rotta dopo persona
    public String getNewPersona(Model model) {
        logger.info("Log: getNewPersona()");
        model.addAttribute("persona", personaService.getRandom());
        return "persona.html";
    }

    @GetMapping("/new/{qta}")//rotta dopo persona
    public String getNewPersone(Model model, @PathVariable("qta") Integer qta) {
        logger.info("Log: getNewPersone(), qta=" + qta);
        model.addAttribute("persone", personaService.getRandoms(qta));
        return "persone.html";
    }



    @GetMapping({"/findById/{id}", "/{id}", "/getById/{id}"})
    public String getByID(@PathVariable("id") Integer id) {
        logger.info("LOG: getById, id=" + id);
        Persona tmp = personaService.getById(id);
        if (tmp != null) {
            return "persona.html";
        } else {
            //logger.warn("LOG: getById, id=" + id);
            throw new PersonaNotFoundException();
        }
    }


}//end class
