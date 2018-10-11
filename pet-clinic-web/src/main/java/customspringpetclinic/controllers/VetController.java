package customspringpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"/vets", "/vets/index", "/vets/Index.html","/vets/index.html","/vets/Index"})
    public String listVets() {
        return "vets/index";//important
    }
}
