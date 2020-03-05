package com.example.petclinicapp.web;


import com.example.petclinicapp.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PetClinicController {

    @Autowired
    private PetClinicService petClinicService;

    @RequestMapping(value={"/","/index.html"})
    public String index(Model model)
    {

        return "index";
    }

    @RequestMapping(value="/login.html")
    public ModelAndView loginPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }


    @RequestMapping("/hello")
    @ResponseBody
    public String welcome()
    {
        return "Hello word Spring Boot";
    }


    @RequestMapping("/owner")
    public String getOwners(Model model) {

        model.addAttribute("owners", petClinicService.findOwnerss());
        return "owner";
    }


/*    @RequestMapping("/owners")
    public ModelAndView getOwners() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("owners", petClinicService.findOwnerss());
        mav.setViewName("owner");
        return mav;
    }*/
}
