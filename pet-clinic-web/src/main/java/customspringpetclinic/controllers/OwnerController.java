package customspringpetclinic.controllers;

import customspringpetclinic.model.Owner;
import customspringpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@RequestMapping("/owners")//this one combines with the one below
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder//http variables to java objects
    public void setAllowedFields(WebDataBinder dataBinder) {
        //we don't allow the webforms to use id property
        //good for security
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/find")
    public String findOwners(Model model) {//by adding Model, Spring MVC will automatically add when method is called

        model.addAttribute("owner", Owner.builder().build());

        return "owners/findOwners";
    }

    @GetMapping()
    public String processFindForm(Owner owner, BindingResult bindingResult, Map<String, Object> model) {

        //allow paramertless GET requests for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName("");//empty string signifies broades possible search
        }
        //find owners by last name                              //underneath is SQL search
        List<Owner> results = ownerService.findAllByLastNameLike("%"+owner.getLastName()+"%");

        if (results.isEmpty()) {
            //no owners found
            bindingResult.rejectValue("lastName", "notFound", "not found");

            return "owners/findOwners";
        } else if (results.size() == 1) {
            //1 owner found
            owner = results.get(0);

            return "redirect:/owners/" + owner.getId();
        } else {
            //multiple owners found
            model.put("selections", results);

            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {

        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));

        return mav;
    }
}
