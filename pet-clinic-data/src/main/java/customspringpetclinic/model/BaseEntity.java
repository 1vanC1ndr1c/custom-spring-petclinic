package customspringpetclinic.model;

import java.io.Serializable;

//Serializable = turning objects into bytes
public class BaseEntity implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
