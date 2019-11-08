package it.nextre.academy.nxtlearn.service.guida;

import it.nextre.academy.nxtlearn.model.Guida;
import it.nextre.academy.nxtlearn.repository.guida.GuidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuidaServiceImpl implements GuidaService {
    @Autowired
    GuidaRepository guidaRepository;

    @Override
    public List<Guida> getGuide() {
        return guidaRepository.findAll();
    }

    @Override
    public Optional<Guida> findById(Integer id) {
        Optional<Guida> l = Optional.of(guidaRepository.findById(id).orElse(null));
        return l;
    }

    @Override
    public Guida newGuida(Guida g) {
        if (g != null && g.getId() == null) {
            g = guidaRepository.save(g);
            return g;
        }
        return null;
    }

    @Override
    public Guida update(Guida g) {
        if (g != null && findById(g.getId()) != null) {
            return guidaRepository.save(g);
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        if (id != null && id >= 0) {
            try {
                guidaRepository.deleteById(id);
            } catch (RuntimeException e) {
                // Simulo il return false dal mock
                return false;
            }
        }
        return false;
    }
//centralizzo il punto di controllo


    /*
        public Guida getRandom() {
            Guida p = new Guida();
            p = guidaRepository.save(p);
            return p;
        }

     */




    /*
    @Override
    public List<Guida> getRandoms(Integer numero) {
        List<Guida> tmp = new ArrayList<>();
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
                guidaRepository.deleteById(id);
            } catch (RuntimeException e) {
                // Simulo il return false dal mock
                return false;
            }
        }
        return false;
    }

    @Override
    public Guida newGuida(Guida p) {
        if (p != null && p.getId() == null) {
            p = guidaRepository.save(p);
            return p;
        }
        return null;
    }

    @Override
    public Guida update(Guida p) {
        if (p != null && findById(p.getId()) != null) {
            return guidaRepository.save(p);
        }
        return null;
    }

    @Override
    public Guida create(Guida p) {
        return guidaRepository.save(p);
    }*/

}//end class
