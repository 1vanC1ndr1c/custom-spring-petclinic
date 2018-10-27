package customspringpetclinic.controllers;

import customspringpetclinic.model.Owner;
import customspringpetclinic.model.PetType;
import customspringpetclinic.repositories.OwnerRepository;
import customspringpetclinic.repositories.PetRepository;
import customspringpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Ivan Cindric for custom-spring-petclinic
 * 27-Oct-18
 * 15:09
 **/
@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdateOwnerForm";
    private final PetRepository petService;
    private final OwnerRepository ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetRepository petService, OwnerRepository ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }


    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Optional<Owner> findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

}


