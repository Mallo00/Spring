package it.nextre.academy.nxtlearn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass //i suoi campi sono ereditati nelle tabelle delle classi figlie
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Temporal(TemporalType.TIMESTAMP) //tipo nel db
    @Column(name = "data_creazione", updatable = false)
    Date dataCrezione;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_modifica", insertable = false)
    Date dataModifica;

    @PrePersist
        //prima di salvare
    void doCreate() {
        this.dataCrezione = new Timestamp((new Date().getTime()));
    }

    @PreUpdate
        //prima di aggiornare
    void doUpdate() {
        this.dataModifica = new Timestamp((new Date().getTime()));
    }

    public void setId(Integer id) {
        this.id = id;
    }

}//end class
