package customspringpetclinic.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


/**
 * LOMBOK
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
/**********/
//Serializable = turning objects into bytes
@MappedSuperclass//other classes gonna be inheriting this class, but we don't need this one specifically
//this object not to be created in DB, other entities will inherit it
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public boolean isNew() {
        return this.id == null;
    }
}
