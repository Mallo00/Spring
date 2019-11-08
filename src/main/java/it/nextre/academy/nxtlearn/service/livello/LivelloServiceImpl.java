package it.nextre.academy.nxtlearn.service.livello;

import it.nextre.academy.nxtlearn.model.Livello;
import it.nextre.academy.nxtlearn.repository.livello.LivelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivelloServiceImpl implements LivelloService {
    @Autowired
    LivelloRepository livelloRepository;


//centralizzo il punto di controllo


    /*
        public Livello getRandom() {
            Livello p = new Livello();
            p = livelloRepository.save(p);
            return p;
        }

     */


    @Override
    public List<Livello> getLivelli() {
        return livelloRepository.findAll();
    }

    @Override
    public Optional<Livello> findById(Integer id) {
        Optional<Livello> l = Optional.of(livelloRepository.findById(id).orElse(null));
        return l;
    }

    /*
    @Override
    public List<Livello> getRandoms(Integer numero) {
        List<Livello> tmp = new ArrayList<>();
        for (int i = 0; i < numero; i++) {
            tmp.add(getRandom());
        }
        return tmp;
    }
/*
    @Override
    public boolean deleteById(Integer id) {
        if (id != null && id >= 0) {
            try {
                livelloRepository.deleteById(id);
            } catch (RuntimeException e) {
                // Simulo il return false dal mock
                return false;
            }
        }
        return false;
    }

    @Override
    public Livello newLivello(Livello p) {
        if (p != null && p.getId() == null) {
            p = livelloRepository.save(p);
            return p;
        }
        return null;
    }

    @Override
    public Livello update(Livello p) {
        if (p != null && findById(p.getId()) != null) {
            return livelloRepository.save(p);
        }
        return null;
    }

    @Override
    public Livello create(Livello p) {
        return livelloRepository.save(p);
    }*/

}//end class
