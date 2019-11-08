package it.nextre.academy.nxtlearn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "guida")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guida extends BaseEntity {

    @ManyToMany(mappedBy = "guide")
    private List<Persona> persone;

    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 255, message = "Nome guida compreso fra 1 e 255 caratteri")
    private String nome;


    @Size(min = 1, max = 255, message = "URL guida compreso max 255 caratteri")
    private String url;

    @Type(type = "text")
    private String descrizione;

    @Size(max = 255, message = "Path immagiine max 255 caratteri")
    private String imgPath;

    @ManyToOne
    private Livello livello;

}//end class
