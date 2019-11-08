package it.nextre.academy.nxtlearn.repository.livello;

import it.nextre.academy.nxtlearn.model.Livello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("livello-db-repo")
public interface LivelloRepository extends JpaRepository<Livello, Integer> {

}//end class
