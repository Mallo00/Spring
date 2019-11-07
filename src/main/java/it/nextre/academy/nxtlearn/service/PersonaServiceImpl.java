package it.nextre.academy.nxtlearn.service;

import it.nextre.academy.nxtlearn.model.Persona;
import it.nextre.academy.nxtlearn.myUtil.DummyData;
import it.nextre.academy.nxtlearn.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;


//centralizzo il punto di controllo


    @Override
    public Persona getById(Integer id) {
        Persona p = personaRepository.findById(id);
        return p;
    }

    public Persona getRandom() {
        Persona p = new Persona();
        p.setNome(DummyData.getNome());
        p.setCognome(DummyData.getCognome());
        p = personaRepository.save(p);
        return p;
    }

    @Override
    public List<Persona> getPersone() {
        return personaRepository.getAll();
    }

    @Override
    public List<Persona> getRandoms(Integer numero) {
        List<Persona> tmp = new ArrayList<>();
        for (int i = 0; i < numero; i++) {
            tmp.add(getRandom());
        }
        return tmp;
    }

    @Override
    public boolean deleteById(Integer id) {
        return personaRepository.deleteById(id);
    }

    @Override
    public Persona newPersona(Persona p) {
        if (p != null && p.getId() == null) {
            p = personaRepository.save(p);
            return p;
        }
        return null;
    }

    @Override
    public Persona update(Persona p) {
        if (p!=null&&getById(p.getId())!=null){
            return personaRepository.save(p);
        }
        return null;
    }

    @Override
    public Persona create(Persona p) {
        return personaRepository.create(p);
    }

}//end class
