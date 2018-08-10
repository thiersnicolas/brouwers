package be.vdab.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;
import be.vdab.valueobjects.BeginNaamForm;

@Controller
@RequestMapping("/brouwers")
public class BrouwerController {
	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BEGINNAAM_VIEW = "brouwers/beginnaam";
	private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
	private static final String ALFABET_VIEW = "brouwers/alfabet";
	private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/brouwers";

	private final char[] alfabet = new char['Z' - 'A' + 1];

	private final BrouwerService brouwerService;

	public BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			alfabet[letter - 'A'] = letter;
		}
	}

	@GetMapping
	ModelAndView brouwers() {
		return new ModelAndView(BROUWERS_VIEW, "brouwers", brouwerService.findAll());
	}

	@GetMapping("beginnaam")
	ModelAndView findByName() {
		return new ModelAndView(BEGINNAAM_VIEW).addObject(new BeginNaamForm());
	}

	@GetMapping(params = "beginNaam")
	ModelAndView findByName(@Valid BeginNaamForm beginNaamForm, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			return new ModelAndView(BEGINNAAM_VIEW).addObject("brouwers",
					brouwerService.findByName(beginNaamForm.getBeginNaam())).addObject(beginNaamForm);
		}
		return new ModelAndView(BEGINNAAM_VIEW);
	}

	@GetMapping("toevoegen")
	ModelAndView createForm() {
		return new ModelAndView(TOEVOEGEN_VIEW).addObject(new Brouwer());
	}

	@GetMapping("alfabet")
	ModelAndView alfabet() {
		return new ModelAndView(ALFABET_VIEW, "alfabet", alfabet);
	}

	@GetMapping("alfabet/{letter}")
	ModelAndView alfabetLetter(@PathVariable String letter) {
		return new ModelAndView(ALFABET_VIEW, "brouwers", brouwerService.findByName(letter))
				.addObject("gekozenletter", letter).addObject("alfabet", alfabet);
	}
	
	@PostMapping
	ModelAndView create(@Valid Brouwer brouwer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView(TOEVOEGEN_VIEW).addObject(brouwer);
		} else {
			brouwerService.create(brouwer);
			return new ModelAndView(REDIRECT_URL_NA_TOEVOEGEN);
		}
	}
	
	@InitBinder("brouwer")
	void initBinder(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
	
}
