package customspringpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * LOMBOK
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
/**********/
@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity {
    @Column(name = "description")
    private String description;
}
