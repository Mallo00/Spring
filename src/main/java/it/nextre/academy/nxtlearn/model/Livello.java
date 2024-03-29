package it.nextre.academy.nxtlearn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "livello")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livello extends BaseEntity {
    @NotBlank // todo testare carattere invio se viene trimmato oppure no
    @NotEmpty
    private String descrizione;
    @Min(value = 1, message = "Descrizione valore minimo 1")
    @Max(value = 3, message = "Descrizione valore minimo 3")//è possibile localizzare nella lingia


    private Integer difficolta;
}//end class
