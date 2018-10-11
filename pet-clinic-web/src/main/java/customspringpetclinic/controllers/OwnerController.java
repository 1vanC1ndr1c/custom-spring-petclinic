package customspringpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")//this one combines with the one below
@Controller
public class OwnerController {

    @RequestMapping({"/", "", "Index", "Index.html", "index", "index.html"})
    public String listOwners() {
        return "owners/index";
    }
}
