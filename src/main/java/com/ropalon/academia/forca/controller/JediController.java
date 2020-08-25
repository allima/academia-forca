package com.ropalon.academia.forca.controller;

import com.ropalon.academia.forca.model.Jedi;
import com.ropalon.academia.forca.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class JediController {
    @Autowired
    private JediRepository jediRepository;

    @GetMapping("/jedi")
    public ModelAndView jedi() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        modelAndView.addObject("allJedi", jediRepository.getAllJedi());
        return modelAndView;
    }


    @GetMapping("/new-jedi")
    public ModelAndView newJedi(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-jedi");
        return modelAndView.addObject("jedi", new Jedi());
    }

    @PostMapping("/jedi")
    public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            return "new-jedi";
        }
            jediRepository.add(jedi);

        redirectAttributes.addFlashAttribute("message", "Jedi cadastro com sucesso");
        return "redirect:jedi";


    }
}
