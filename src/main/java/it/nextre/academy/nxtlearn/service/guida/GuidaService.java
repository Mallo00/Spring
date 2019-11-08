package it.nextre.academy.nxtlearn.service.guida;

import it.nextre.academy.nxtlearn.model.Guida;

import java.util.List;
import java.util.Optional;

public interface GuidaService {

    //Guida getRandom();

    // List<Guida> getRandoms(Integer numero);

    List<Guida> getGuide();

    Optional<Guida> findById(Integer id);

    Guida newGuida(Guida g);

    Guida update(Guida g);

    boolean deleteById(Integer id);


/*
    boolean deleteById(Integer id);

    Guida create(Guida p);

    Guida newGuida(Guida tmp);

    Guida update(Guida p);

 */
}
