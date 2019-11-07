package it.nextre.academy.nxtlearn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona implements Cloneable {
    @Id
    @Min(value = 1, message = "Id non valido")
    private Integer id;
    @Column(nullable = false)
    @NotBlank(message = "Nome non valido")
    @Size(min = 2, message = "Almeno due caratteri")
    private String nome;
    @Column(nullable = false)
    @Size(min = 1, max = 16, message = "Cognome compreso fra 1 e 16 lettere")
    private String cognome;

    @Override
    public Persona clone() {
        return new Persona(this.id, this.nome, this.cognome);
    }

    public void setNome(String nome) {
        this.nome = nome.strip();
    }

    public void setCognome(String cognome) {
        this.cognome = cognome.strip();
    }
}//end class
