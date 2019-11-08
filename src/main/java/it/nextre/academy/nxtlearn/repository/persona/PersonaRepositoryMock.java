package it.nextre.academy.nxtlearn.repository.persona;

import it.nextre.academy.nxtlearn.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonaRepositoryMock {

    private List<Persona> db = new ArrayList<>();

    {
        db.add(new Persona(1, "Mario", "Red", new HashSet<>()));
        db.add(new Persona(2, "Michele", "Bossi", new HashSet<>()));
        db.add(new Persona(3, "Michela", "Manelli", new HashSet<>()));
        db.add(new Persona(4, "Gino", "Brunetta", new HashSet<>()));
        db.add(new Persona(5, "Maria", "Vongola", new HashSet<>()));
        db.add(new Persona(6, "Gina", "Branzino", new HashSet<>()));
    }

    public Persona save(Persona p) {
        if (p.getId() != null && p.getId() > 0) {
            if (db.stream()
                    .map(persona -> persona.getId())
                    .collect(Collectors.toList())
                    .contains(p.getId())) {
                //posso aggiornare
                Persona tmp = db.stream()
                        .filter(per -> per.getId().equals(p.getId()))
                        .findFirst()
                        .get();
                tmp.setNome(p.getNome());
                tmp.setCognome(p.getCognome());
                return tmp.clone();
            } else {
                System.out.println("La persona non esiste ma volevo aggiornare");
                return null;
            }

        } else {
            //devo inserire
            //calcolare nuovo id
            p.setId(1 + db.stream()
                    .map(persona -> persona.getId())
                    .max(Integer::compareTo)
                    .orElse(0));

        }
        db.add(p);
        return p.clone();
    }


    public List<Persona> findAll() {
        List<Persona> tmp = new ArrayList<>();
        for (Persona p :
                db) {
            tmp.add(p);
        }
        return tmp;
    }

    public Optional<Persona> findById(Integer id) {
        Persona tmp = db.stream()
                .filter(persona -> persona.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (tmp != null)
            return Optional.of(tmp.clone());
        else
            return null;
    }

    public void deleteById(Integer id) {
        Persona tmp = findById(id).orElse(null);
        if (tmp != null) {
            if (!db.remove(tmp)) {
                // lancio perchè il metodo è void e posso comunicare il fallimento solo così
                throw new RuntimeException();
            }
        }
    }
/*
    public Persona create(Persona p) {
        p.setId(1 + db.stream()
                .map(per -> per.getId())
                .max(Integer::compareTo)
                .orElse(0));
        db.add(p);
        return p.clone();
    }

 */
}//end class
