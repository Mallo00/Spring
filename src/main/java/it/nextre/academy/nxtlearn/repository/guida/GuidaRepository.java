package it.nextre.academy.nxtlearn.repository.guida;

import it.nextre.academy.nxtlearn.model.Guida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("guida-db-repo")
public interface GuidaRepository extends JpaRepository<Guida, Integer> {

}//end class
