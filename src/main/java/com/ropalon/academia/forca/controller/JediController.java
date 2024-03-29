package com.ropalon.academia.forca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ropalon.academia.forca.model.Jedi;
import com.ropalon.academia.forca.repository.JediRepository;

import jakarta.validation.Valid;

@Controller
public class JediController {
	@Autowired
	private JediRepository jediRepository;

	@GetMapping("/jedi")
	public ModelAndView jedi() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jedi");

		modelAndView.addObject("allJedi", jediRepository.findAll());
		return modelAndView;
	}

	@GetMapping("/new-jedi")
	public ModelAndView newJedi() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("new-jedi");
		return modelAndView.addObject("jedi", new Jedi());
	}

	@PostMapping("/jedi")
	public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "new-jedi";
		}
		jediRepository.save(jedi);

		redirectAttributes.addFlashAttribute("message", "Jedi cadastro com sucesso");
		return "redirect:jedi";

	}
}
