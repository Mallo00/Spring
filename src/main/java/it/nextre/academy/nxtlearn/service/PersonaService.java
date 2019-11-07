package it.nextre.academy.nxtlearn.service;

import it.nextre.academy.nxtlearn.model.Persona;

import java.util.List;

public interface PersonaService {

    Persona getRandom();
    List<Persona> getRandoms(Integer numero);
    List<Persona> getPersone();
    Persona getById(Integer id);
    boolean deleteById(Integer id);
    Persona create(Persona p);

    Persona newPersona(Persona tmp);

    Persona update(Persona p);
}
