package customspringpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

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
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    //inverse of relationship from 'pet'
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
