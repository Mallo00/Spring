package it.nextre.academy.nxtlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller//segnaliamo la classe come controller
public class GenericController {
    //deve ricevere la richiesta get
    @GetMapping({"/","/home", "/index"})//arrivando dai seguenti indirizzi
    public String getHome(Model model) {
        model.addAttribute("dataora", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/mm/YYYY EEEE HH:MM:ss")));
        System.out.println("LOG: getHome()");//template. cattura dati e li restituisce elaborati
        model.addAttribute("dtobj", LocalDateTime.now());
        //estrazione del lotto
        List<Integer> numeri= Arrays.asList(12, 7, 4, 8, 25, 60);
        model.addAttribute("estratti", numeri);

        return "homeV1.html";
    }
}//end class
