package customspringpetclinic.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * LOMBOK
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
/**********/
@MappedSuperclass//we will never use pure person POJO
public class Person extends BaseEntity {

    public Person(Long id,String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")//redundant, but explicit
    private String lastName;
}
