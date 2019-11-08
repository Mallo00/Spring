package it.nextre.academy.nxtlearn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value = 1, message = "Id non valido")
    private Integer id;
    @Column(nullable = false)
    @NotBlank(message = "Nome non valido")
    @Size(min = 2, max = 128, message = "Almeno due caratteri")//validation
    private String nome;
    @Column(nullable = false, length = 255)//column
    @Size(min = 1, max = 128, message = "Cognome compreso fra 1 e 16 lettere")
    private String cognome;


    @ManyToMany
    @JoinTable(name = "rel_persone_guide",
            joinColumns = @JoinColumn(//del modello su cui sto lavorando qual è il campo che nella tabela remota rappresenta quella corrente
                    //nome colonna DB
                    name = "persona_id"
            ),
            //nome proprieta'
            inverseJoinColumns = @JoinColumn(
                    name = "guida_id"
            )
    )
    private Set<Guida> guide;

    @Override
    public Persona clone() {
        return new Persona(this.id, this.nome, this.cognome, this.guide);
    }

    public void setNome(String nome) {
        this.nome = nome.strip();
    }

    public void setCognome(String cognome) {
        this.cognome = cognome.strip();
    }
}//end class
