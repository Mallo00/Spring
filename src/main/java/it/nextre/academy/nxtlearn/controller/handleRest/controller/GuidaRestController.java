package it.nextre.academy.nxtlearn.controller.handleRest.controller;

import it.nextre.academy.nxtlearn.exception.BadRequestException;
import it.nextre.academy.nxtlearn.exception.GuidaNotFoundException;
import it.nextre.academy.nxtlearn.model.Guida;
import it.nextre.academy.nxtlearn.service.guida.GuidaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/guidaRest")
public class GuidaRestController {
    @Autowired
    GuidaServiceImpl guidaService = new GuidaServiceImpl();
    // todo creare un bean conosciuto da spring in modo da collegarlo al logger
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping({"/findById/{id}", "/{id}", "/getById/{id}", "/get/{id}"})
    public Optional<Guida> getByID(@PathVariable("id") Integer id) {
        logger.info("LOG: getById, id=" + id);
        Optional<Guida> tmp = guidaService.findById(id);
        if (tmp != null) {
            return tmp;
        } else {
            throw new GuidaNotFoundException();
        }
    }

    @GetMapping({"/", "/all", ""})
    public List<Guida> getGuide() {
        logger.info("Log: getGuide()");
        return guidaService.getGuide();
    }

    @PutMapping("/update/{id}")
    public Guida editOne(@RequestBody Guida p, @PathVariable("id") Integer id) {
        logger.info("Log: update()");
        if (p != null && p.getId().equals(id)) {
            Guida tmp = guidaService.update(p);
            if (tmp != null) {
                return tmp;
            } else {
                throw new GuidaNotFoundException();
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @PostMapping({"/add", "/create"})
    public Guida addOne(@RequestBody @Valid Guida tmp, BindingResult validator) {
        logger.debug("LOG: addOne()");
        if (validator.hasErrors()) {
            logger.debug("LOG: validator.hasErrors()");
            String errs = validator.getAllErrors()
                    .stream()
                    .map(e -> e.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            throw new BadRequestException(errs);
        }
        if (tmp != null) {
            guidaService.newGuida(tmp);
        }
        return tmp;
    }

    @DeleteMapping({"/removeById/{id}", "/deleteById/{id}"})
    public Optional<Guida> deleteById(@PathVariable("id") Integer id) {
        logger.info("LOG: deleteById, id=" + id);
        Optional<Guida> tmp = guidaService.findById(id);
        if (tmp != null) {
            guidaService.deleteById(id);
            return tmp;
        } else {
            throw new GuidaNotFoundException();
        }
    }
}//end class
