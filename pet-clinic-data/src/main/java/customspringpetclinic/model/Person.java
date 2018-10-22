package customspringpetclinic.model;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass//we will never use pure person POJO
public class Person extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")//redundant, but explicit
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
