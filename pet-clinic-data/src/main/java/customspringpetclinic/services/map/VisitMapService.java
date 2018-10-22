package customspringpetclinic.services.map;

import com.sun.xml.internal.bind.v2.model.core.ID;
import customspringpetclinic.model.Visit;
import customspringpetclinic.repositories.VisitRepository;
import customspringpetclinic.services.VisitService;

import java.util.Set;


public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {


    private final VisitRepository visitRepository;

    public VisitMapService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit object) {

        if (object.getPet() == null || object.getPet().getOwner() == null || object.getPet().getId() == null
                || object.getPet().getOwner().getId() == null)
            throw new RuntimeException("Invalid Visit");

        return super.save(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
