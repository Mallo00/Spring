package it.nextre.academy.nxtlearn.service.persona;

import it.nextre.academy.nxtlearn.model.Persona;
import it.nextre.academy.nxtlearn.myUtil.DummyData;
import it.nextre.academy.nxtlearn.repository.persona.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;


//centralizzo il punto di controllo


    public Persona findById(Integer id) {
        Persona p = personaRepository.findById(id).orElse(null);
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
        return personaRepository.findAll();
    }

    @Override
    public Persona findByID(Integer id) {
        Persona p = personaRepository.findById(id).orElse(null);
        return p;
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
        if (id != null && id >= 0) {
            try {
                personaRepository.deleteById(id);
            } catch (RuntimeException e) {
                // Simulo il return false dal mock
                return false;
            }
        }
        return false;
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
        if (p != null && findById(p.getId()) != null) {
            return personaRepository.save(p);
        }
        return null;
    }

    @Override
    public Persona create(Persona p) {
        return personaRepository.save(p);
    }

}//end class
