package customspringpetclinic.services.map;

import customspringpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final long ownerId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();

        assertEquals(ownerId, owners.size());
    }


    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        //assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {

        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());
    }


    @Test
    void findByLastName() {

        Owner smith = ownerMapService.findByLastName(lastName);

        assertNotNull(smith);

       //assertEquals(ownerId, smith.getId());

    }

    @Test
    void findByLastNameNotFound() {

        Owner smith = ownerMapService.findByLastName("foo");

        assertNull(smith);

    }
}