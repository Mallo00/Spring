package it.nextre.academy.nxtlearn.repository;

import it.nextre.academy.nxtlearn.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("persona-db-repo")
public interface PersonaRepositoryDB extends JpaRepository<Persona, Integer> {

    List<Persona> findAllByCOgnome(String cognome);

}//end class
