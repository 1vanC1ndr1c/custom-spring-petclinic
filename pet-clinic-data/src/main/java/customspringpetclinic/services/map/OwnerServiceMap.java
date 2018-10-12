package customspringpetclinic.services.map;

import customspringpetclinic.model.Owner;
import customspringpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service// functionally, component and service are the same, but this indicates the behaviour
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    public Owner save(Owner object) {
        return super.save(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
