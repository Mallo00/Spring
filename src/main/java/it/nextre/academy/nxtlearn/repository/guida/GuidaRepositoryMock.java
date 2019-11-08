package it.nextre.academy.nxtlearn.repository.guida;

import it.nextre.academy.nxtlearn.model.Guida;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GuidaRepositoryMock {

    private List<Guida> db = new ArrayList<>();

}//end class
