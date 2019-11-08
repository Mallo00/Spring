package it.nextre.academy.nxtlearn.service.livello;

import it.nextre.academy.nxtlearn.model.Livello;

import java.util.List;
import java.util.Optional;

public interface LivelloService {

    //Livello getRandom();

    // List<Livello> getRandoms(Integer numero);

    List<Livello> getLivelli();

    Optional<Livello> findById(Integer id);


/*
    boolean deleteById(Integer id);

    Livello create(Livello p);

    Livello newLivello(Livello tmp);

    Livello update(Livello p);

 */
}
