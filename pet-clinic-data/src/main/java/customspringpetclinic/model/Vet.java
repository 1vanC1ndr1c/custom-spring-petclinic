package customspringpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)//by default, many will be lazy.
    //EAGER = load all at once
    @JoinTable(name = "vet_specialties",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))//important stuff
    private Set<Speciality> specialities = new HashSet<>();
}
